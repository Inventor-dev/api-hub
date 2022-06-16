package xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ExpressionBlock;

import java.util.List;

/**
 * IfExpression.
 *
 * @author lemon
 */
public class IfExpression extends BaseExpression {
    private static final long serialVersionUID = 1L;

    private ExpressionConditionList conditionList;

    private ExpressionBlock expression;

    private List<ElseIfExpression> elseIfExpressions;

    private ElseExpression elseExpression;

    @Override
    public ExpressionData<?> compute(Context context) {
        if (conditionList != null) {
            boolean result = conditionList.eval(context);
            if (result) {
                return expression.execute(context);
            }
        }
        if (elseIfExpressions != null) {
            for (ElseIfExpression elseIfExpr : elseIfExpressions) {
                if (elseIfExpr.conditionsEval(context)) {
                    return elseIfExpr.execute(context);
                }
            }
        }
        if (elseExpression != null) {
            return elseExpression.execute(context);
        }
        return new ObjectExpressionData(null);
    }

    public void setConditionList(ExpressionConditionList conditionList) {
        this.conditionList = conditionList;
    }

    public ExpressionConditionList getConditionList() {
        return conditionList;
    }

    public void setElseExpression(ElseExpression elseExpression) {
        this.elseExpression = elseExpression;
    }

    public void setElseIfExpressions(List<ElseIfExpression> elseIfExpressions) {
        this.elseIfExpressions = elseIfExpressions;
    }

    public ExpressionBlock getExpression() {
        return expression;
    }

    public void setExpression(ExpressionBlock expression) {
        this.expression = expression;
    }

    public ElseExpression getElseExpression() {
        return elseExpression;
    }

    public List<ElseIfExpression> getElseIfExpressions() {
        return elseIfExpressions;
    }
}
