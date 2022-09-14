package xyz.lemone.apihub.support.sqlparse.expression.function.string;

import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.function.Function;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.util.List;

/**
 * StringFunction.
 *
 * @author lemon
 */
public abstract class BaseStringFunction implements Function {
    protected String buildString(List<ExpressionData<?>> dataList) {
        if (dataList == null || dataList.size() == 0) {
            throw new ExpressionComputeException("Function [" + name() + "] need a data of string parameter.");
        }
        String result = null;
        ExpressionData<?> data = dataList.get(0);
        if (data instanceof ObjectListExpressionData) {
            ObjectListExpressionData listData = (ObjectListExpressionData) data;
            List<?> list = listData.getData();
            if (list == null || list.size() != 1) {
                throw new ExpressionComputeException("Function [" + name() + "] need a data of number parameter.");
            }
            Object obj = list.get(0);
            if (obj == null) {
                throw new ExpressionComputeException("Function [" + name() + "] parameter can not be null.");
            }
            result = obj.toString();
        } else if (data instanceof ObjectExpressionData) {
            ObjectExpressionData objData = (ObjectExpressionData) data;
            Object obj = objData.getData();
            if (obj == null) {
                throw new ExpressionComputeException("Function [" + name() + "] parameter can not be null.");
            }
            result = obj.toString();
        } else {
            throw new ExpressionComputeException("Function [" + name() + "] need a data of number parameter.");
        }
        return result;
    }
}
