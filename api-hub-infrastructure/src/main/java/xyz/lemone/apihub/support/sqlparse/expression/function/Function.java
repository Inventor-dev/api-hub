package xyz.lemone.apihub.support.sqlparse.expression.function;

import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.util.List;

/**
 * 方法表达式接口定义.
 *
 * @author lemon
 * @Since 0.0.1
 */
public interface Function {

    /**
     * 执行方法表达式逻辑.
     *
     * @param dataList
     * @param context
     * @return
     */
    Object execute(List<ExpressionData<?>> dataList, Context context);

    /**
     * 注册的表达式名称
     *
     * @return
     */
    String name();

}
