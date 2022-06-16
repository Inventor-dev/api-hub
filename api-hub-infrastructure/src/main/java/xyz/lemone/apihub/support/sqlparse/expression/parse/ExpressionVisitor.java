package xyz.lemone.apihub.support.sqlparse.expression.parse;

import org.antlr.v4.runtime.tree.TerminalNode;
import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;
import xyz.lemone.apihub.support.sqlparse.expression.builder.ExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserBaseVisitor;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.BlockContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.CaseExprContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.CasePartContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ComplexExprCompositeContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ElseIfPartContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ElsePartContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.EntryContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ExprBlockContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ExprCompositeContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ExprContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ExpressionContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.IfConditionContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.IfExprContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.IfPartContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ItemContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.JoinContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ParenExprCompositeContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ParenJoinContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.ReturnExprContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.SimpleJoinContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.SingleExprCompositeContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.SingleParenJoinContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.TernaryExprCompositeContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.TernaryExprContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.UnitContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.VariableAssignContext;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser.VariableContext;
import xyz.lemone.apihub.support.sqlparse.expression.model.ArithmeticOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.LogicalOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.Join;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ExpressionBlock;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.JoinExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ParenExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.VariableAssignExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ElseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ElseIfExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ExpressionCondition;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ExpressionConditionList;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.IfExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * ExpressionVisitor.
 */
public class ExpressionVisitor extends ConfigSqlParserBaseVisitor<Expression> {

    private List<ExpressionBuilder> expressionBuilders;

    public ExpressionVisitor(List<ExpressionBuilder> expressionBuilders) {
        this.expressionBuilders = expressionBuilders;
    }

    @Override
    public Expression visitEntry(EntryContext ctx) {
        StringBuilder sb = new StringBuilder();
        List<ExpressionContext> exprs = ctx.expression();
        List<Expression> list = new ArrayList<>();
        for (ExpressionContext exprContext : exprs) {
            sb.append(exprContext.getText());
            Expression expr = visitExpression(exprContext);
            list.add(expr);
        }
        ExpressionBlock block = new ExpressionBlock();
        block.setExpressionList(list);
        block.setExpr(sb.toString());
        return block;
    }

    @Override
    public Expression visitExpression(ExpressionContext ctx) {
        ExprCompositeContext exprCompositeContext = ctx.exprComposite();
        IfExprContext ifExprContext = ctx.ifExpr();
        CaseExprContext caseExprContext = ctx.caseExpr();
        VariableAssignContext assignCtx = ctx.variableAssign();
        ReturnExprContext returnCtx = ctx.returnExpr();
        if (exprCompositeContext != null) {
            return parseExprComposite(exprCompositeContext);
        } else if (ifExprContext != null) {
            IfExpression expr = parseIfExprContext(ifExprContext);
            return expr;
        } else if (caseExprContext != null) {
            IfExpression expr = parseCaseExprContext(caseExprContext);
            return expr;
        } else if (assignCtx != null) {
            VariableAssignExpression expr = new VariableAssignExpression();
            expr.setExpr(assignCtx.getText());
            expr.setVariable(assignCtx.variable().Identifier().getText());
            expr.setExpression(parseItemContext(assignCtx.item()));
            return expr;
        } else if (returnCtx != null) {
            return parseExpr(returnCtx.expr());
        } else {
            throw new ConfigSqlParseException("Expression [" + ctx.getText() + "] is invalid.");
        }
    }

