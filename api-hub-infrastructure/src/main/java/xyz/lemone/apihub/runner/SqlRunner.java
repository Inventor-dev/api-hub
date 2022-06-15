package xyz.lemone.apihub.runner;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.ExpressionParser;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import xyz.lemone.apihub.context.InterfaceConfig;
import xyz.lemone.apihub.datasource.IDataSourceLoader;

import javax.sql.DataSource;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * sql接口逻辑执行器.
 *
 * @author lemon
 */
@Component
public class SqlRunner implements IConfigurableRunner<InterfaceConfig, Object>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    @SuppressWarnings("unchecked")
    public Object run(IDataSourceLoader sourceLoader, InterfaceConfig config, Object param) {
        // 获取对应的sql 数据源
        String dataSourceTag = config.getDataSourceTag();
        DataSource dataSource = sourceLoader.loadDataSource();
        if (StringUtils.hasText(dataSourceTag)) {
            dataSource = sourceLoader.loadDataSource(dataSourceTag);
        }
        // 处理表达式转换SQL
        String sql = parseSql(config.getExecLogic(), null);
        // 执行sql 调用获取数据
        NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
        return jdbc.queryForList(sql, (Map<String, ?>) param);
    }

    public String parseSql(String sql, Map<String, Object> parameters) {
        sql = sql.trim();
        Context context = new Context(parameters);
        if (sql.startsWith(ExpressionParser.EXPR_PREFIX) && sql.endsWith(ExpressionParser.EXPR_SUFFIX)) {
            sql = sql.substring(2, sql.length() - 1);
            Expression expr = ExpressionParser.parseExpression(sql);
            sql = executeSqlExpr(expr, context);
            return sql;
        } else {
            String sqlForUse = sql;
            Pattern pattern = Pattern.compile("\\$\\{.*?\\}");
            Matcher matcher = pattern.matcher(sqlForUse);
            while (matcher.find()) {
                String substr = matcher.group();
                String sqlExpr = substr.substring(2, substr.length() - 1);
                Expression expr = ExpressionParser.parseExpression(sqlExpr);
                String result = executeSqlExpr(expr, context);
                sqlForUse = sqlForUse.replace(substr, result);
            }
            return sqlForUse;
        }
    }

    private String executeSqlExpr(Expression sqlExpr, Context context) {
        String sqlForUse = null;
        ExpressionData<?> exprData = sqlExpr.execute(context);
        if (exprData instanceof ObjectExpressionData) {
            ObjectExpressionData data = (ObjectExpressionData) exprData;
            Object obj = data.getData();
            if (obj != null) {
                String s = obj.toString();
                s = s.replaceAll("\\\\", "");
                sqlForUse = s;
            }
        }
        return sqlForUse;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
