package xyz.lemone.apihub.support.sqlparse.expression.parse;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserBaseVisitor;
import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.support.sqlparse.expression.model.LogicalOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.ArithmeticOperator;
import xyz.lemone.apihub.support.sqlparse.expression.model.condition.Join;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ExpressionBlock;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.JoinExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ParenExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.VariableAssignExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ElseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ElseIfExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ExpressionCondition;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.ExpressionConditionList;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.ifelse.IfExpression;
import xyz.lemone.apihub.support.sqlparse.expression.builder.ExpressionBuilder;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * ExpressionVisitor.
 */
public class ExpressionVisitor extends ConfigSqlParserBaseVisitor<Expression> {

    private List<ExpressionBuilder> expressionBuilders;

	public ExpressionVisitor(List<ExpressionBuilder> expressionBuilders) {
		this.expressionBuilders=expressionBuilders;
	}
	
	@Override
	public Expression visitEntry(ConfigSqlParserParser.EntryContext ctx) {
		StringBuilder sb=new StringBuilder();
		List<ConfigSqlParserParser.ExpressionContext> exprs=ctx.expression();
		List<Expression> list= new ArrayList<>();
		for(ConfigSqlParserParser.ExpressionContext exprContext:exprs){
			sb.append(exprContext.getText());
			Expression expr=visitExpression(exprContext);
			list.add(expr);
		}
		ExpressionBlock block=new ExpressionBlock();
		block.setExpressionList(list);
		block.setExpr(sb.toString());
		return block;
	}
	
	@Override
	public Expression visitExpression(ConfigSqlParserParser.ExpressionContext ctx) {
		ConfigSqlParserParser.ExprCompositeContext exprCompositeContext=ctx.exprComposite();
		ConfigSqlParserParser.IfExprContext ifExprContext=ctx.ifExpr();
		ConfigSqlParserParser.CaseExprContext caseExprContext=ctx.caseExpr();
		ConfigSqlParserParser.VariableAssignContext assignCtx=ctx.variableAssign();
		ConfigSqlParserParser.ReturnExprContext returnCtx=ctx.returnExpr();
		if(exprCompositeContext!=null){
			return parseExprComposite(exprCompositeContext);
		}else if(ifExprContext!=null){
			IfExpression expr = parseIfExprContext(ifExprContext);
			return expr;
		}else if(caseExprContext!=null){
			IfExpression expr = parseCaseExprContext(caseExprContext);
			return expr;
		}else if(assignCtx!=null){
			VariableAssignExpression expr=new VariableAssignExpression();
			expr.setExpr(assignCtx.getText());
			expr.setVariable(assignCtx.variable().Identifier().getText());
			expr.setExpression(parseItemContext(assignCtx.item()));
			return expr;
		}else if(returnCtx!=null){
			return parseExpr(returnCtx.expr());
		}else{
			throw new ConfigSqlParseException("Expression ["+ctx.getText()+"] is invalid.");
		}
	}