    private Expression parseExprComposite(ExprCompositeContext exprCompositeContext) {
        if (exprCompositeContext instanceof SingleExprCompositeContext) {
            SingleExprCompositeContext singleExprCompositeContext = (SingleExprCompositeContext) exprCompositeContext;
            ExprContext exprContext = singleExprCompositeContext.expr();
            return parseExpr(exprContext);
        } else if (exprCompositeContext instanceof ParenExprCompositeContext) {
            ParenExprCompositeContext parenExprCompositeContext = (ParenExprCompositeContext) exprCompositeContext;
            ExprCompositeContext childExprCompositeContext = parenExprCompositeContext.exprComposite();
            return parseExprComposite(childExprCompositeContext);
        } else if (exprCompositeContext instanceof TernaryExprCompositeContext) {
            TernaryExprCompositeContext ternaryExprCompositeContext = (TernaryExprCompositeContext) exprCompositeContext;
            TernaryExprContext ternaryExprContext = ternaryExprCompositeContext.ternaryExpr();
            List<IfConditionContext> ifConditionContexts = ternaryExprContext.ifCondition();
            IfExpression expr = new IfExpression();
            expr.setConditionList(parseCondtionList(ifConditionContexts, ternaryExprContext.join()));
            BlockContext firstBlockContext = ternaryExprContext.block(0);
            expr.setExpression(parseBlock(firstBlockContext));

            BlockContext secondBlockContext = ternaryExprContext.block(1);
            ElseExpression elseExpr = new ElseExpression();
            elseExpr.setExpression(parseBlock(secondBlockContext));
            expr.setElseExpression(elseExpr);
            return expr;
        } else if (exprCompositeContext instanceof ComplexExprCompositeContext) {
            ComplexExprCompositeContext complexExprCompositeContext = (ComplexExprCompositeContext) exprCompositeContext;
            ExprCompositeContext leftExprCompositeContext = complexExprCompositeContext.exprComposite(0);
            Expression leftExpression = parseExprComposite(leftExprCompositeContext);
            ExprCompositeContext rightExprCompositeContext = complexExprCompositeContext.exprComposite(1);
            Expression rightExpression = parseExprComposite(rightExprCompositeContext);
            String op = complexExprCompositeContext.Operator().getText();
            ArithmeticOperator arithmeticOperator = ArithmeticOperator.parse(op);
            List<BaseExpression> expressions = new ArrayList<BaseExpression>();
            expressions.add((BaseExpression) leftExpression);
            expressions.add((BaseExpression) rightExpression);
            List<ArithmeticOperator> arithmeticOperators = new ArrayList<ArithmeticOperator>();
            arithmeticOperators.add(arithmeticOperator);
            ParenExpression expression = new ParenExpression(arithmeticOperators, expressions);
            expression.setExpr(complexExprCompositeContext.getText());
            return expression;
        } else {
            throw new ConfigSqlParseException("Unknow context :" + exprCompositeContext);
        }
    }

    private ExpressionBlock parseExpressionBlock(List<ExprBlockContext> contexts) {
        StringBuilder sb = new StringBuilder();
        List<Expression> expressionList = new ArrayList<Expression>();
        for (ExprBlockContext ctx : contexts) {
            sb.append(ctx.getText());
            VariableAssignContext assignContext = ctx.variableAssign();
            if (assignContext != null) {
                VariableContext varCtx = assignContext.variable();
                String variableName = varCtx.Identifier().getText();
                VariableAssignExpression assignExpr = new VariableAssignExpression();
                assignExpr.setExpr(assignContext.getText());
                assignExpr.setVariable(variableName);
                ItemContext itemCtx = assignContext.item();
                BaseExpression itemExpr = parseItemContext(itemCtx);
                assignExpr.setExpression(itemExpr);
                expressionList.add(assignExpr);
            }
            IfExprContext ifCtx = ctx.ifExpr();
            if (ifCtx != null) {
                IfExpression ifExpr = parseIfExprContext(ifCtx);
                expressionList.add(ifExpr);
            }
            CaseExprContext caseCtx = ctx.caseExpr();
            if (caseCtx != null) {
                IfExpression caseExpr = parseCaseExprContext(caseCtx);
                expressionList.add(caseExpr);
            }
        }
        ExpressionBlock blockExpr = new ExpressionBlock();
        blockExpr.setExpressionList(expressionList);
        blockExpr.setExpr(sb.toString());
        return blockExpr;
    }

