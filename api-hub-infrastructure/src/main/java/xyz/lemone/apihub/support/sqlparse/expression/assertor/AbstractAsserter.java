package xyz.lemone.apihub.support.sqlparse.expression.assertor;

import java.util.List;
import java.util.Objects;

/**
 * AbstractAsserter.
 *
 * @author lemon
 */
public abstract class AbstractAsserter implements Asserter {

    protected Object buildObject(Object obj) {
        if (Objects.nonNull(obj)) {
            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                if (list.size() == 1) {
                    return list.get(0);
                }
            }
        }
        return obj;
    }
}