	private Expression parseExprComposite(ConfigSqlParserParser.ExprCompositeContext exprCompositeContext) {
		if(exprCompositeContext instanceof ConfigSqlParserParser.SingleExprCompositeContext){
			ConfigSqlParserParser.SingleExprCompositeContext singleExprCompositeContext=(ConfigSqlParserParser.SingleExprCompositeContext)exprCompositeContext;
			ConfigSqlParserParser.ExprContext exprContext=singleExprCompositeContext.expr();
			return parseExpr(exprContext);
		}else if(exprCompositeContext instanceof ConfigSqlParserParser.ParenExprCompositeContext){
			ConfigSqlParserParser.ParenExprCompositeContext parenExprCompositeContext=(ConfigSqlParserParser.ParenExprCompositeContext)exprCompositeContext;
			ConfigSqlParserParser.ExprCompositeContext childExprCompositeContext=parenExprCompositeContext.exprComposite();
			return parseExprComposite(childExprCompositeContext);
		}else if(exprCompositeContext instanceof ConfigSqlParserParser.TernaryExprCompositeContext){
			ConfigSqlParserParser.TernaryExprCompositeContext ternaryExprCompositeContext=(ConfigSqlParserParser.TernaryExprCompositeContext)exprCompositeContext;
			ConfigSqlParserParser.TernaryExprContext ternaryExprContext=ternaryExprCompositeContext.ternaryExpr();
			List<ConfigSqlParserParser.IfConditionContext> ifConditionContexts=ternaryExprContext.ifCondition();
			IfExpression expr=new IfExpression();
			expr.setConditionList(parseCondtionList(ifConditionContexts, ternaryExprContext.join()));
			ConfigSqlParserParser.BlockContext firstBlockContext=ternaryExprContext.block(0);
			expr.setExpression(parseBlock(firstBlockContext));
			
			ConfigSqlParserParser.BlockContext secondBlockContext=ternaryExprContext.block(1);
			ElseExpression elseExpr=new ElseExpression();
			elseExpr.setExpression(parseBlock(secondBlockContext));
			expr.setElseExpression(elseExpr);
			return expr;
		}else if(exprCompositeContext instanceof ConfigSqlParserParser.ComplexExprCompositeContext){
			ConfigSqlParserParser.ComplexExprCompositeContext complexExprCompositeContext=(ConfigSqlParserParser.ComplexExprCompositeContext)exprCompositeContext;
			ConfigSqlParserParser.ExprCompositeContext leftExprCompositeContext=complexExprCompositeContext.exprComposite(0);
			Expression leftExpression=parseExprComposite(leftExprCompositeContext);
			ConfigSqlParserParser.ExprCompositeContext rightExprCompositeContext=complexExprCompositeContext.exprComposite(1);
			Expression rightExpression=parseExprComposite(rightExprCompositeContext);
			String op=complexExprCompositeContext.Operator().getText();
			ArithmeticOperator arithmeticOperator = ArithmeticOperator.parse(op);
			List<BaseExpression> expressions=new ArrayList<BaseExpression>();
			expressions.add((BaseExpression)leftExpression);
			expressions.add((BaseExpression)rightExpression);
			List<ArithmeticOperator> arithmeticOperators =new ArrayList<ArithmeticOperator>();
			arithmeticOperators.add(arithmeticOperator);
			ParenExpression expression=new ParenExpression(arithmeticOperators, expressions);
			expression.setExpr(complexExprCompositeContext.getText());
			return expression;
		}else{
			throw new ConfigSqlParseException("Unknow context :"+exprCompositeContext);
		}
	}
	
	private ExpressionBlock parseExpressionBlock(List<ConfigSqlParserParser.ExprBlockContext> contexts){
		StringBuilder sb=new StringBuilder();
		List<Expression> expressionList=new ArrayList<Expression>();
		for(ConfigSqlParserParser.ExprBlockContext ctx:contexts){
			sb.append(ctx.getText());
			ConfigSqlParserParser.VariableAssignContext assignContext=ctx.variableAssign();
			if(assignContext!=null){
				ConfigSqlParserParser.VariableContext varCtx=assignContext.variable();
				String variableName=varCtx.Identifier().getText();
				VariableAssignExpression assignExpr=new VariableAssignExpression();
				assignExpr.setExpr(assignContext.getText());
				assignExpr.setVariable(variableName);
				ConfigSqlParserParser.ItemContext itemCtx=assignContext.item();
				BaseExpression itemExpr=parseItemContext(itemCtx);
				assignExpr.setExpression(itemExpr);
				expressionList.add(assignExpr);
			}
			ConfigSqlParserParser.IfExprContext ifCtx=ctx.ifExpr();
			if(ifCtx!=null){
				IfExpression ifExpr=parseIfExprContext(ifCtx);
				expressionList.add(ifExpr);
			}
			ConfigSqlParserParser.CaseExprContext caseCtx=ctx.caseExpr();
			if(caseCtx!=null){
				IfExpression caseExpr = parseCaseExprContext(caseCtx);
				expressionList.add(caseExpr);
			}
		}
		ExpressionBlock blockExpr=new ExpressionBlock();
		blockExpr.setExpressionList(expressionList);
		blockExpr.setExpr(sb.toString());
		return blockExpr;
	}
	
