package xyz.lemone.apihub.runner;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import xyz.lemone.apihub.context.InterfaceConfig;
import xyz.lemone.apihub.datasource.IDataSourceLoader;
import xyz.lemone.apihub.support.sqlparse.ExpressionParser;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;

import javax.sql.DataSource;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * sql接口逻辑执行器.
 *
 * @author lemon
 */
@Component
public class SqlRunner implements IConfigurableRunner<InterfaceConfig, Object> {

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

    /**
     * 转换sql.
     *
     * @param sql        配置的sql
     * @param parameters 参数
     * @return 需要的sql
     */
    public String parseSql(String sql, Map<String, Object> parameters) {
        sql = sql.trim();
        Context context = new Context(parameters);
        if (ExpressionParser.isExpressions(sql)) {
            sql = ExpressionParser.unwrapExpressions(sql);
            Expression expr = ExpressionParser.parseExpression(sql);
            sql = executeSqlExpr(expr, context);
            return sql;
        } else {
            String sqlForUse = sql;
            Matcher matcher = ExpressionParser.pattern.matcher(sqlForUse);
            while (matcher.find()) {
                String substr = matcher.group();
                String sqlExpr = ExpressionParser.unwrapExpressions(substr);
                Expression expr = ExpressionParser.parseExpression(sqlExpr);
                String result = executeSqlExpr(expr, context);
                sqlForUse = sqlForUse.replace(substr, result);
            }
            return sqlForUse;
        }
    }

    /**
     * 执行sql.
     * @param sqlExpr sql 表达式
     * @param context 上下文.
     * @return 需要的sql
     */
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

}
