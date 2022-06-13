package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * 余弦.
 * @author lemon
 */
public class CosFunction extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		BigDecimal data=buildBigDecimal(dataList);
		return Math.cos(data.doubleValue());
	}

	@Override
	public String name() {
		return Functions.COS;
	}
}
