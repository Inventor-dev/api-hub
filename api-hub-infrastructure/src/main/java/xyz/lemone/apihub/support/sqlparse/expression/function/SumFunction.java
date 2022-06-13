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
 * SumFunction.
 *
 * @author lemon
 */
public class SumFunction implements Function {

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        if (dataList == null || dataList.size() == 0) {
            return null;
        }
        Object singleData = null;
        BigDecimal total = new BigDecimal(0);
        for (ExpressionData<?> exprData : dataList) {
            if (exprData instanceof ObjectListExpressionData) {
                ObjectListExpressionData listExpr = (ObjectListExpressionData) exprData;
                List<?> list = listExpr.getData();
                for (Object obj : list) {
                    if (obj == null || StringUtils.isBlank(obj.toString())) {
                        continue;
                    }
                    singleData = obj;
                    BigDecimal bigData = Utils.toBigDecimal(obj);
                    total = total.add(bigData);
                }
            } else if (exprData instanceof ObjectExpressionData) {
                Object obj = exprData.getData();
                singleData = obj;
                if (obj != null && StringUtils.isNotBlank(obj.toString())) {
                    BigDecimal bigData = Utils.toBigDecimal(obj);
                    total = total.add(bigData);
                }
            } else if (exprData instanceof BindDataListExpressionData) {
                BindDataListExpressionData data = (BindDataListExpressionData) exprData;
                List<BindData> bindDataList = data.getData();
                for (BindData bindData : bindDataList) {
                    Object obj = bindData.getValue();
                    if (obj == null || StringUtils.isBlank(obj.toString())) {
                        continue;
                    }
                    singleData = obj;
                    BigDecimal bigData = Utils.toBigDecimal(obj);
                    total = total.add(bigData);
                }
            }
        }
        if (dataList.size() == 1) {
            if (singleData == null || singleData.equals("")) {
                return "";
            }
        }
        return total;
    }

    @Override
    public String name() {
        return Functions.SUM;
    }
}
