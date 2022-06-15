package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BooleanExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * BooleanExpressionBuilder.
 *
 * @author lemon
 */
public class BooleanExpressionBuilder implements ExpressionBuilder {
    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        String text = unitContext.BOOLEAN().getText();
        return new BooleanExpression(Boolean.valueOf(text));
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.BOOLEAN() != null;
    }
}
