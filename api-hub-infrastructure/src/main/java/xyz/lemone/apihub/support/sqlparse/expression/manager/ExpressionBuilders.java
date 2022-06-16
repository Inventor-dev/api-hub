package xyz.lemone.apihub.support.sqlparse.expression.manager;

import xyz.lemone.apihub.support.sqlparse.expression.builder.BooleanExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.ExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.FunctionExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.IntegerExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.NullExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.NumberExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.SetExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.StringExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.builder.VariableExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * ExpressionBuilders.
 *
 * @author lemon
 */
public class ExpressionBuilders {

    private static List<ExpressionBuilder> expressionBuilders = new ArrayList<>();

    static {
        expressionBuilders.add(new StringExpressionBuilder());
        expressionBuilders.add(new VariableExpressionBuilder());
        expressionBuilders.add(new BooleanExpressionBuilder());
        expressionBuilders.add(new IntegerExpressionBuilder());
        expressionBuilders.add(new FunctionExpressionBuilder());
        expressionBuilders.add(new NumberExpressionBuilder());
        expressionBuilders.add(new SetExpressionBuilder());
        expressionBuilders.add(new NullExpressionBuilder());
    }

    public static List<ExpressionBuilder> getExpressionBuilders() {
        return expressionBuilders;
    }

}
