package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.ArithmeticOperator;

import java.util.List;

/**
 * ParenExpression.
 *
 * @author lemon
 */
public class ParenExpression extends JoinExpression {
    private static final long serialVersionUID = 1L;

    public ParenExpression(List<ArithmeticOperator> arithmeticOperators, List<BaseExpression> expressions) {
        super(arithmeticOperators, expressions);
    }
}
