package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * 自然数底数 e 的参数次方.
 * @author lemon
 */
public class ExpFunction extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		BigDecimal data=buildBigDecimal(dataList);
		return Math.exp(data.doubleValue());
	}

	@Override
	public String name() {
		return Functions.EXP;
	}
}
