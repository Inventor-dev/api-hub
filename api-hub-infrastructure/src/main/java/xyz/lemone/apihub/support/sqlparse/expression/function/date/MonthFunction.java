package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import java.util.Calendar;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * MonthFunction.
 * @author lemon
 */
public class MonthFunction extends CalendarFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		Calendar c = buildCalendar(dataList);
		int month=c.get(Calendar.MONTH)+1;
		return month+1;
	}

	@Override
	public String name() {
		return Functions.MONTH;
	}
}
