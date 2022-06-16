package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.Calendar;
import java.util.List;

/**
 * YearFunction.
 *
 * @author lemon
 */
public class YearFunctionBase extends BaseCalendarFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        return buildCalendar(dataList).get(Calendar.YEAR);
    }

    @Override
    public String name() {
        return Functions.YEAR;
    }
}
