package xyz.lemone.apihub.support.sqlparse.expression.model;

import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;

/**
 * 逻辑运算符.
 *
 * @author lemon
 */
public enum LogicalOperator {

    /**
     * >.
     */
    GreatThen(">"),

    /**
     * >=.
     */
    EqualsGreatThen(">="),

    /**
     * <.
     */
    LessThen("<"),

    /**
     * <=.
     */
    EqualsLessThen("<="),

    /**
     * ==.
     */
    Equals("=="),

    /**
     * !=.
     */
    NotEquals("!="),

    /**
     * in.
     */
    In("in"),

    /**
     * not in.
     */
    NotIn("not in") {
        @Override
        boolean support(String op) {
            return super.support(op) || "not  in".equals(op);
        }
    },

    /**
     * like.
     */
    Like("like");

    public final String value;

    LogicalOperator(String value) {
        this.value = value;
    }

    boolean support(String op) {
        return this.value.equals(op);
    }

    /**
     * 转换为枚举.
     * @param op str value
     * @return a enum
     */
    public static LogicalOperator parse(String op) {
        for (LogicalOperator aEnum : values()) {
            if (aEnum.support(op)) {
                return aEnum;
            }
        }
        throw new ConfigSqlParseException("not know op :" + op);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
