package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.util.List;

/**
 * CountFunction.
 *
 * @author lemon
 */
public class CountFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null || dataList.size() == 0) {
            return null;
        }
        int size = 0;
        for (ExpressionData<?> data : dataList) {
            if (data instanceof ObjectListExpressionData) {
                ObjectListExpressionData listExpressionData = (ObjectListExpressionData) data;
                size += listExpressionData.getData().size();
            } else if (data instanceof ObjectExpressionData) {
                size++;
            } else if (data instanceof BindDataListExpressionData) {
                BindDataListExpressionData bindDataList = (BindDataListExpressionData) data;
                size += bindDataList.getData().size();
            }
        }
        return size;
    }

    @Override
    public String name() {
        return Functions.COUNT;
    }
}
