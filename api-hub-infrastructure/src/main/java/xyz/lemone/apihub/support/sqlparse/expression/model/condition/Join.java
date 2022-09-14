package xyz.lemone.apihub.support.sqlparse.expression.model.condition;

import java.util.Objects;
import java.util.Set;

/**
 * Join.
 *
 * @author lemon
 */
public enum Join {

    /**
     * and.
     */
    and(Set.of("and", "&&")),

    /**
     * or.
     */
    or(Set.of("or", "||"));

    public final Set<String> values;

    Join(Set<String> values) {
        this.values = values;
    }

    /**
     * 转换函数.
     *
     * @param joinText text
     * @return a enum
     */
    public static Join parse(String joinText) {
        Join join = parse(joinText, null);
        if (Objects.nonNull(join)) {
            return join;
        }
        throw new IllegalArgumentException("not know join : " + join);
    }

    /**
     * 转换函数.
     *
     * @param joinText text
     * @param defaultJoin default
     * @return a enum
     */
    public static Join parse(String joinText, Join defaultJoin) {
        for (Join aEnum : values()) {
            if (aEnum.values.contains(joinText)) {
                return aEnum;
            }
        }
        return defaultJoin;
    }
}
