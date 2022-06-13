package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;


/**
 * UpperFunction.
 * @author lemon
 */
public class UpperFunction extends StringFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		String text=buildString(dataList);
		return text.toUpperCase();
	}

	@Override
	public String name() {
		return Functions.UPPER;
	}
}
