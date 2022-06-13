package xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse;

import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;
import xyz.lemone.apihub.support.sqlparse.expression.model.LogicalOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.NoneExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.ureport.build.BindData;
import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.ureport.expression.ExpressionUtils;

import java.util.List;

/**
 * ExpressionCondition.
 *
 * @author lemon
 */
public class ExpressionCondition {

    private Expression left;

    private LogicalOperator operator;

    private Expression right;

    public ExpressionCondition(Expression left, LogicalOperator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public boolean eval(Context context) {
        ExpressionData<?> leftData = left.execute(context);
        ExpressionData<?> rightData = right.execute(context);
        Object leftObj = getData(leftData);
        Object rightObj = getData(rightData);
        return ExpressionUtils.conditionEval(operator, leftObj, rightObj);
    }

    private Object getData(ExpressionData<?> data) {
        if (data instanceof ObjectExpressionData) {
            ObjectExpressionData objData = (ObjectExpressionData) data;
            return objData.getData();
        } else if (data instanceof ObjectListExpressionData) {
            ObjectListExpressionData exprData = (ObjectListExpressionData) data;
            List<?> list = exprData.getData();
            StringBuffer sb = new StringBuffer();
            for (Object obj : list) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(obj);
            }
            return sb.toString();
        } else if (data instanceof NoneExpressionData) {
            return null;
        } else if (data instanceof BindDataListExpressionData) {
            BindDataListExpressionData bindDataList = (BindDataListExpressionData) data;
            List<BindData> list = bindDataList.getData();
            if (list.size() == 1) {
                return list.get(0).getValue();
            } else {
                StringBuffer sb = new StringBuffer();
                for (BindData bindData : list) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(bindData.getValue());
                }
                return sb.toString();
            }
        } else {
            throw new ExpressionComputeException("Unknow data : " + data);
        }
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
