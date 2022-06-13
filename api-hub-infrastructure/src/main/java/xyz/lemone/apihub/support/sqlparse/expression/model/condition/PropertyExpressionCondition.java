package xyz.lemone.apihub.support.sqlparse.expression.model.condition;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.ureport.Utils;
import xyz.lemone.apihub.ureport.build.Context;

/**
 * PropertyExpressionCondition.
 * @author lemon
 */
public class PropertyExpressionCondition extends BaseCondition {
    private ConditionType type = ConditionType.property;
    @JsonIgnore
    private String leftProperty;
    @JsonIgnore
    private Expression rightExpression;

    @Override
    protected Object computeLeft(Object obj, Context context) {
        if (StringUtils.isNotBlank(leftProperty)) {
            return Utils.getProperty(obj, leftProperty);
        } else {
            return obj;
        }
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

    public void setLeftProperty(String leftProperty) {
        this.leftProperty = leftProperty;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    public String getLeftProperty() {
        return leftProperty;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }
}
