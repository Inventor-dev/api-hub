package xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.Join;

import java.util.List;

/**
 * ExpressionConditionList.
 *
 * @author lemon
 */
public class ExpressionConditionList {

    private List<ExpressionCondition> conditions;

    private List<Join> joins;

    public ExpressionConditionList(List<ExpressionCondition> conditions, List<Join> joins) {
        this.conditions = conditions;
        this.joins = joins;
    }

    public boolean eval(Context context) {
        if (conditions.size() == 1) {
            return conditions.get(0).eval(context);
        }
        for (int i = 0; i < conditions.size(); i++) {
            ExpressionCondition condition = conditions.get(i);
            boolean result = condition.eval(context);
            Join join = null;
            if (i < joins.size()) {
                join = joins.get(i);
            }
            if (join == null) {
                return result;
            } else {
                if (join.equals(Join.and) && !result) {
                    return false;
                }
                if (join.equals(Join.or) && result) {
                    return true;
                }
            }
        }
        return true;
    }

    public List<ExpressionCondition> getConditions() {
        return conditions;
    }
}
