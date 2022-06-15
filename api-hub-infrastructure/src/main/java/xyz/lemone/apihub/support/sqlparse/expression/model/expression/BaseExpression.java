package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.Context;

/**
 * BaseExpression.
 *
 * @author lemon
 */
public abstract class BaseExpression implements Expression {
    private static final long serialVersionUID = 1L;

    protected String expr;

    @Override
    public final ExpressionData<?> execute(Context context) {
        ExpressionData<?> data = compute(context);
        return data;
    }

    /**
     * compute.
     *
     * @param context
     * @return
     */
    public abstract ExpressionData<?> compute(Context context);

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return expr;
    }
}
