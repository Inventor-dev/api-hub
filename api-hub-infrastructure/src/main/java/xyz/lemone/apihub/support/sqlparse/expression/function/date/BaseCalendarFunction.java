package xyz.lemone.apihub.support.sqlparse.expression.function.date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Function;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * CalendarFunction.
 *
 * @author lemon
 */
public abstract class BaseCalendarFunction implements Function {
    protected Calendar buildCalendar(List<ExpressionData<?>> dataList) {
        Date date = new Date();
        if (CollectionUtils.isNotEmpty(dataList)) {
            ExpressionData<?> data = dataList.get(NumberUtils.INTEGER_ZERO);
            if (data instanceof ObjectListExpressionData) {
                ObjectListExpressionData listData = (ObjectListExpressionData) data;
                List<?> list = listData.getData();
                if (Objects.isNull(list) || list.size() != NumberUtils.INTEGER_ONE) {
                    throw new ExpressionComputeException("Function [day] first parameter need a data of Date.");
                }
                Object obj = list.get(NumberUtils.INTEGER_ZERO);
                if (obj == null) {
                    throw new ExpressionComputeException("Function [day] first parameter can not be null.");
                }
                date = ValueConvertHelper.toDate(obj);
            } else if (data instanceof ObjectExpressionData) {
                ObjectExpressionData objData = (ObjectExpressionData) data;
                Object obj = objData.getData();
                if (obj == null) {
                    throw new ExpressionComputeException("Function [day] first parameter can not be null.");
                }
                date = ValueConvertHelper.toDate(obj);
            } else {
                throw new ExpressionComputeException("Function [day] first parameter need a data of Date.");
            }
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }
}
