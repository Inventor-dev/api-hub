package xyz.lemone.apihub.support.sqlparse.toolkit;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import xyz.lemone.apihub.support.sqlparse.exception.ConvertException;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * ValueConvertHelper.
 *
 * @author lemon
 */
public class ValueConvertHelper {

    public static final String PROPERTY_SUFF = ".";

    public static Object getProperty(Object obj, String property) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof Map && property.indexOf(PROPERTY_SUFF) == -1) {
                Map<?, ?> map = (Map<?, ?>) obj;
                return map.get(property);
            }
            return PropertyUtils.getProperty(obj, property);
        } catch (Exception ex) {
            throw new ExpressionComputeException(ex);
        }
    }

    /**
     * 转换为 date.
     * @param obj data
     * @return date
     */
    public static Date toDate(Object obj) {
        if (obj instanceof Date) {
            return (Date) obj;
        } else if (obj instanceof String) {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sd.parse(obj.toString());
            } catch (Exception ex) {
                sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    return sd.parse(obj.toString());
                } catch (Exception e) {
                    throw new ConvertException("Can not convert " + obj + " to Date.");
                }
            }
        }
        throw new ConvertException("Can not convert " + obj + " to Date.");
    }

    /**
     * 转换为 BigDecimal.
     * @param obj data
     * @return BigDecimal
     */
    public static BigDecimal toBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        } else if (obj instanceof String) {
            if (StringUtils.EMPTY.equals(obj.toString().trim())) {
                return new BigDecimal(0);
            }
            try {
                String str = obj.toString().trim();
                return new BigDecimal(str);
            } catch (Exception ex) {
                throw new ConvertException("Can not convert " + obj + " to BigDecimal.");
            }
        } else if (obj instanceof Number) {
            Number n = (Number) obj;
            return new BigDecimal(n.doubleValue());
        }
        throw new ConvertException("Can not convert " + obj + " to BigDecimal.");
    }
}
