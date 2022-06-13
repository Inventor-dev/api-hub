package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.ureport.Utils;
import xyz.lemone.apihub.ureport.build.BindData;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * FormatNumberFunction.
 *
 * @author lemon
 */
public class FormatNumberFunction implements Function {
    private final String defaultPattern = "#";

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null) {
            return "";
        }
        Object obj = null;
        String pattern = defaultPattern;
        if (dataList.size() == 1) {
            obj = buildExpressionData(dataList.get(0));
        } else if (dataList.size() > 1) {
            obj = buildExpressionData(dataList.get(0));
            Object patternData = buildExpressionData(dataList.get(1));
            if (patternData != null) {
                pattern = patternData.toString();
            }
        }

        if (obj == null) {
            throw new ExpressionComputeException("Function [formatnumber] need a number parameter at least");
        } else {
            BigDecimal bigData = Utils.toBigDecimal(obj);
            DecimalFormat df = new DecimalFormat(pattern);
            return df.format(bigData.doubleValue());
        }
    }

    private Object buildExpressionData(ExpressionData<?> data) {
        if (data instanceof ObjectListExpressionData) {
            ObjectListExpressionData listExpressionData = (ObjectListExpressionData) data;
            List<?> list = listExpressionData.getData();
            if (list.size() > 0) {
                return list.get(0);
            }
        } else if (data instanceof ObjectExpressionData) {
            return ((ObjectExpressionData) data).getData();
        } else if (data instanceof BindDataListExpressionData) {
            BindDataListExpressionData bindDataList = (BindDataListExpressionData) data;
            List<BindData> list = bindDataList.getData();
            if (list.size() > 0) {
                return list.get(0).getValue();
            }
        }
        return null;
    }

    @Override
    public String name() {
        return Functions.FORMAT_NUMBER;
    }
}
