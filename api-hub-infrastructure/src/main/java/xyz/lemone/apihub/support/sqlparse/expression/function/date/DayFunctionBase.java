package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.Calendar;
import java.util.List;

/**
 * DayFunction.
 *
 * @author lemon
 */
public class DayFunctionBase extends BaseCalendarFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        Calendar c = buildCalendar(dataList);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    @Override
    public String name() {
        return Functions.DAY;
    }
}
