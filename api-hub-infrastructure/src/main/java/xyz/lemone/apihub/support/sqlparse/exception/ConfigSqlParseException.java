package xyz.lemone.apihub.support.sqlparse.exception;

import xyz.lemone.apihub.support.common.exception.ApiHubException;

/**
 * 转换SQL 异常.
 *
 * @author lemon
 * @since 0.0.1
 */
public class ConfigSqlParseException extends ApiHubException {
    private static final long serialVersionUID = 1L;

    public ConfigSqlParseException(Exception ex) {
        super(ex);
    }

    public ConfigSqlParseException(String msg) {
        super(msg);
    }
}
