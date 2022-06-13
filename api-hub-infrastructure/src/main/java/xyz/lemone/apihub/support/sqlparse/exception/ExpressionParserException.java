package xyz.lemone.apihub.support.sqlparse.exception;

import xyz.lemone.apihub.support.common.exception.ApiHubException;

/**
 * 表达式解析异常.
 *
 * @author lemon
 * @since 0.0.1
 */
public class ExpressionParserException extends ApiHubException {
    private static final long serialVersionUID = 1L;

    public ExpressionParserException(String msg) {
        super(msg);
    }
}
