package xyz.lemone.apihub.support.sqlparse.expression.assertor;

import xyz.lemone.apihub.support.sqlparse.expression.assertor.Asserter;

import java.util.List;

/**
 * InAsserter.
 * @author lemon
 */
public class InAsserter implements Asserter {

    @Override
    public boolean eval(Object left, Object right) {
        if (left == null || right == null) {
            return false;
        }
        if (right instanceof List) {
            List<?> list = (List<?>) right;
            for (Object obj : list) {
                if (left.equals(obj)) {
                    return true;
                }
            }
            return false;
        } else if (right instanceof Object[]) {
            Object[] objs = (Object[]) right;
            for (Object obj : objs) {
                if (left.equals(obj)) {
                    return true;
                }
            }
            return false;
        } else if (right instanceof String) {
            String[] array = right.toString().split(",");
            for (String str : array) {
                if (left.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return left.equals(right);
    }
}