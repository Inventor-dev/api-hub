package xyz.lemone.apihub.support.sqlparse.expression.assertor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * EqualsLessThenAsserter.
 *
 * @author lemon
 */
public class EqualsLessThenAsserter extends AbstractAsserter {

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
        return leftObj.compareTo(rightObj) < NumberUtils.INTEGER_ONE;
    }
}
