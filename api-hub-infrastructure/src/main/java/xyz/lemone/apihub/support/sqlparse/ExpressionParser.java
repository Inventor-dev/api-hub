package xyz.lemone.apihub.support.sqlparse;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;
import xyz.lemone.apihub.support.sqlparse.expression.manager.ExpressionBuilders;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.support.sqlparse.expression.parse.ExpressionErrorListener;
import xyz.lemone.apihub.support.sqlparse.expression.parse.ExpressionVisitor;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserLexer;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;

/**
 * ExpressionParser.
 *
 * @author lemon
 */
public class ExpressionParser {

    public static final String EXPR_PREFIX = "${";

    public static final String EXPR_SUFFIX = "}";

    private static final ExpressionVisitor exprVisitor;


    static {
        exprVisitor = new ExpressionVisitor(ExpressionBuilders.getExpressionBuilders());
    }

    /**
     * 是否为解析表达式
     *
     * @param text
     * @return
     */
    public static boolean isExpressions(String text) {
        return text.startsWith(ExpressionParser.EXPR_PREFIX)
                && text.endsWith(ExpressionParser.EXPR_SUFFIX);
    }

    /**
     * 未包装表达式值.
     *
     * @param text
     * @return
     */
    public static String unwrapExpressions(String text) {
        return text.substring(EXPR_PREFIX.length(), text.length() - EXPR_SUFFIX.length());
    }


    public static Expression parseExpression(String text) {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(text);
        ConfigSqlParserLexer lexer = new ConfigSqlParserLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ConfigSqlParserParser parser = new ConfigSqlParserParser(tokenStream);
        ExpressionErrorListener errorListener = new ExpressionErrorListener();
        parser.addErrorListener(errorListener);
        Expression expression = exprVisitor.visitEntry(parser.entry());
        String error = errorListener.getErrorMessage();
        if (error != null) {
            throw new ConfigSqlParseException("Expression parse error:" + error);
        }
        return expression;
    }


    public static ExpressionVisitor getExpressionVisitor() {
        return exprVisitor;
    }
}
