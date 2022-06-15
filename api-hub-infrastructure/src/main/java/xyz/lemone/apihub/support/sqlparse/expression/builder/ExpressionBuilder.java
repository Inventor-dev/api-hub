package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.UnitContext;

/**
 * ExpressionBuilder.
 * @author lemon
 */
public interface ExpressionBuilder {

    /**
     * build.
     *
     * @param unitContext
     * @return
     */
    BaseExpression build(UnitContext unitContext);

    /**
     * support.
     * @param unitContext
     * @return
     */
    boolean support(UnitContext unitContext);
}
