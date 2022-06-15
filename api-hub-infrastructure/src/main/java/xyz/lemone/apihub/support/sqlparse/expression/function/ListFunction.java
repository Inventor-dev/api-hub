package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.util.ArrayList;
import java.util.List;

/**
 * ListFunction.
 *
 * @author lemon
 */
public class ListFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        List<Object> list = new ArrayList<Object>();
        for (ExpressionData<?> d : dataList) {
            if (d instanceof ObjectExpressionData) {
                ObjectExpressionData exprData = (ObjectExpressionData) d;
                list.add(exprData.getData());
            } else if (d instanceof ObjectListExpressionData) {
                ObjectListExpressionData listData = (ObjectListExpressionData) d;
                list.addAll(listData.getData());
            }
        }
        return list;
    }

    @Override
    public String name() {
        return Functions.LIST;
    }
}
