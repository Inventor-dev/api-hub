package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.NullExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * NullExpressionBuilder.
 *
 * @author lemon
 */
public class NullExpressionBuilder implements ExpressionBuilder {

    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        return new NullExpression();
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.NULL() != null;
    }

}
