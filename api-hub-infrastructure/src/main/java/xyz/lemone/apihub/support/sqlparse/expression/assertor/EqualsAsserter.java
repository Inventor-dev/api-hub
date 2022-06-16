package xyz.lemone.apihub.support.sqlparse.expression.assertor;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.exception.ConvertException;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.math.BigDecimal;

/**
 * EqualsAsserter.
 *
 * @author lemon
 */
public class EqualsAsserter extends AbstractAsserter {

    @Override
    public boolean eval(Object left, Object right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left instanceof Number || right instanceof Number) {
            try {
                BigDecimal b1 = ValueConvertHelper.toBigDecimal(left);
                BigDecimal b2 = ValueConvertHelper.toBigDecimal(right);
                return NumberUtils.INTEGER_ZERO == b1.compareTo(b2);
            } catch (ConvertException e) {
                // ignore convert error
            }
        }
        right = buildObject(right);
        return left.equals(right);
    }
}
