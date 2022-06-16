package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;

import java.math.BigDecimal;

/**
 * NumberExpression.
 *
 * @author lemon
 */
public class NumberExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private BigDecimal value;

    public NumberExpression(BigDecimal value) {
        this.value = value;
    }

    @Override
    public ExpressionData<?> compute(Context context) {
        return new ObjectExpressionData(value.floatValue());
    }
}
