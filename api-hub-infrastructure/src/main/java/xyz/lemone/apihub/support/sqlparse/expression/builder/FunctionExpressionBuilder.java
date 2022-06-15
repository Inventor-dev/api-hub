package xyz.lemone.apihub.support.sqlparse.expression.builder;

import xyz.lemone.apihub.support.sqlparse.expression.model.expression.BaseExpression;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.FunctionExpression;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;
import xyz.lemone.apihub.support.sqlparse.ExpressionParser;

import java.util.ArrayList;
import java.util.List;

/**
 * FunctionExpressionBuilder.
 * @author lemon
 */
public class FunctionExpressionBuilder extends BaseExpressionBuilder {

    @Override
    public BaseExpression build(ConfigSqlParserParser.UnitContext unitContext) {
        ConfigSqlParserParser.FunctionContext ctx = unitContext.function();
        FunctionExpression expr = new FunctionExpression();
        expr.setExpr(ctx.getText());
        expr.setName(ctx.Identifier().getText());
        ConfigSqlParserParser.FunctionParameterContext functionParameterContext = ctx.functionParameter();
        if (functionParameterContext != null) {
            List<BaseExpression> exprList = new ArrayList<>();
            List<ConfigSqlParserParser.ItemContext> itemContexts = functionParameterContext.item();
            if (itemContexts != null) {
                for (int i = 0; i < itemContexts.size(); i++) {
                    ConfigSqlParserParser.ItemContext itemContext = itemContexts.get(i);
                    BaseExpression baseExpr = ExpressionParser.getExpressionVisitor()
                            .parseItemContext(itemContext);
                    exprList.add(baseExpr);
                }
            }
            expr.setExpressions(exprList);
        }
        return expr;
    }

    @Override
    public boolean support(ConfigSqlParserParser.UnitContext unitContext) {
        return unitContext.function() != null;
    }
}
