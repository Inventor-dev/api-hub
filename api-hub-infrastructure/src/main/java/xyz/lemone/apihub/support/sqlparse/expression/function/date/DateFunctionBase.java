package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * DateFunction.
 *
 * @author lemon
 */
public class DateFunctionBase extends BaseCalendarFunction {
    private String pattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        Date date = new Date();
        if (dataList.size() == 1) {
            ExpressionData<?> data = dataList.get(0);
            sd = buildPattern(data);
        }
        if (dataList.size() == 2) {
            Calendar c = buildCalendar(dataList);
            date = c.getTime();
            ExpressionData<?> data = dataList.get(1);
            sd = buildPattern(data);
        }
        return sd.format(date);
    }

    private SimpleDateFormat buildPattern(ExpressionData<?> data) {
        SimpleDateFormat sd = null;
        if (data instanceof ObjectExpressionData) {
            ObjectExpressionData objectData = (ObjectExpressionData) data;
            String newPattern = (String) objectData.getData();
            sd = new SimpleDateFormat(newPattern);
        } else {
            throw new ExpressionComputeException("Unknow date format pattern:" + data.getData());
        }
        return sd;
    }

    @Override
    public String name() {
        return Functions.DATE;
    }
}
