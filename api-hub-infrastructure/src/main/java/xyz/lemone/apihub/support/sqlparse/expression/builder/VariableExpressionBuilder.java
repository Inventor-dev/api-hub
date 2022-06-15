package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.VariableExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * VariableExpressionBuilder.
 *
 * @author lemon
 */
public class VariableExpressionBuilder implements ExpressionBuilder {

    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        String text = unitContext.variable().Identifier().getText();
        VariableExpression varExpr = new VariableExpression(text);
        return varExpr;
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.variable() != null;
    }
}
