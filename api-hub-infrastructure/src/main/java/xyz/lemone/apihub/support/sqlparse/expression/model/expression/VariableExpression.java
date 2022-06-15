package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.Context;

/**
 * VariableExpression.
 * @author lemon
 */
public class VariableExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private String text;

    public VariableExpression(String text) {
        this.text = text;
    }

    @Override
    public ExpressionData<?> compute(Context context) {
        Object obj = context.getVariable(text);
        return new ObjectExpressionData(obj);
    }
}
