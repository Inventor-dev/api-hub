package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import java.util.List;

import xyz.lemone.apihub.support.sqlparse.expression.model.ArithmeticOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.JoinExpression;


/**
 * ParenExpression.
 * @author lemon
 */
public class ParenExpression extends JoinExpression {
	private static final long serialVersionUID = 1L;

	public ParenExpression(List<ArithmeticOperator> arithmeticOperators, List<BaseExpression> expressions) {
		super(arithmeticOperators, expressions);
	}
}
