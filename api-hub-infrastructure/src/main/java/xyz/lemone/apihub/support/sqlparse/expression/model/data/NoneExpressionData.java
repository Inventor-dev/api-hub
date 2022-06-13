package xyz.lemone.apihub.support.sqlparse.expression.model.data;

/**
 * NoneExpressionData.
 *
 * @author lemon
 */
public class NoneExpressionData implements ExpressionData<Object> {

    @Override
    public Object getData() {
        return null;
    }

}
