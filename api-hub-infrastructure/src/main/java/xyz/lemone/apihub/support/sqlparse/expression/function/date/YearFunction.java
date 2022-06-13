package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import java.util.Calendar;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * YearFunction.
 * @author lemon
 */
public class YearFunction extends CalendarFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		Calendar c = buildCalendar(dataList);
		int year=c.get(Calendar.YEAR);
		return year;
	}

	@Override
	public String name() {
		return Functions.YEAR;
	}
}
