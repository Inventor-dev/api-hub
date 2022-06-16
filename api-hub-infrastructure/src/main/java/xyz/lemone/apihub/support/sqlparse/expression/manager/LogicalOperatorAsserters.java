package xyz.lemone.apihub.support.sqlparse.expression.manager;

import xyz.lemone.apihub.support.sqlparse.expression.assertor.Asserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.EqualsAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.EqualsGreatThenAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.EqualsLessThenAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.GreatThenAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.InAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.LessThenAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.LikeAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.NotEqualsAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.assertor.NotInAsserter;
import xyz.lemone.apihub.support.sqlparse.expression.model.LogicalOperator;

import java.util.HashMap;
import java.util.Map;

/**
 * LogicalOperatorAsserters.
 *
 * @author lemon
 */
public class LogicalOperatorAsserters {

    private static Map<LogicalOperator, Asserter> registerAsserters = new HashMap<>();

    static {
        registerAsserters.put(LogicalOperator.Equals, new EqualsAsserter());
        registerAsserters.put(LogicalOperator.EqualsGreatThen, new EqualsGreatThenAsserter());
        registerAsserters.put(LogicalOperator.EqualsLessThen, new EqualsLessThenAsserter());
        registerAsserters.put(LogicalOperator.GreatThen, new GreatThenAsserter());
        registerAsserters.put(LogicalOperator.LessThen, new LessThenAsserter());
        registerAsserters.put(LogicalOperator.NotEquals, new NotEqualsAsserter());
        registerAsserters.put(LogicalOperator.In, new InAsserter());
        registerAsserters.put(LogicalOperator.NotIn, new NotInAsserter());
        registerAsserters.put(LogicalOperator.Like, new LikeAsserter());
    }

    public static Map<LogicalOperator, Asserter> getAsserters() {
        return registerAsserters;
    }

    public static Asserter getAsserter(LogicalOperator operator) {
        return registerAsserters.get(operator);
    }

    /**
     * conditionEval.
     * @param operator logical operator
     * @param left left
     * @param right right
     * @return a bool value
     */
    public static boolean conditionEval(LogicalOperator operator, Object left, Object right) {
        Asserter asserter = getAsserter(operator);
        boolean result = asserter.eval(left, right);
        return result;
    }

}
