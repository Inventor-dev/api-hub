package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import java.util.Calendar;
import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

/**
 * WeekFunction.
 * @author lemon
 */
public class WeekFunction extends CalendarFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context) {
		Calendar c = buildCalendar(dataList);
		int weekDay=c.get(Calendar.DAY_OF_WEEK);
		boolean isFirstSunday = (c.getFirstDayOfWeek() == Calendar.SUNDAY);
		if(isFirstSunday){
			weekDay = weekDay - 1;
			if(weekDay == 0){
				weekDay = 7;
			}
		}
		switch(weekDay){
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		case 7:
			return "星期日";
		}
		throw new ExpressionComputeException("Unknow week day :"+weekDay);
	}

	@Override
	public String name() {
		return Functions.WEEK;
	}
}
