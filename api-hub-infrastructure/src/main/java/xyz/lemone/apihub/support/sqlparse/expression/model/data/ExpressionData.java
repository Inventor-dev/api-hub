package xyz.lemone.apihub.support.sqlparse.expression.model.data;

/**
 * ExpressionData.
 * @author lemon
 * @param <D> 值类型.
 */
public interface ExpressionData<D> {

    /**
     * 获取值.
     * @return 值
     */
    D getData();
}
