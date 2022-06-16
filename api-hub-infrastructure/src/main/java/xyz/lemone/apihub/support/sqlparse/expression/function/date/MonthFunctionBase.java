package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.Calendar;
import java.util.List;

/**
 * MonthFunction.
 *
 * @author lemon
 */
public class MonthFunctionBase extends BaseCalendarFunction {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        return buildCalendar(dataList).get(Calendar.MONTH) + NumberUtils.INTEGER_ONE;
    }

    @Override
    public String name() {
        return Functions.MONTH;
    }
}