    private IfExpression parseIfExprContext(IfExprContext ifExprContext) {
        IfExpression expr = new IfExpression();
        expr.setExpr(ifExprContext.getText());
        IfPartContext ifPartContext = ifExprContext.ifPart();
        List<IfConditionContext> ifConditionContexts = ifPartContext.ifCondition();
        List<JoinContext> joinContexts = ifPartContext.join();
        expr.setConditionList(parseCondtionList(ifConditionContexts, joinContexts));
        ExpressionBlock blockExpr = parseBlock(ifPartContext.block());
        expr.setExpression(blockExpr);
        List<ElseIfPartContext> elseIfPartContexts = ifExprContext.elseIfPart();
        if (elseIfPartContexts != null && elseIfPartContexts.size() > 0) {
            List<ElseIfExpression> elseIfExpressionList = new ArrayList<ElseIfExpression>();
            for (ElseIfPartContext elseIfContext : elseIfPartContexts) {
                ifConditionContexts = elseIfContext.ifCondition();
                joinContexts = elseIfContext.join();
                ElseIfExpression elseIfExpr = new ElseIfExpression();
                elseIfExpr.setConditionList(parseCondtionList(ifConditionContexts, joinContexts));
                elseIfExpr.setExpression(parseBlock(elseIfContext.block()));
                elseIfExpressionList.add(elseIfExpr);
            }
            expr.setElseIfExpressions(elseIfExpressionList);
        }

        ElsePartContext elsePartContext = ifExprContext.elsePart();
        if (elsePartContext != null) {
            ElseExpression elseExpression = new ElseExpression();
            elseExpression.setExpression(parseBlock(elsePartContext.block()));
            expr.setElseExpression(elseExpression);
        }
        return expr;
    }

    private ExpressionBlock parseBlock(BlockContext blockCtx) {
        List<ExprBlockContext> exprBlockCtxs = blockCtx.exprBlock();
        ReturnExprContext returnCtx = blockCtx.returnExpr();
        ExpressionBlock block = null;
        if (exprBlockCtxs != null) {
            block = parseExpressionBlock(exprBlockCtxs);
        }
        if (returnCtx != null) {
            if (block == null) {
                block = new ExpressionBlock();
            }
            block.setReturnExpression(parseExpr(returnCtx.expr()));
        }
        return block;
    }

    private IfExpression parseCaseExprContext(CaseExprContext caseExprContext) {
        IfExpression expr = new IfExpression();
        List<ElseIfExpression> elseIfExpressionList = new ArrayList<ElseIfExpression>();
        expr.setElseIfExpressions(elseIfExpressionList);
        List<CasePartContext> casePartContexts = caseExprContext.casePart();
        for (CasePartContext casePartContext : casePartContexts) {
            List<IfConditionContext> ifConditionContexts = casePartContext.ifCondition();
            List<JoinContext> joinContexts = casePartContext.join();
            ElseIfExpression elseIfExpr = new ElseIfExpression();
            elseIfExpr.setConditionList(parseCondtionList(ifConditionContexts, joinContexts));
            elseIfExpr.setExpr(casePartContext.getText());
            ExpressionBlock blockExpr = parseBlock(casePartContext.block());
            elseIfExpr.setExpression(blockExpr);
            elseIfExpressionList.add(elseIfExpr);
        }
        return expr;
    }

    private Expression parseExpr(ExprContext exprContext) {
        List<BaseExpression> expressions = new ArrayList<BaseExpression>();
        List<ArithmeticOperator> arithmeticOperators = new ArrayList<ArithmeticOperator>();
        List<ItemContext> itemContexts = exprContext.item();
        List<TerminalNode> operatorNodes = exprContext.ArithmeticOperator();
        for (int i = 0; i < itemContexts.size(); i++) {
            ItemContext itemContext = itemContexts.get(i);
            BaseExpression expr = parseItemContext(itemContext);
            expressions.add(expr);
            if (i > 0) {
                TerminalNode operatorNode = operatorNodes.get(i - 1);
                String op = operatorNode.getText();
                arithmeticOperators.add(ArithmeticOperator.parse(op));
            }
        }
        ParenExpression expression = new ParenExpression(arithmeticOperators, expressions);
        expression.setExpr(exprContext.getText());
        return expression;
    }

