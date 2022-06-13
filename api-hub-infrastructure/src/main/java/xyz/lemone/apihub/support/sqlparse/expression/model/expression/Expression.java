package xyz.lemone.apihub.support.sqlparse.expression.model.expression;

import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;
import xyz.lemone.apihub.ureport.build.Context;

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
