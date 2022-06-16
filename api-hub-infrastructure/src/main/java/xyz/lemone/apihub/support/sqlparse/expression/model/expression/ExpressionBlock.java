package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.List;

/**
 * ExpressionBlock.
 *
 * @author lemon
 */
public class ExpressionBlock extends BaseExpression {

    private static final long serialVersionUID = 1L;

    private List<Expression> expressionList;

    private Expression returnExpression;

    @Override
    public ExpressionData<?> compute(Context context) {
        ExpressionData<?> data = null;
        if (expressionList != null) {
            for (Expression expr : expressionList) {
                data = expr.execute(context);
            }
        }
        if (returnExpression != null) {
            data = returnExpression.execute(context);
        }
        return data;
    }

    public List<Expression> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(List<Expression> expressionList) {
        this.expressionList = expressionList;
    }

    public Expression getReturnExpression() {
        return returnExpression;
    }

    public void setReturnExpression(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }
}
