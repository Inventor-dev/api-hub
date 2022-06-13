package xyz.lemone.apihub.support.sqlparse.exception;

import xyz.lemone.apihub.support.common.exception.ApiHubException;

/**
 * 表达式处理异常.
 *
 * @author lemon
 */
public class ExpressionComputeException extends ApiHubException {
    private static final long serialVersionUID = 1;

    public ExpressionComputeException(Exception ex) {
        super(ex);
    }

    public ExpressionComputeException(String msg) {
        super(msg);
    }
}
