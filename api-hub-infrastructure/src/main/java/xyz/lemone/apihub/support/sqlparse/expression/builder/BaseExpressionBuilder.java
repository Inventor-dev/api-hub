package xyz.lemone.apihub.support.sqlparse.expression.builder;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.math.NumberUtils;
import xyz.lemone.apihub.support.sqlparse.ExpressionParser;
import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;
import xyz.lemone.apihub.support.sqlparse.expression.model.LogicalOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.BaseCondition;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.BothExpressionCondition;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.CurrentValueExpressionCondition;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.Join;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.PropertyExpressionCondition;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BooleanExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.IntegerExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.NullExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.NumberExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.StringExpression;
import xyz.lemone.apihub.support.sqlparse.toolkit.ValueConvertHelper;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

import java.util.List;

/**
 * BaseExpressionBuilder.
 *
 * @author lemon
 */
public abstract class BaseExpressionBuilder implements ExpressionBuilder {
    protected BaseExpression parseSimpleValueContext(ConfigSqlParserParser.SimpleValueContext valueContext) {
        if (valueContext.BOOLEAN() != null) {
            return new BooleanExpression(Boolean.valueOf(valueContext.getText()));
        } else if (valueContext.INTEGER() != null) {
            return new IntegerExpression(Integer.valueOf(valueContext.INTEGER().getText()));
        } else if (valueContext.STRING() != null) {
            String text = valueContext.STRING().getText();
            text = text.substring(NumberUtils.INTEGER_ONE, text.length() - NumberUtils.INTEGER_ONE);
            return new StringExpression(text);
        } else if (valueContext.NUMBER() != null) {
            return new NumberExpression(ValueConvertHelper.toBigDecimal(valueContext.NUMBER().getText()));
        } else if (valueContext.NULL() != null) {
            return new NullExpression();
        }
        throw new ConfigSqlParseException("not know simple value context " + valueContext);
    }


    protected BaseCondition buildConditions(ConfigSqlParserParser.ConditionsContext conditionsContext) {
        List<ConfigSqlParserParser.ConditionContext> conditionContextList = conditionsContext.condition();
        List<ConfigSqlParserParser.JoinContext> joins = conditionsContext.join();
        BaseCondition condition = null;
        BaseCondition topCondition = null;
        int opIndex = 0;
        for (ConfigSqlParserParser.ConditionContext conditionCtx : conditionContextList) {
            if (condition == null) {
                condition = parseCondition(conditionCtx);
                topCondition = condition;
            } else {
                BaseCondition nextCondition = parseCondition(conditionCtx);
                condition.setNextCondition(nextCondition);
                condition.setJoin(Join.parse(joins.get(opIndex).getText()));
                opIndex++;
                condition = nextCondition;
            }
        }
        return topCondition;
    }

    private BaseCondition parseCondition(ConfigSqlParserParser.ConditionContext context) {
        if (context instanceof ConfigSqlParserParser.ExprConditionContext) {
            ConfigSqlParserParser.ExprConditionContext ctx = (ConfigSqlParserParser.ExprConditionContext) context;
            BothExpressionCondition condition = new BothExpressionCondition();
            List<ConfigSqlParserParser.ExprContext> exprContexts = ctx.expr();
            String left = exprContexts.get(0).getText();
            condition.setLeft(left);
            Expression leftExpr = ExpressionParser.parseExpression(left);
            condition.setLeftExpression(leftExpr);
            String rightExpr = exprContexts.get(1).getText();
            condition.setRight(rightExpr);
            condition.setRightExpression(ExpressionParser.parseExpression(rightExpr));
            condition.setOp(parseOp(ctx.OP()));
            condition.setOperation(ctx.OP().getText());
            return condition;
        } else if (context instanceof ConfigSqlParserParser.CurrentValueConditionContext) {
            ConfigSqlParserParser.CurrentValueConditionContext ctx = (ConfigSqlParserParser.CurrentValueConditionContext) context;
            CurrentValueExpressionCondition condition = new CurrentValueExpressionCondition();
            String rightExpr = ctx.expr().getText();
            condition.setRight(rightExpr);
            condition.setRightExpression(ExpressionParser.parseExpression(rightExpr));
            condition.setOp(parseOp(ctx.OP()));
            return condition;
        } else if (context instanceof ConfigSqlParserParser.PropertyConditionContext) {
            ConfigSqlParserParser.PropertyConditionContext ctx = (ConfigSqlParserParser.PropertyConditionContext) context;
            PropertyExpressionCondition condition = new PropertyExpressionCondition();
            String left = ctx.property().getText();
            condition.setLeft(left);
            condition.setLeftProperty(left);
            String rightExpr = ctx.expr().getText();
            condition.setRight(rightExpr);
            condition.setRightExpression(ExpressionParser.parseExpression(rightExpr));
            condition.setOp(parseOp(ctx.OP()));
            return condition;
        }
        throw new ConfigSqlParseException("not know condition context : " + context);
    }

    private LogicalOperator parseOp(TerminalNode opNode) {
        return LogicalOperator.parse(opNode.getText());
    }
}
