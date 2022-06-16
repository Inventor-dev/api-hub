package xyz.lemone.apihub.support.sqlparse.expression.assertor;

import org.apache.commons.lang.StringUtils;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.math.BigDecimal;

/**
 * LessThenAsserter.
 *
 * @author lemon
 */
public class LessThenAsserter extends AbstractAsserter {

    @Override
    public boolean eval(Object left, Object right) {
        if (left == null || right == null) {
            return false;
        }
        if (StringUtils.isBlank(left.toString()) || StringUtils.isBlank(right.toString())) {
            return false;
        }
        BigDecimal leftObj = ValueConvertHelper.toBigDecimal(left);
        right = buildObject(right);
        BigDecimal rightObj = ValueConvertHelper.toBigDecimal(right);
        return leftObj.compareTo(rightObj) == -1;
    }
}
