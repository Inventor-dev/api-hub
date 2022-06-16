package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

/**
 * BooleanExpression.
 *
 * @author lemon
 */
public class BooleanExpression extends BaseExpression {

    private static final long serialVersionUID = 1L;

    private Boolean value;

    public BooleanExpression(Boolean value) {
        this.value = value;
    }

    @Override
    public ExpressionData<Boolean> compute(Context context) {
        return new ObjectExpressionData(value);
    }

}
