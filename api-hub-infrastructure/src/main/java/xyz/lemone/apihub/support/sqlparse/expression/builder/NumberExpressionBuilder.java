package xyz.lemone.apihub.support.sqlparse.expression.builder;

import java.math.BigDecimal;

import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.NumberExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * NumberExpressionBuilder.
 * @author lemon
 */
public class NumberExpressionBuilder implements ExpressionBuilder {

	@Override
	public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
		BigDecimal value= ValueConvertHelper.toBigDecimal(unitContext.NUMBER().getText());
		return new NumberExpression(value);
	}

	@Override
	public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
		return unitContext.NUMBER()!=null;
	}

}
