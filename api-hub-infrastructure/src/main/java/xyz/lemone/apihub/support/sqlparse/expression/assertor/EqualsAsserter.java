package xyz.lemone.apihub.support.sqlparse.expression.assertor;

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
        if (left instanceof Number && right instanceof Number) {
            BigDecimal b1 = ValueConvertHelper.toBigDecimal(left);
            BigDecimal b2 = ValueConvertHelper.toBigDecimal(right);
            return b1.compareTo(b2) == 0;
        } else if (left instanceof Number) {
            BigDecimal b1 = ValueConvertHelper.toBigDecimal(left);
            BigDecimal b2 = null;
            try {
                b2 = ValueConvertHelper.toBigDecimal(right);
            } catch (Exception ex) {
            }
            if (b2 != null) {
                return b1.compareTo(b2) == 0;
            }
        } else if (right instanceof Number) {
            BigDecimal b1 = ValueConvertHelper.toBigDecimal(right);
            BigDecimal b2 = null;
            try {
                b2 = ValueConvertHelper.toBigDecimal(left);
            } catch (Exception ex) {
            }
            if (b2 != null) {
                return b1.compareTo(b2) == 0;
            }
        }
        right = buildObject(right);
        return left.equals(right);
    }
}
