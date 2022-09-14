package xyz.lemone.apihub.support.sqlparse.expression.function;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * GetFunction.
 *
 * @author lemon
 */
public class GetFunction implements Function {

    public static final Integer PROPERTY_NAME_EXPRESSION_INDEX = 3;

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        int index = 1;
        String propertyName = null;
        List<Object> list = new ArrayList<>();
        if (dataList.size() >= NumberUtils.INTEGER_ONE) {
            buildList(dataList.get(NumberUtils.INTEGER_ZERO), list);
        }
        if (dataList.size() >= NumberUtils.INTEGER_TWO) {
            index = buildIndex(dataList.get(NumberUtils.INTEGER_ONE));
        }

        if (dataList.size() >= PROPERTY_NAME_EXPRESSION_INDEX) {
            ExpressionData<?> d = dataList.get(NumberUtils.INTEGER_TWO);
            if (d instanceof ObjectExpressionData) {
                ObjectExpressionData exprData = (ObjectExpressionData) d;
                Object obj = exprData.getData();
                if (obj != null) {
                    propertyName = obj.toString();
                }
            }
        }
        Object obj = null;
        if (CollectionUtils.isNotEmpty(list)) {
            if (index <= list.size()) {
                obj = list.get(index - NumberUtils.INTEGER_ONE);
            } else {
                obj = list.get(list.size() - NumberUtils.INTEGER_ONE);
            }
        }
        if (StringUtils.isNotBlank(propertyName)) {
            obj = ValueConvertHelper.getProperty(obj, propertyName);
        }
        return obj;
    }

    private int buildIndex(ExpressionData<?> d) {
        int index = 1;
        if (d instanceof ObjectExpressionData) {
            ObjectExpressionData exprData = (ObjectExpressionData) d;
            Object obj = exprData.getData();
            if (obj != null) {
                index = ValueConvertHelper.toBigDecimal(obj).intValue();
            }
        }
        return index;
    }

    private void buildList(ExpressionData<?> d, List<Object> list) {
        if (d instanceof ObjectExpressionData) {
            ObjectExpressionData exprData = (ObjectExpressionData) d;
            list.add(exprData.getData());
        } else if (d instanceof ObjectListExpressionData) {
            ObjectListExpressionData listData = (ObjectListExpressionData) d;
            list.addAll(listData.getData());
        } else if (d instanceof BindDataListExpressionData) {
            BindDataListExpressionData listData = (BindDataListExpressionData) d;
            for (BindData bindData : listData.getData()) {
                list.addAll(bindData.getDataList());
            }
        }
    }

    @Override
    public String name() {
        return Functions.GET;
    }
}
