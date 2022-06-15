package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.context.Context;

import java.util.List;

/**
 * VariableAssignExpression.
 * @author lemon
 */
public class VariableAssignExpression extends BaseExpression {
    private static final long serialVersionUID = 435511939569866187L;
    private String variable;
    private Expression expression;

    @Override
    public ExpressionData<?> compute(Context context) {
        ExpressionData<?> data = expression.execute(context);
        Object obj = null;
        if (data instanceof ObjectExpressionData) {
            ObjectExpressionData d = (ObjectExpressionData) data;
            obj = d.getData();
        } else if (data instanceof ObjectListExpressionData) {
            ObjectListExpressionData d = (ObjectListExpressionData) data;
            obj = d.getData();
        } else if (data instanceof BindDataListExpressionData) {
            BindDataListExpressionData dataList = (BindDataListExpressionData) data;
            List<BindData> bindList = dataList.getData();
            if (bindList.size() == 1) {
                BindData bindData = bindList.get(0);
                obj = bindData.getValue();
            } else {
                StringBuilder sb = new StringBuilder();
                for (BindData bd : bindList) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(bd.getValue());
                }
                obj = sb.toString();
            }
        }
        if (obj != null) {
            context.putVariable(variable, obj);
        }
        return null;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
