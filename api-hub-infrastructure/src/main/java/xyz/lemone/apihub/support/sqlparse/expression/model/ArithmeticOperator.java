package xyz.lemone.apihub.support.sqlparse.expression.model;

import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;

/**
 * 算数运算符.
 *
 * @author lemon
 */
public enum ArithmeticOperator {
    /**
     * + .
     */
    Add("+"),

    /**
     * - .
     */
    Subtract("-"),

    /**
     * * .
     */
    Multiply("*"),

    /**
     * / .
     */
    Divide("/"),

    /**
     * % .
     */
    Complementation("%");

    public final String value;

    ArithmeticOperator(String value) {
        this.value = value;
    }

    public static ArithmeticOperator parse(String op) {
        for (ArithmeticOperator aEnum : values()) {
            if (aEnum.value.equals(op)) {
                return aEnum;
            }
        }
        throw new ConfigSqlParseException("not know arithmeticOperator :" + op);

    }

    @Override
    public String toString() {
        return this.value;
    }

    ;
}