	private IfExpression parseIfExprContext(ConfigSqlParserParser.IfExprContext ifExprContext) {
		IfExpression expr=new IfExpression();
		expr.setExpr(ifExprContext.getText());
		ConfigSqlParserParser.IfPartContext ifPartContext=ifExprContext.ifPart();
		List<ConfigSqlParserParser.IfConditionContext> ifConditionContexts=ifPartContext.ifCondition();
		List<ConfigSqlParserParser.JoinContext> joinContexts=ifPartContext.join();
		expr.setConditionList(parseCondtionList(ifConditionContexts,joinContexts));
		ExpressionBlock blockExpr=parseBlock(ifPartContext.block());
		expr.setExpression(blockExpr);
		List<ConfigSqlParserParser.ElseIfPartContext> elseIfPartContexts=ifExprContext.elseIfPart();
		if(elseIfPartContexts!=null && elseIfPartContexts.size()>0){
			List<ElseIfExpression> elseIfExpressionList=new ArrayList<ElseIfExpression>();
			for(ConfigSqlParserParser.ElseIfPartContext elseIfContext:elseIfPartContexts){
				ifConditionContexts=elseIfContext.ifCondition();
				joinContexts=elseIfContext.join();
				ElseIfExpression elseIfExpr=new ElseIfExpression();
				elseIfExpr.setConditionList(parseCondtionList(ifConditionContexts,joinContexts));
				elseIfExpr.setExpression(parseBlock(elseIfContext.block()));
				elseIfExpressionList.add(elseIfExpr);
			}
			expr.setElseIfExpressions(elseIfExpressionList);
		}
		
		ConfigSqlParserParser.ElsePartContext elsePartContext=ifExprContext.elsePart();
		if(elsePartContext!=null){
			ElseExpression elseExpression=new ElseExpression();
			elseExpression.setExpression(parseBlock(elsePartContext.block()));
			expr.setElseExpression(elseExpression);
		}
		return expr;
	}
	
	private ExpressionBlock parseBlock(ConfigSqlParserParser.BlockContext blockCtx){
		List<ConfigSqlParserParser.ExprBlockContext> exprBlockCtxs=blockCtx.exprBlock();
		ConfigSqlParserParser.ReturnExprContext returnCtx=blockCtx.returnExpr();
		ExpressionBlock block=null;
		if(exprBlockCtxs!=null){
			block=parseExpressionBlock(exprBlockCtxs);
		}
		if(returnCtx!=null){
			if(block==null) {
                block=new ExpressionBlock();
            }
			block.setReturnExpression(parseExpr(returnCtx.expr()));
		}
		return block;
	}
	
	private IfExpression parseCaseExprContext(ConfigSqlParserParser.CaseExprContext caseExprContext) {
		IfExpression expr=new IfExpression();
		List<ElseIfExpression> elseIfExpressionList=new ArrayList<ElseIfExpression>();
		expr.setElseIfExpressions(elseIfExpressionList);
		List<ConfigSqlParserParser.CasePartContext> casePartContexts=caseExprContext.casePart();
		for(ConfigSqlParserParser.CasePartContext casePartContext:casePartContexts){
			List<ConfigSqlParserParser.IfConditionContext> ifConditionContexts=casePartContext.ifCondition();
			List<ConfigSqlParserParser.JoinContext> joinContexts=casePartContext.join();
			ElseIfExpression elseIfExpr=new ElseIfExpression();
			elseIfExpr.setConditionList(parseCondtionList(ifConditionContexts,joinContexts));
			elseIfExpr.setExpr(casePartContext.getText());
			ExpressionBlock blockExpr=parseBlock(casePartContext.block());
			elseIfExpr.setExpression(blockExpr);
			elseIfExpressionList.add(elseIfExpr);
		}
		return expr;
	}

	
	private Expression parseExpr(ConfigSqlParserParser.ExprContext exprContext) {
		List<BaseExpression> expressions=new ArrayList<BaseExpression>();
		List<ArithmeticOperator> arithmeticOperators =new ArrayList<ArithmeticOperator>();
		List<ConfigSqlParserParser.ItemContext> itemContexts = exprContext.item();
		List<TerminalNode> operatorNodes=exprContext.ArithmeticOperator();
		for(int i=0;i<itemContexts.size();i++){
			ConfigSqlParserParser.ItemContext itemContext=itemContexts.get(i);
			BaseExpression expr=parseItemContext(itemContext);
			expressions.add(expr);
			if(i>0){
				TerminalNode operatorNode=operatorNodes.get(i-1);
				String op=operatorNode.getText();
				arithmeticOperators.add(ArithmeticOperator.parse(op));
			}
		}
		ParenExpression expression=new ParenExpression(arithmeticOperators, expressions);
		expression.setExpr(exprContext.getText());
		return expression;
	}
	
