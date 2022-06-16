package xyz.lemone.apihub.support.sqlparse;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import xyz.lemone.apihub.support.sqlparse.exception.ConfigSqlParseException;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserLexer;
import xyz.lemone.apihub.support.sqlparse.expression.dsl.ConfigSqlParserParser;
import xyz.lemone.apihub.support.sqlparse.expression.manager.ExpressionBuilders;
import xyz.lemone.apihub.support.sqlparse.expression.model.expression.Expression;
import xyz.lemone.apihub.support.sqlparse.expression.parse.ExpressionErrorListener;
import xyz.lemone.apihub.support.sqlparse.expression.parse.ExpressionVisitor;

import java.util.regex.Pattern;

/**
 * ExpressionParser.
 *
 * @author lemon
 */
public class ExpressionParser {

    public static final String EXPR_PREFIX = "${";

    public static final String EXPR_SUFFIX = "}";

    private static final ExpressionVisitor EXPR_VISITOR;

    public static Pattern pattern = Pattern.compile("\\$\\{.*?\\}");

    static {
        EXPR_VISITOR = new ExpressionVisitor(ExpressionBuilders.getExpressionBuilders());
    }

    /**
     * 是否为解析表达式.
     *
     * @param text 内容
     * @return true or false
     */
    public static boolean isExpressions(String text) {
        return text.startsWith(ExpressionParser.EXPR_PREFIX)
                && text.endsWith(ExpressionParser.EXPR_SUFFIX);
    }

    /**
     * 未包装表达式值.
     *
     * @param text 内容
     * @return unwrap text
     */
    public static String unwrapExpressions(String text) {
        return text.substring(EXPR_PREFIX.length(), text.length() - EXPR_SUFFIX.length());
    }

    /**
     * 转换为执行表达式.
     *
     * @param text 内容
     * @return Expression
     */
    public static Expression parseExpression(String text) {
        CodePointCharStream charStream = CharStreams.fromString(text);
        ConfigSqlParserLexer lexer = new ConfigSqlParserLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ConfigSqlParserParser parser = new ConfigSqlParserParser(tokenStream);
        ExpressionErrorListener errorListener = new ExpressionErrorListener();
        parser.addErrorListener(errorListener);
        Expression expression = EXPR_VISITOR.visitEntry(parser.entry());
        String error = errorListener.getErrorMessage();
        if (error != null) {
            throw new ConfigSqlParseException("Expression parse error:" + error);
        }
        return expression;
    }

    public static ExpressionVisitor getExpressionVisitor() {
        return EXPR_VISITOR;
    }

}
