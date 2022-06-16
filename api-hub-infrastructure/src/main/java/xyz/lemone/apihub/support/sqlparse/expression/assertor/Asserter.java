package xyz.lemone.apihub.support.sqlparse.expression.assertor;

/**
 * Assertor.
 *
 * @author lemon
 */
public interface Asserter {

    /**
     * eval.
     *
     * @param left left
     * @param right right
     * @return true or false
     */
    boolean eval(Object left, Object right);

}
