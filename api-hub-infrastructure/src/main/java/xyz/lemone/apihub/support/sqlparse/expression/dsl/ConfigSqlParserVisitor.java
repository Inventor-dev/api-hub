// Generated from ConfigSqlParser.g4 by ANTLR 4.10.1

package xyz.lemone.apihub.support.sqlparse.expression.dsl;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConfigSqlParserParser}.
 *
 * @author lemon
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ConfigSqlParserVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#entry}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEntry(ConfigSqlParserParser.EntryContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(ConfigSqlParserParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by the {@code complexExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComplexExprComposite(ConfigSqlParserParser.ComplexExprCompositeContext ctx);

    /**
     * Visit a parse tree produced by the {@code singleExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSingleExprComposite(ConfigSqlParserParser.SingleExprCompositeContext ctx);

    /**
     * Visit a parse tree produced by the {@code parenExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenExprComposite(ConfigSqlParserParser.ParenExprCompositeContext ctx);

    /**
     * Visit a parse tree produced by the {@code ternaryExprComposite}
     * labeled alternative in {@link ConfigSqlParserParser#exprComposite}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTernaryExprComposite(ConfigSqlParserParser.TernaryExprCompositeContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#ternaryExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTernaryExpr(ConfigSqlParserParser.TernaryExprContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#caseExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCaseExpr(ConfigSqlParserParser.CaseExprContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#casePart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCasePart(ConfigSqlParserParser.CasePartContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#ifExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfExpr(ConfigSqlParserParser.IfExprContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#ifPart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfPart(ConfigSqlParserParser.IfPartContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#elseIfPart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElseIfPart(ConfigSqlParserParser.ElseIfPartContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#elsePart}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElsePart(ConfigSqlParserParser.ElsePartContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlock(ConfigSqlParserParser.BlockContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#exprBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprBlock(ConfigSqlParserParser.ExprBlockContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#returnExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturnExpr(ConfigSqlParserParser.ReturnExprContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr(ConfigSqlParserParser.ExprContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#ifCondition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfCondition(ConfigSqlParserParser.IfConditionContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#variableAssign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariableAssign(ConfigSqlParserParser.VariableAssignContext ctx);

    /**
     * Visit a parse tree produced by the {@code simpleJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleJoin(ConfigSqlParserParser.SimpleJoinContext ctx);

    /**
     * Visit a parse tree produced by the {@code singleParenJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSingleParenJoin(ConfigSqlParserParser.SingleParenJoinContext ctx);

    /**
     * Visit a parse tree produced by the {@code parenJoin}
     * labeled alternative in {@link ConfigSqlParserParser#item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenJoin(ConfigSqlParserParser.ParenJoinContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#unit}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnit(ConfigSqlParserParser.UnitContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#variable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariable(ConfigSqlParserParser.VariableContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#dataset}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDataset(ConfigSqlParserParser.DatasetContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#function}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunction(ConfigSqlParserParser.FunctionContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#functionParameter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionParameter(ConfigSqlParserParser.FunctionParameterContext ctx);

    /**
     * Visit a parse tree produced by the {@code simpleData}
     * labeled alternative in {@link ConfigSqlParserParser#set}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleData(ConfigSqlParserParser.SimpleDataContext ctx);

    /**
     * Visit a parse tree produced by the {@code range}
     * labeled alternative in {@link ConfigSqlParserParser#set}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRange(ConfigSqlParserParser.RangeContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#conditions}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConditions(ConfigSqlParserParser.ConditionsContext ctx);

    /**
     * Visit a parse tree produced by the {@code propertyCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPropertyCondition(ConfigSqlParserParser.PropertyConditionContext ctx);

    /**
     * Visit a parse tree produced by the {@code currentValueCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCurrentValueCondition(ConfigSqlParserParser.CurrentValueConditionContext ctx);

    /**
     * Visit a parse tree produced by the {@code exprCondition}
     * labeled alternative in {@link ConfigSqlParserParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCondition(ConfigSqlParserParser.ExprConditionContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#property}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProperty(ConfigSqlParserParser.PropertyContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#currentValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCurrentValue(ConfigSqlParserParser.CurrentValueContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#simpleValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleValue(ConfigSqlParserParser.SimpleValueContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#join}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitJoin(ConfigSqlParserParser.JoinContext ctx);

    /**
     * Visit a parse tree produced by {@link ConfigSqlParserParser#aggregate}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAggregate(ConfigSqlParserParser.AggregateContext ctx);
}