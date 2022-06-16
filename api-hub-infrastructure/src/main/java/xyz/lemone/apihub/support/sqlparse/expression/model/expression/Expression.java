package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

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
     * @param context 上下文
     * @return expression data
     */
    ExpressionData<?> execute(Context context);

}
