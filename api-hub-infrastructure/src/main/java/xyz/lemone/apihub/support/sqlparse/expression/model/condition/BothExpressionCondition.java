package xyz.lemone.apihub.support.sqlparse.expression.model.condition;

import org.codehaus.jackson.annotate.JsonIgnore;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;

/**
 * BothExpressionCondition.
 *
 * @author lemon
 */
public class BothExpressionCondition extends BaseCondition {
    private ConditionType type = ConditionType.expression;

    @JsonIgnore
    private Expression leftExpression;

    @JsonIgnore
    private Expression rightExpression;

    @Override
    protected Object computeLeft(Object obj, Context context) {
        ExpressionData<?> exprData = leftExpression.execute(context);
        return extractExpressionData(exprData);
    }

    @Override
    protected Object computeRight(Object obj, Context context) {
        ExpressionData<?> exprData = rightExpression.execute(context);
        return extractExpressionData(exprData);
    }

    @Override
    public ConditionType getType() {
        return type;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }
}
