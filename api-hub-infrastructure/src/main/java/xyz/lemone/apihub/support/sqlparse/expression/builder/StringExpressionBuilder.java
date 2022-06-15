package xyz.lemone.apihub.support.sqlparse.expression.builder;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.StringExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;


/**
 * StringExpressionBuilder.
 *
 * @author lemon
 */
public class StringExpressionBuilder implements ExpressionBuilder {

    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        String text = unitContext.STRING().getText();
        text = text.substring(NumberUtils.INTEGER_ONE, text.length() - NumberUtils.INTEGER_ONE);
        StringExpression stringExpr = new StringExpression(text);
        return stringExpr;
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.STRING() != null;
    }
}
