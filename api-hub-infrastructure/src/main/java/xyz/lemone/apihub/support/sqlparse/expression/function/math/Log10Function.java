package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * 以10为底的对数.
 * @author lemon
 */
public class Log10Function extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		BigDecimal data=buildBigDecimal(dataList);
		return Math.log10(data.doubleValue());
	}

	@Override
	public String name() {
		return Functions.LOG10;
	}
}
