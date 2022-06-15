package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * @author Jacky.gao
 * @since 2017年1月24日
 */
public class TrimFunction extends StringFunction {
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		String text=buildString(dataList);
		return text.trim();
	}

	@Override
	public String name() {
		return Functions.TRIM;
	}
}
