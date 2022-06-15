package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.IntegerExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * IntegerExpressionBuilder.
 *
 * @author lemon
 */
public class IntegerExpressionBuilder implements ExpressionBuilder {

    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        Integer value = null;
        if (unitContext.INTEGER() != null) {
            value = Integer.valueOf(unitContext.INTEGER().getText());
        }
        return new IntegerExpression(value);
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.INTEGER() != null;
    }

}