    private ExpressionConditionList parseCondtionList(List<IfConditionContext> ifConditionContexts, List<JoinContext> joinContexts) {
        List<ExpressionCondition> list = new ArrayList<ExpressionCondition>();
        List<Join> joins = new ArrayList<Join>();
        for (int i = 0; i < ifConditionContexts.size(); i++) {
            IfConditionContext context = ifConditionContexts.get(i);
            ExprContext left = context.expr(0);
            ExprContext right = context.expr(1);
            Expression leftExpr = parseExpr(left);
            Expression rightExpr = parseExpr(right);
            LogicalOperator logicalOperator = LogicalOperator.parse(context.LogicalOperator().getText());
            ExpressionCondition condition = new ExpressionCondition(leftExpr, logicalOperator, rightExpr);
            list.add(condition);
            if (i > 0) {
                JoinContext joinContext = joinContexts.get(i - 1);
                String text = joinContext.getText();
                Join join = Join.and;
                if (text.equals("or") || text.equals("||")) {
                    join = Join.or;
                }
                joins.add(join);
            }
        }
        return new ExpressionConditionList(list, joins);
    }

    /**
     * parseItemContext.
     * @param itemContext item 上下文
     * @return BaseExpression
     */
    public BaseExpression parseItemContext(ItemContext itemContext) {
        BaseExpression expression = null;
        if (itemContext instanceof SimpleJoinContext) {
            SimpleJoinContext simpleJoinContext = (SimpleJoinContext) itemContext;
            expression = visitSimpleJoin(simpleJoinContext);
        } else if (itemContext instanceof ParenJoinContext) {
            ParenJoinContext parenJoinContext = (ParenJoinContext) itemContext;
            expression = visitParenJoin(parenJoinContext);
        } else if (itemContext instanceof SingleParenJoinContext) {
            SingleParenJoinContext singleContext = (SingleParenJoinContext) itemContext;
            ItemContext childItemContext = singleContext.item();
            expression = parseItemContext(childItemContext);
        } else {
            throw new ConfigSqlParseException("Unknow context :" + itemContext);
        }
        return expression;
    }

    @Override
    public BaseExpression visitSimpleJoin(SimpleJoinContext ctx) {
        List<BaseExpression> expressions = new ArrayList<BaseExpression>();
        List<ArithmeticOperator> arithmeticOperators = new ArrayList<ArithmeticOperator>();
        List<UnitContext> unitContexts = ctx.unit();
        List<TerminalNode> operatorNodes = ctx.ArithmeticOperator();
        for (int i = 0; i < unitContexts.size(); i++) {
            UnitContext unitContext = unitContexts.get(i);
            BaseExpression expr = buildExpression(unitContext);
            expressions.add(expr);
            if (i > 0) {
                TerminalNode operatorNode = operatorNodes.get(i - 1);
                String op = operatorNode.getText();
                arithmeticOperators.add(ArithmeticOperator.parse(op));
            }
        }
        if (arithmeticOperators.size() == 0 && expressions.size() == 1) {
            return expressions.get(0);
        }
        JoinExpression expression = new JoinExpression(arithmeticOperators, expressions);
        expression.setExpr(ctx.getText());
        return expression;
    }

    @Override
    public BaseExpression visitParenJoin(ParenJoinContext ctx) {
        List<BaseExpression> expressions = new ArrayList<>();
        List<ArithmeticOperator> arithmeticOperators = new ArrayList<>();
        List<ItemContext> itemContexts = ctx.item();
        List<TerminalNode> operatorNodes = ctx.ArithmeticOperator();
        for (int i = 0; i < itemContexts.size(); i++) {
            ItemContext itemContext = itemContexts.get(i);
            BaseExpression expr = parseItemContext(itemContext);
            expressions.add(expr);
            if (i > 0) {
                TerminalNode operatorNode = operatorNodes.get(i - 1);
                String op = operatorNode.getText();
                arithmeticOperators.add(ArithmeticOperator.parse(op));
            }
        }
        ParenExpression expression = new ParenExpression(arithmeticOperators, expressions);
        expression.setExpr(ctx.getText());
        return expression;
    }

    private BaseExpression buildExpression(UnitContext unitContext) {
        for (ExpressionBuilder builder : expressionBuilders) {
            if (builder.support(unitContext)) {
                return builder.build(unitContext);
            }
        }
        throw new ConfigSqlParseException("not know context :" + unitContext);
    }
}
