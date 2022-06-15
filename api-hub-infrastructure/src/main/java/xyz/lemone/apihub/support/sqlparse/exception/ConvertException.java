package xyz.lemone.apihub.support.sqlparse.exception;

import xyz.lemone.apihub.support.common.exception.ApiHubException;

/**
 * ConvertException.
 * @author lemon
 */
public class ConvertException extends ApiHubException {
    private static final long serialVersionUID = 1L;

    public ConvertException(Exception ex) {
        super(ex);
    }

    public ConvertException(String msg) {
        super(msg);
    }
}
