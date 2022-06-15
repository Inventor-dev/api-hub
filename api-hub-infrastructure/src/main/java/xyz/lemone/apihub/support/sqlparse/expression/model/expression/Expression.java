package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.support.sqlparse.context.Context;

import java.io.Serializable;

/**
 * Expression.
 *
 * @author lemon
 */
public interface Expression extends Serializable {

    /**
     * execute.
     *
     * @param context
     * @return
     */
    ExpressionData<?> execute(Context context);

}
