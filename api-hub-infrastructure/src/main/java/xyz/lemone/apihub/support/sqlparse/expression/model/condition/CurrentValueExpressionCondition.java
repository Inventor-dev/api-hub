package xyz.lemone.apihub.support.sqlparse.expression.model.condition;

import org.codehaus.jackson.annotate.JsonIgnore;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.ureport.build.Context;

/**
 * CurrentValueExpressionCondition.
 * @author lemon
 */
public class CurrentValueExpressionCondition extends BaseCondition {

    private ConditionType type = ConditionType.current;
    @JsonIgnore
    private Expression rightExpression;

    @Override
    protected Object computeLeft(Object obj, Context context) {
        return obj;
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

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }
}
