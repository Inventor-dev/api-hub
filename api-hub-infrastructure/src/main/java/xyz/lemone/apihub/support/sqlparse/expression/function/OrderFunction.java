package xyz.lemone.apihub.support.sqlparse.expression.function;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.Order;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * OrderFunction.
 *
 * @author lemon
 */
public class OrderFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null || dataList.size() != NumberUtils.INTEGER_TWO) {
            throw new ExpressionComputeException("Function [order] need two parameters");
        }
        boolean result = computeOrder(dataList);
        Order orderData = Order.asc;
        if (!result) {
            orderData = Order.desc;
        }
        final Order order = orderData;
        ExpressionData<?> firstData = dataList.get(NumberUtils.INTEGER_ZERO);
        if (firstData instanceof ObjectListExpressionData) {
            ObjectListExpressionData data = (ObjectListExpressionData) firstData;
            List<?> list = data.getData();
            Collections.sort(list, (Comparator<Object>) (data1, data2) -> doOrder(data1, data2, order));
            return list;
        } else if (firstData instanceof BindDataListExpressionData) {
            BindDataListExpressionData bindDataList = (BindDataListExpressionData) firstData;
            List<BindData> list = bindDataList.getData();
            List<Object> ls = new ArrayList<>();
            for (BindData bindData : list) {
                Object obj = bindData.getValue();
                if (obj != null) {
                    ls.add(obj);
                }
            }
            Collections.sort(ls, (data1, data2) -> doOrder(data1, data2, order));
            return ls;
        } else {
            return firstData.getData();
        }
    }

    private int doOrder(Object data1, Object data2, Order order) {
        if (data1 == null || data2 == null) {
            return NumberUtils.INTEGER_ONE;
        }
        if (data1 instanceof Date) {
            Date d1 = (Date) data1;
            Date d2 = (Date) data2;
            if (order.equals(Order.asc)) {
                return d1.compareTo(d2);
            } else {
                return d2.compareTo(d1);
            }
        } else if (data1 instanceof Number) {
            BigDecimal n1 = ValueConvertHelper.toBigDecimal(data1);
            BigDecimal n2 = ValueConvertHelper.toBigDecimal(data2);
            if (order.equals(Order.asc)) {
                return n1.compareTo(n2);
            } else {
                return n2.compareTo(n1);
            }
        } else {
            String str1 = data1.toString();
            String str2 = data2.toString();
            if (order.equals(Order.asc)) {
                return str1.compareTo(str2);
            } else {
                return str2.compareTo(str1);
            }
        }
    }

    private boolean computeOrder(List<ExpressionData<?>> dataList) {
        boolean order = false;
        ExpressionData<?> secondData = dataList.get(NumberUtils.INTEGER_ONE);
        if (secondData instanceof ObjectExpressionData) {
            ObjectExpressionData data = (ObjectExpressionData) secondData;
            Object obj = data.getData();
            if (obj == null) {
                throw new ExpressionComputeException("Function [order] second parameter can not be null");
            }
            if (obj instanceof Boolean) {
                order = (Boolean) obj;
                return order;
            }
            if (obj instanceof String) {
                order = Boolean.valueOf(obj.toString());
            } else {
                throw new ExpressionComputeException("Function [order] second parameter muse be boolean type.");
            }
        }
        return order;
    }

    @Override
    public String name() {
        return Functions.ORDER;
    }

}
