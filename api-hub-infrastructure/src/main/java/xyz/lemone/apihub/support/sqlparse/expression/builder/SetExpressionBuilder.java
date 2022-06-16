package xyz.lemone.apihub.support.sqlparse.expression.builder;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.set.FromToExpression;

import java.util.List;

/**
 * SetExpressionBuilder.
 *
 * @author lemon
 */
public class SetExpressionBuilder extends BaseExpressionBuilder {
    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        ConfigSqlParserParser.SetContext context = unitContext.set();
        BaseExpression setExpr = buildSetExpression(context);
        setExpr.setExpr(context.getText());
        return setExpr;
    }

    /**
     * buildSetExpression.
     * @param context 上下文
     * @return Expression
     */
    public BaseExpression buildSetExpression(ConfigSqlParserParser.SetContext context) {
        if (context instanceof ConfigSqlParserParser.RangeContext) {
            ConfigSqlParserParser.RangeContext ctx = (ConfigSqlParserParser.RangeContext) context;
            List<ConfigSqlParserParser.SetContext> sets = ctx.set();
            if (sets.size() != NumberUtils.INTEGER_TWO) {
                throw new ConfigSqlParseException("Range expression must have from and to expressions.");
            }
            BaseExpression fromExpr = buildSetExpression(sets.get(0));
            BaseExpression toExpr = buildSetExpression(sets.get(1));
            FromToExpression expr = new FromToExpression(fromExpr, toExpr);
            return expr;
        } else if (context instanceof ConfigSqlParserParser.SimpleDataContext) {
            ConfigSqlParserParser.SimpleDataContext ctx = (ConfigSqlParserParser.SimpleDataContext) context;
            ConfigSqlParserParser.SimpleValueContext valueContext = ctx.simpleValue();
            return parseSimpleValueContext(valueContext);
        }
        throw new ConfigSqlParseException("not know context : " + context);
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.set() != null;
    }
}
