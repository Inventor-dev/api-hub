package xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ExpressionBlock;
import xyz.lemone.apihub.ureport.build.Context;

/**
 * ElseIfExpression.
 *
 * @author lemon
 */
public class ElseIfExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private ExpressionConditionList conditionList;

    private ExpressionBlock expression;

    @Override
    public ExpressionData<?> compute(Context context) {
        return expression.execute(context);
    }

    public boolean conditionsEval(Context context) {
        return conditionList.eval(context);
    }

    public void setConditionList(ExpressionConditionList conditionList) {
        this.conditionList = conditionList;
    }

    public ExpressionBlock getExpression() {
        return expression;
    }

    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }
}
