package xyz.lemone.apihub.support.sqlparse.expression.assertor;


/**
 * NotEqualsAsserter.
 *
 * @author lemon
 */
public class NotEqualsAsserter extends AbstractAsserter {

    @Override
    public boolean eval(Object left, Object right) {
        if (left == null && right == null) {
            return false;
        }
        if (left == null || right == null) {
            return true;
        }
        right = buildObject(right);
        return !left.equals(right);
    }
}
