package xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ExpressionBlock;
import xyz.lemone.apihub.support.sqlparse.context.Context;

/**
 * ElseExpression.
 * @author lemon
 */
public class ElseExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private ExpressionBlock expression;

    @Override
    public ExpressionData<?> compute(Context context) {
        return expression.execute(context);
    }

    public ExpressionBlock getExpression() {
        return expression;
    }

    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
}
