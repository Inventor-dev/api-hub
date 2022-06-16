// Generated from ConfigSqlParser.g4 by ANTLR 4.10.1

package xyz.lemone.apihub.support.sqlparse.expression.dsl;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConfigSqlParserParser}.
 * @author lemon
 */
public interface ConfigSqlParserListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#entry}.
     *
     * @param ctx the parse tree
     */
    void enterEntry(ConfigSqlParserParser.EntryContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#entry}.
     *
     * @param ctx the parse tree
     */
    void exitEntry(ConfigSqlParserParser.EntryContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(ConfigSqlParserParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(ConfigSqlParserParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by the {@code complexExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void enterComplexExprComposite(ConfigSqlParserParser.ComplexExprCompositeContext ctx);

    /**
     * Exit a parse tree produced by the {@code complexExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void exitComplexExprComposite(ConfigSqlParserParser.ComplexExprCompositeContext ctx);

    /**
     * Enter a parse tree produced by the {@code singleExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void enterSingleExprComposite(ConfigSqlParserParser.SingleExprCompositeContext ctx);

    /**
     * Exit a parse tree produced by the {@code singleExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void exitSingleExprComposite(ConfigSqlParserParser.SingleExprCompositeContext ctx);

    /**
     * Enter a parse tree produced by the {@code parenExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void enterParenExprComposite(ConfigSqlParserParser.ParenExprCompositeContext ctx);

    /**
     * Exit a parse tree produced by the {@code parenExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void exitParenExprComposite(ConfigSqlParserParser.ParenExprCompositeContext ctx);

    /**
     * Enter a parse tree produced by the {@code ternaryExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void enterTernaryExprComposite(ConfigSqlParserParser.TernaryExprCompositeContext ctx);

    /**
     * Exit a parse tree produced by the {@code ternaryExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     */
    void exitTernaryExprComposite(ConfigSqlParserParser.TernaryExprCompositeContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#ternaryExpr}.
     *
     * @param ctx the parse tree
     */
    void enterTernaryExpr(ConfigSqlParserParser.TernaryExprContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#ternaryExpr}.
     *
     * @param ctx the parse tree
     */
    void exitTernaryExpr(ConfigSqlParserParser.TernaryExprContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#caseExpr}.
     *
     * @param ctx the parse tree
     */
    void enterCaseExpr(ConfigSqlParserParser.CaseExprContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#caseExpr}.
     *
     * @param ctx the parse tree
     */
    void exitCaseExpr(ConfigSqlParserParser.CaseExprContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#casePart}.
     *
     * @param ctx the parse tree
     */
    void enterCasePart(ConfigSqlParserParser.CasePartContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#casePart}.
     *
     * @param ctx the parse tree
     */
    void exitCasePart(ConfigSqlParserParser.CasePartContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#ifExpr}.
     *
     * @param ctx the parse tree
     */
    void enterIfExpr(ConfigSqlParserParser.IfExprContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#ifExpr}.
     *
     * @param ctx the parse tree
     */
    void exitIfExpr(ConfigSqlParserParser.IfExprContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#ifPart}.
     *
     * @param ctx the parse tree
     */
    void enterIfPart(ConfigSqlParserParser.IfPartContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#ifPart}.
     *
     * @param ctx the parse tree
     */
    void exitIfPart(ConfigSqlParserParser.IfPartContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#elseIfPart}.
     *
     * @param ctx the parse tree
     */
    void enterElseIfPart(ConfigSqlParserParser.ElseIfPartContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#elseIfPart}.
     *
     * @param ctx the parse tree
     */
    void exitElseIfPart(ConfigSqlParserParser.ElseIfPartContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#elsePart}.
     *
     * @param ctx the parse tree
     */
    void enterElsePart(ConfigSqlParserParser.ElsePartContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#elsePart}.
     *
     * @param ctx the parse tree
     */
    void exitElsePart(ConfigSqlParserParser.ElsePartContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#block}.
     *
     * @param ctx the parse tree
     */
    void enterBlock(ConfigSqlParserParser.BlockContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#block}.
     *
     * @param ctx the parse tree
     */
    void exitBlock(ConfigSqlParserParser.BlockContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#exprBlock}.
     *
     * @param ctx the parse tree
     */
    void enterExprBlock(ConfigSqlParserParser.ExprBlockContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#exprBlock}.
     *
     * @param ctx the parse tree
     */
    void exitExprBlock(ConfigSqlParserParser.ExprBlockContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#returnExpr}.
     *
     * @param ctx the parse tree
     */
    void enterReturnExpr(ConfigSqlParserParser.ReturnExprContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#returnExpr}.
     *
     * @param ctx the parse tree
     */
    void exitReturnExpr(ConfigSqlParserParser.ReturnExprContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExpr(ConfigSqlParserParser.ExprContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExpr(ConfigSqlParserParser.ExprContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#ifCondition}.
     *
     * @param ctx the parse tree
     */
    void enterIfCondition(ConfigSqlParserParser.IfConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#ifCondition}.
     *
     * @param ctx the parse tree
     */
    void exitIfCondition(ConfigSqlParserParser.IfConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#variableAssign}.
     *
     * @param ctx the parse tree
     */
    void enterVariableAssign(ConfigSqlParserParser.VariableAssignContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#variableAssign}.
     *
     * @param ctx the parse tree
     */
    void exitVariableAssign(ConfigSqlParserParser.VariableAssignContext ctx);

    /**
     * Enter a parse tree produced by the {@code simpleJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     */
    void enterSimpleJoin(ConfigSqlParserParser.SimpleJoinContext ctx);

    /**
     * Exit a parse tree produced by the {@code simpleJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     */
    void exitSimpleJoin(ConfigSqlParserParser.SimpleJoinContext ctx);

    /**
     * Enter a parse tree produced by the {@code singleParenJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     */
    void enterSingleParenJoin(ConfigSqlParserParser.SingleParenJoinContext ctx);

    /**
     * Exit a parse tree produced by the {@code singleParenJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     */
    void exitSingleParenJoin(ConfigSqlParserParser.SingleParenJoinContext ctx);

    /**
     * Enter a parse tree produced by the {@code parenJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     */
    void enterParenJoin(ConfigSqlParserParser.ParenJoinContext ctx);

    /**
     * Exit a parse tree produced by the {@code parenJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     */
    void exitParenJoin(ConfigSqlParserParser.ParenJoinContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#unit}.
     *
     * @param ctx the parse tree
     */
    void enterUnit(ConfigSqlParserParser.UnitContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#unit}.
     *
     * @param ctx the parse tree
     */
    void exitUnit(ConfigSqlParserParser.UnitContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#variable}.
     *
     * @param ctx the parse tree
     */
    void enterVariable(ConfigSqlParserParser.VariableContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#variable}.
     *
     * @param ctx the parse tree
     */
    void exitVariable(ConfigSqlParserParser.VariableContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#dataset}.
     *
     * @param ctx the parse tree
     */
    void enterDataset(ConfigSqlParserParser.DatasetContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#dataset}.
     *
     * @param ctx the parse tree
     */
    void exitDataset(ConfigSqlParserParser.DatasetContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#function}.
     *
     * @param ctx the parse tree
     */
    void enterFunction(ConfigSqlParserParser.FunctionContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#function}.
     *
     * @param ctx the parse tree
     */
    void exitFunction(ConfigSqlParserParser.FunctionContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#functionParameter}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionParameter(ConfigSqlParserParser.FunctionParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#functionParameter}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionParameter(ConfigSqlParserParser.FunctionParameterContext ctx);

    /**
     * Enter a parse tree produced by the {@code simpleData}
     * labeled alternative in {@link ConfigSqlParserParser#set}.
     *
     * @param ctx the parse tree
     */
    void enterSimpleData(ConfigSqlParserParser.SimpleDataContext ctx);

    /**
     * Exit a parse tree produced by the {@code simpleData}
     * labeled alternative in {@link ConfigSqlParserParser#set}.
     *
     * @param ctx the parse tree
     */
    void exitSimpleData(ConfigSqlParserParser.SimpleDataContext ctx);

    /**
     * Enter a parse tree produced by the {@code range}
     * labeled alternative in {@link ConfigSqlParserParser#set}.
     *
     * @param ctx the parse tree
     */
    void enterRange(ConfigSqlParserParser.RangeContext ctx);

    /**
     * Exit a parse tree produced by the {@code range}
     * labeled alternative in {@link ConfigSqlParserParser#set}.
     *
     * @param ctx the parse tree
     */
    void exitRange(ConfigSqlParserParser.RangeContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#conditions}.
     *
     * @param ctx the parse tree
     */
    void enterConditions(ConfigSqlParserParser.ConditionsContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#conditions}.
     *
     * @param ctx the parse tree
     */
    void exitConditions(ConfigSqlParserParser.ConditionsContext ctx);

    /**
     * Enter a parse tree produced by the {@code propertyCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterPropertyCondition(ConfigSqlParserParser.PropertyConditionContext ctx);

    /**
     * Exit a parse tree produced by the {@code propertyCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitPropertyCondition(ConfigSqlParserParser.PropertyConditionContext ctx);

    /**
     * Enter a parse tree produced by the {@code currentValueCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterCurrentValueCondition(ConfigSqlParserParser.CurrentValueConditionContext ctx);

    /**
     * Exit a parse tree produced by the {@code currentValueCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitCurrentValueCondition(ConfigSqlParserParser.CurrentValueConditionContext ctx);

    /**
     * Enter a parse tree produced by the {@code exprCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterExprCondition(ConfigSqlParserParser.ExprConditionContext ctx);

    /**
     * Exit a parse tree produced by the {@code exprCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitExprCondition(ConfigSqlParserParser.ExprConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#property}.
     *
     * @param ctx the parse tree
     */
    void enterProperty(ConfigSqlParserParser.PropertyContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#property}.
     *
     * @param ctx the parse tree
     */
    void exitProperty(ConfigSqlParserParser.PropertyContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#currentValue}.
     *
     * @param ctx the parse tree
     */
    void enterCurrentValue(ConfigSqlParserParser.CurrentValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#currentValue}.
     *
     * @param ctx the parse tree
     */
    void exitCurrentValue(ConfigSqlParserParser.CurrentValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#simpleValue}.
     *
     * @param ctx the parse tree
     */
    void enterSimpleValue(ConfigSqlParserParser.SimpleValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#simpleValue}.
     *
     * @param ctx the parse tree
     */
    void exitSimpleValue(ConfigSqlParserParser.SimpleValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#join}.
     *
     * @param ctx the parse tree
     */
    void enterJoin(ConfigSqlParserParser.JoinContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#join}.
     *
     * @param ctx the parse tree
     */
    void exitJoin(ConfigSqlParserParser.JoinContext ctx);

    /**
     * Enter a parse tree produced by {@link ConfigSqlParserParser#aggregate}.
     *
     * @param ctx the parse tree
     */
    void enterAggregate(ConfigSqlParserParser.AggregateContext ctx);

    /**
     * Exit a parse tree produced by {@link ConfigSqlParserParser#aggregate}.
     *
     * @param ctx the parse tree
     */
    void exitAggregate(ConfigSqlParserParser.AggregateContext ctx);
}