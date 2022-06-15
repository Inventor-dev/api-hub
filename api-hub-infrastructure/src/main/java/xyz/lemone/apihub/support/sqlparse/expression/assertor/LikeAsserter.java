package xyz.lemone.apihub.support.sqlparse.expression.assertor;

/**
 * LikeAsserter.
 *
 * @author lemon
 */
public class LikeAsserter implements Asserter {

    @Override
    public boolean eval(Object left, Object right) {
        if (left == null || right == null) {
            return false;
        }
        if (left.equals(right)) {
            return true;
        }
        return left.toString().indexOf(right.toString()) > -1;
    }

}
