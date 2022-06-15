package xyz.lemone.apihub.support.sqlparse.expression.assertor;


/**
 * Assertor.
 * @author lemon
 */
public interface Asserter {

    /**
     * eval.
     * @param left
     * @param right
     * @return
     */
	boolean eval(Object left,Object right);

}
