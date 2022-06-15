package xyz.lemone.apihub.support.sqlparse.expression.model.condition;

import xyz.lemone.apihub.support.sqlparse.context.BindData;
import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.manager.LogicalOperatorAsserters;
import xyz.lemone.apihub.support.sqlparse.expression.model.LogicalOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.BindDataListExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.NoneExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectExpressionData;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ObjectListExpressionData;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Jacky.gao
 * @since 2016年11月22日
 */
public abstract class BaseCondition implements Condition {
    protected LogicalOperator operator;
    private String operation;
    private Join join;
    private Condition nextCondition;
    private String left;
    private String right;
    protected Logger log = Logger.getAnonymousLogger();

    @Override
    public final boolean filter(Object obj, Context context) {
        Object left = computeLeft(obj, context);
        Object right = computeRight(obj, context);
        boolean result = LogicalOperatorAsserters.conditionEval(operator, left, right);
        if (join != null && nextCondition != null) {
            if (result) {
                if (join.equals(Join.and)) {
                    return nextCondition.filter(obj, context);
                } else {
                    return result;
                }
            } else {
                if (join.equals(Join.and)) {
                    return result;
                } else {
                    return nextCondition.filter(obj, context);
                }
            }
        }
        return result;
    }

    protected abstract Object computeLeft(Object obj, Context context);

    protected abstract Object computeRight(Object obj, Context context);

    public abstract ConditionType getType();

    protected Object extractExpressionData(ExpressionData<?> data) {
        if (data instanceof ObjectExpressionData) {
            return data.getData();
        } else if (data instanceof ObjectListExpressionData) {
            ObjectListExpressionData listData = (ObjectListExpressionData) data;
            List<?> list = listData.getData();
            return list;
        } else if (data instanceof BindDataListExpressionData) {
            BindDataListExpressionData bindData = (BindDataListExpressionData) data;
            List<BindData> bindDataList = bindData.getData();
            List<Object> list = new ArrayList<Object>();
            for (BindData bd : bindDataList) {
                Object v = bd.getValue();
                list.add(v);
            }
            if (list.size() == 1) {
                return list.get(0);
            } else if (list.size() == 0) {
                return null;
            }
            return list;
        } else if (data instanceof NoneExpressionData) {
            return null;
        }
        return null;
    }

    public void setLogicalOperator(LogicalOperator logicalOperator) {
        this.operator = logicalOperator;
    }

    public LogicalOperator getLogicalOperator() {
        return operator;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setNextCondition(Condition nextCondition) {
        this.nextCondition = nextCondition;
    }

    public void setJoin(Join join) {
        this.join = join;
    }

    public Join getJoin() {
        return join;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
