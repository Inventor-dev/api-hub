package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.ureport.build.BindData;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * FormatDateFunction.
 *
 * @author lemon
 */
public class FormatDateFunction implements Function {
    private final String defaultPattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null) {
            return "";
        }
        Object obj = null;
        String pattern = defaultPattern;
        for (ExpressionData<?> data : dataList) {
            if (data instanceof ObjectListExpressionData) {
                ObjectListExpressionData listExpressionData = (ObjectListExpressionData) data;
                List<?> list = listExpressionData.getData();
                if (list.size() > 0) {
                    obj = list.get(0);
                }
                if (list.size() > 1) {
                    pattern = list.get(1).toString();
                }
            } else if (data instanceof ObjectExpressionData) {
                obj = ((ObjectExpressionData) data).getData();
            } else if (data instanceof BindDataListExpressionData) {
                BindDataListExpressionData bindDataList = (BindDataListExpressionData) data;
                List<BindData> list = bindDataList.getData();
                if (list.size() > 0) {
                    obj = list.get(0).getValue();
                }
                if (list.size() > 1) {
                    pattern = list.get(1).getValue().toString();
                }
            }
        }
        if (obj == null) {
            throw new ExpressionComputeException("Function [formatdate] need a Date type parameter at least");
        } else {
            if (obj instanceof Date) {
                SimpleDateFormat sd = new SimpleDateFormat(pattern);
                return sd.format((Date) obj);
            } else {
                throw new ExpressionComputeException("Function [formatdate] first parameter is Date type");
            }
        }
    }

    @Override
    public String name() {
        return Functions.FORMAT_DATE;
    }
}
