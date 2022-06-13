package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.util.List;
import java.util.Map;

/**
 * 参数方法.
 *
 * @author lemon
 * @Since 0.0.1
 */
public class ParameterFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null || dataList.size() < 1) {
            throw new ExpressionComputeException("Function [param] need one parameter.");
        }
        Object obj = null;
        ExpressionData<?> data = dataList.get(0);
        if (data instanceof ObjectExpressionData) {
            ObjectExpressionData objData = (ObjectExpressionData) data;
            obj = objData.getData();
        } else if (data instanceof ObjectListExpressionData) {
            ObjectListExpressionData listData = (ObjectListExpressionData) data;
            List<?> list = listData.getData();
            if (list.size() > 0) {
                obj = list.get(0);
            }
        }
        if (obj == null) {
            throw new ExpressionComputeException("Function [param] need one parameter.");
        }
        Map<String, Object> map = context.getParameters();
        if (map == null) {
            return null;
        }
        return map.get(obj.toString());
    }

    @Override
    public String name() {
        return Functions.PARAMETER_FUNCTION;
    }
}
