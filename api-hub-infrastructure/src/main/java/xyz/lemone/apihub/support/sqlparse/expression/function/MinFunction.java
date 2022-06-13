package xyz.lemone.apihub.support.sqlparse.expression.function;

import org.apache.commons.lang3.StringUtils;
import xyz.lemone.apihub.ureport.Utils;
import xyz.lemone.apihub.ureport.build.BindData;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.math.BigDecimal;
import java.util.List;

/**
 * MinFunction.
 *
 * @author lemon
 */
public class MinFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null || dataList.size() == 0) {
            return null;
        }
        BigDecimal value = null;
        for (ExpressionData<?> exprData : dataList) {
            if (exprData instanceof ObjectListExpressionData) {
                ObjectListExpressionData listExpr = (ObjectListExpressionData) exprData;
                List<?> list = listExpr.getData();
                for (Object obj : list) {
                    if (obj == null || StringUtils.isBlank(obj.toString())) {
                        continue;
                    }
                    BigDecimal bigData = Utils.toBigDecimal(obj);
                    if (value == null) {
                        value = bigData;
                    } else {
                        int result = value.compareTo(bigData);
                        if (result == 1) {
                            value = bigData;
                        }
                    }
                }
            } else if (exprData instanceof ObjectExpressionData) {
                Object obj = exprData.getData();
                if (obj != null && StringUtils.isNotBlank(obj.toString())) {
                    value = Utils.toBigDecimal(obj);
                }
            } else if (exprData instanceof BindDataListExpressionData) {
                BindDataListExpressionData bindDataList = (BindDataListExpressionData) exprData;
                List<BindData> list = bindDataList.getData();
                for (BindData bindData : list) {
                    Object obj = bindData.getValue();
                    if (obj == null || StringUtils.isBlank(obj.toString())) {
                        continue;
                    }
                    BigDecimal bigData = Utils.toBigDecimal(obj);
                    if (value == null) {
                        value = bigData;
                    } else {
                        int result = value.compareTo(bigData);
                        if (result == 1) {
                            value = bigData;
                        }
                    }
                }
            }
        }
        return value;
    }

    @Override
    public String name() {
        return Functions.MIN;
    }
}