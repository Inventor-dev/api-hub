package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.Context;

/**
 * IntegerExpression.
 *
 * @author lemon
 */
public class IntegerExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;
    private Integer value;

    public IntegerExpression(Integer value) {
        this.value = value;
    }

    @Override
    public ExpressionData<?> compute(Context context) {
        return new ObjectExpressionData(value);
    }

}
