package xyz.lemone.apihub.support.sqlparse.toolkit;

import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.exception.ExpressionComputeException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * ElCompute.
 *
 * @author lemon
 */
public class ElCompute {

    public static final char LEFT_PARENTHESIS = '(';

    public static final char RIGHT_PARENTHESIS = ')';

    public static final char DOUBLE_QUOTATION_MARKS = '\"';

    public static final char ADDITION = '+';

    public static final char SUBTRACTION = '-';

    public static final char MULTIPLICATION = '*';

    public static final char DIVISION = '/';

    public static final char TAKE_OVER = '%';

    private Stack<Object> dataStack = new Stack<Object>();

    private Stack<Character> operateStack = new Stack<Character>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String expr = "22/2*2-(5+(1*2))-2*2";
        for (int i = 0; i < 1; i++) {
            ElCompute el = new ElCompute();
            Object data = el.doCompute(expr);
            System.out.println(data);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public Object doCompute(String expr) {
        init(expr);
        return dataStack.pop();
    }

    private void init(String expr) {
        StringBuilder dataSb = new StringBuilder();
        char prevQuote = ' ';
        char prevChar = ' ';
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (prevChar == '\\') {
                dataSb.append(c);
                prevChar = c;
                continue;
            }
            if (prevQuote == '"') {
                if (c == '"') {
                    prevQuote = ' ';
                    dataStack.push(dataSb.toString());
                    dataSb.setLength(0);
                } else {
                    dataSb.append(c);
                }
                prevChar = c;
                continue;
            }
            switch (c) {
                case ADDITION:
                    doOp(dataSb, c, prevChar);
                    break;
                case SUBTRACTION:
                    doOp(dataSb, c, prevChar);
                    break;
                case MULTIPLICATION:
                    doOp(dataSb, c, prevChar);
                    break;
                case DIVISION:
                    doOp(dataSb, c, prevChar);
                    break;
                case TAKE_OVER:
                    doOp(dataSb, c, prevChar);
                    break;
                case LEFT_PARENTHESIS:
                    operateStack.push(c);
                    break;
                case RIGHT_PARENTHESIS:
                    addDataStack(dataSb);
                    doCalculate(1);
                    break;
                case '"':
                    if (prevQuote == '"') {
                        prevQuote = ' ';
                        dataStack.push(dataSb.toString());
                        dataSb.setLength(0);
                    } else {
                        prevQuote = '"';
                    }
                    break;
                case ' ':
                    if (prevQuote == '"') {
                        dataSb.append(c);
                    }
                    break;
                default:
                    dataSb.append(c);
            }
            prevChar = c;
        }
        if (dataSb.length() > 0) {
            addDataStack(dataSb);
        }
        doCalculate(0);
    }

    private void doOp(StringBuilder dataSb, char op, char prevChar) {
        if (dataSb.length() == 0 && prevChar != RIGHT_PARENTHESIS && prevChar != DOUBLE_QUOTATION_MARKS) {
            dataSb.append(op);
        } else {
            addDataStack(dataSb);
            if (op == ADDITION || op == SUBTRACTION) {
                doCalculate(0);
            } else {
                doCalculate(2);
            }
            operateStack.push(op);
        }
    }

    private void doCalculate(int current) {
        if (operateStack.empty()) {
            return;
        }
        char prevOp = operateStack.peek();
        if (prevOp == LEFT_PARENTHESIS) {
            operateStack.pop();
            return;
        }
        if (current == 0 || current == 1) {
            char op = operateStack.pop();
            do {
                Object right = dataStack.pop();
                Object left = dataStack.pop();
                Object result = calculate(left, op, right);
                dataStack.push(result);
                if (operateStack.isEmpty()) {
                    break;
                }
                op = operateStack.pop();
            } while (op != LEFT_PARENTHESIS);
        } else if (current == NumberUtils.INTEGER_TWO) {
            while (prevOp == MULTIPLICATION || prevOp == DIVISION || prevOp == TAKE_OVER) {
                Object right = dataStack.pop();
                Object left = dataStack.pop();
                char op = operateStack.pop();
                Object result = calculate(left, op, right);
                dataStack.push(result);
                if (operateStack.isEmpty()) {
                    break;
                }
                prevOp = operateStack.peek();
                if (prevOp == LEFT_PARENTHESIS) {
                    break;
                }
            }
        }
    }

    private Object calculate(Object left, char op, Object right) {
        if ((op == MULTIPLICATION || op == DIVISION || op == TAKE_OVER || op == SUBTRACTION)) {
            if (right instanceof String || left instanceof String) {
                return left.toString() + op + right.toString();
            }
            BigDecimal b1 = (BigDecimal) left;
            BigDecimal b2 = (BigDecimal) right;
            if (op == MULTIPLICATION) {
                return b1.multiply(b2);
            } else if (op == DIVISION) {
                return b1.divide(b2, 10, RoundingMode.HALF_UP).stripTrailingZeros();
            } else if (op == TAKE_OVER) {
                return b1.divideAndRemainder(b2)[1];
            } else if (op == SUBTRACTION) {
                return b1.subtract(b2);
            }
        } else if (op == ADDITION) {
            if (right instanceof String || left instanceof String) {
                return left.toString() + right.toString();
            } else {
                BigDecimal b1 = (BigDecimal) left;
                BigDecimal b2 = (BigDecimal) right;
                return b1.add(b2);
            }
        }
        throw new ExpressionComputeException("not known operate " + op + "");
    }

    private void addDataStack(StringBuilder dataSb) {
        if (dataSb.length() == 0) {
            return;
        }
        String data = dataSb.toString();
        dataSb.setLength(0);
        try {
            BigDecimal bd = ValueConvertHelper.toBigDecimal(data);
            dataStack.push(bd);
        } catch (Exception ex) {
            dataStack.push(data);
        }
    }
}
