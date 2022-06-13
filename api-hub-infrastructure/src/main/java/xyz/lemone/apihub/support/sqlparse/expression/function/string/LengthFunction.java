package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * LengthFunction.
 *
 * @author lemon
 */
public class LengthFunction extends StringFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		String text=buildString(dataList);
		return text.length();
	}

	@Override
	public String name() {
		return Functions.LENGTH;
	}
}
