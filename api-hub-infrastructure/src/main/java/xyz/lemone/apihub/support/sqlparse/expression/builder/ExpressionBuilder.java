package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.UnitContext;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;

/**
 * ExpressionBuilder.
 *
 * @author lemon
 */
public interface ExpressionBuilder {

    /**
     * build.
     *
     * @param unitContext unitContext.
     * @return Expression
     */
    BaseExpression build(UnitContext unitContext);

    /**
     * support.
     *
     * @param unitContext unitContext.
     * @return a bool
     */
    boolean support(UnitContext unitContext);
}
