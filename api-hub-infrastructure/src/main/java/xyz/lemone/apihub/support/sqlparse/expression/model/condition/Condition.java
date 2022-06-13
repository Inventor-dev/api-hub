package xyz.lemone.apihub.support.sqlparse.expression.model.condition;

import xyz.lemone.apihub.ureport.build.Context;

/**
 * Condition.
 * @author lemon
 */
public interface Condition {

    /**
     * filter.
     * @param obj     要判断的对象
     * @param context 上下文对象
     * @return 返回是否符合条件
     */
    boolean filter(Object obj, Context context);
}
