package xyz.lemone.apihub.support.sqlparse.expression.function;

import java.util.List;

import xyz.lemone.apihub.ureport.build.Context;
import xyz.lemone.apihub.ureport.expression.model.data.ExpressionData;
import xyz.lemone.apihub.ureport.model.Cell;

/**
 * 方法表达式接口定义.
 * @author lemon
 * @Since 0.0.1
 */
public interface Function {

    /**
     * 执行方法表达式逻辑.
     * @param dataList
     * @param context
     * @param currentCell
     * @return
     */
	Object execute(List<ExpressionData<?>> dataList, Context context, Cell currentCell);

    /**
     *  注册的表达式名称
     * @return
     */
	String name();

}
