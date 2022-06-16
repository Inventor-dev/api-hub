package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

/**
 * StringExpression.
 *
 * @author lemon
 */
public class StringExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private String text;

    public StringExpression(String text) {
        this.text = text;
    }

    @Override
    public ExpressionData<?> compute(Context context) {
        return new ObjectExpressionData(text);
    }
}
