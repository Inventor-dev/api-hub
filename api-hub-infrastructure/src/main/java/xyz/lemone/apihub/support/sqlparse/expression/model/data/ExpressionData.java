package xyz.lemone.apihub.support.sqlparse.expression.model.data;

/**
 * ExpressionData.
 *
 * @param <D> 值类型.
 * @author lemon
 */
public interface ExpressionData<D> {

    /**
     * 获取值.
     *
     * @return 值
     */
    D getData();
}
