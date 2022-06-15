package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.NoneExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.Context;

/**
 * NullExpression.
 *
 * @author lemon
 */
public class NullExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    @Override
    public ExpressionData<?> compute(Context context) {
        return new NoneExpressionData();
    }

}