	private ExpressionConditionList parseCondtionList(List<ConfigSqlParserParser.IfConditionContext> ifConditionContexts, List<ConfigSqlParserParser.JoinContext> joinContexts){
		List<ExpressionCondition> list=new ArrayList<ExpressionCondition>();
		List<Join> joins=new ArrayList<Join>();
		for(int i=0;i<ifConditionContexts.size();i++){
			ConfigSqlParserParser.IfConditionContext context=ifConditionContexts.get(i);
			ConfigSqlParserParser.ExprContext left=context.expr(0);
			ConfigSqlParserParser.ExprContext right=context.expr(1);
			Expression leftExpr=parseExpr(left);
			Expression rightExpr=parseExpr(right);
			LogicalOperator logicalOperator = LogicalOperator.parse(context.LogicalOperator().getText());
			ExpressionCondition condition=new ExpressionCondition(leftExpr, logicalOperator,rightExpr);
			list.add(condition);
			if(i>0){
				ConfigSqlParserParser.JoinContext joinContext=joinContexts.get(i-1);
				String text=joinContext.getText();
				Join join=Join.and;
				if(text.equals("or") || text.equals("||")){
					join=Join.or;
				}
				joins.add(join);
			}
		}
		return new ExpressionConditionList(list,joins);
	}
	
	public BaseExpression parseItemContext(ConfigSqlParserParser.ItemContext itemContext){
		BaseExpression expression=null;
		if(itemContext instanceof ConfigSqlParserParser.SimpleJoinContext){
			ConfigSqlParserParser.SimpleJoinContext simpleJoinContext=(ConfigSqlParserParser.SimpleJoinContext)itemContext;
			expression=visitSimpleJoin(simpleJoinContext);
		}else if(itemContext instanceof ConfigSqlParserParser.ParenJoinContext){
			ConfigSqlParserParser.ParenJoinContext parenJoinContext=(ConfigSqlParserParser.ParenJoinContext)itemContext;
			expression=visitParenJoin(parenJoinContext);		
		}else if(itemContext instanceof ConfigSqlParserParser.SingleParenJoinContext){
			ConfigSqlParserParser.SingleParenJoinContext singleContext=(ConfigSqlParserParser.SingleParenJoinContext)itemContext;
			ConfigSqlParserParser.ItemContext childItemContext=singleContext.item();
			expression=parseItemContext(childItemContext);
		}else{
			throw new ConfigSqlParseException("Unknow context :"+itemContext);
		}
		return expression;
	}
	
	@Override
	public BaseExpression visitSimpleJoin(ConfigSqlParserParser.SimpleJoinContext ctx) {
		List<BaseExpression> expressions=new ArrayList<BaseExpression>();
		List<ArithmeticOperator> arithmeticOperators =new ArrayList<ArithmeticOperator>();
		List<ConfigSqlParserParser.UnitContext> unitContexts=ctx.unit();
		List<TerminalNode> operatorNodes=ctx.ArithmeticOperator();
		for(int i=0;i<unitContexts.size();i++){
			ConfigSqlParserParser.UnitContext unitContext=unitContexts.get(i);
			BaseExpression expr=buildExpression(unitContext);
			expressions.add(expr);
			if(i>0){
				TerminalNode operatorNode=operatorNodes.get(i-1);
				String op=operatorNode.getText();
				arithmeticOperators.add(ArithmeticOperator.parse(op));
			}
		}
		if(arithmeticOperators.size()==0 && expressions.size()==1){
			return expressions.get(0);
		}
		JoinExpression expression=new JoinExpression(arithmeticOperators,expressions);
		expression.setExpr(ctx.getText());
		return expression;
	}
	
	@Override
	public BaseExpression visitParenJoin(ConfigSqlParserParser.ParenJoinContext ctx) {
		List<BaseExpression> expressions= new ArrayList<>();
		List<ArithmeticOperator> arithmeticOperators = new ArrayList<>();
		List<ConfigSqlParserParser.ItemContext> itemContexts=ctx.item();
		List<TerminalNode> operatorNodes=ctx.ArithmeticOperator();
		for(int i=0;i<itemContexts.size();i++){
			ConfigSqlParserParser.ItemContext itemContext=itemContexts.get(i);
			BaseExpression expr=parseItemContext(itemContext);
			expressions.add(expr);
			if(i>0){
				TerminalNode operatorNode=operatorNodes.get(i-1);
				String op=operatorNode.getText();
				arithmeticOperators.add(ArithmeticOperator.parse(op));
			}
		}
		ParenExpression expression=new ParenExpression(arithmeticOperators, expressions);
		expression.setExpr(ctx.getText());
		return expression;
	}
	
	private BaseExpression buildExpression(ConfigSqlParserParser.UnitContext unitContext){
		for(ExpressionBuilder builder:expressionBuilders){
			if(builder.support(unitContext)){
				return builder.build(unitContext);
			}
		}
		throw new ConfigSqlParseException("not know context :"+unitContext);
	}
}
