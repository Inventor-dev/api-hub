package xyz.lemone.apihub.support.sqlparse.expression.assertor;

import java.math.BigDecimal;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;

import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

/**
 * EqualsGreatThenAsserter.
 * @author lemon
 */
public class EqualsGreatThenAsserter extends AbstractAsserter {
    @Override
    public boolean eval(Object left, Object right) {
        if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }
        if (StringUtils.isBlank(left.toString()) || StringUtils.isBlank(right.toString())) {
            return false;
        }
        BigDecimal leftObj = ValueConvertHelper.toBigDecimal(left);
        right = buildObject(right);
        BigDecimal rightObj = ValueConvertHelper.toBigDecimal(right);
        return leftObj.compareTo(rightObj) > -1;
    }
}
