package xyz.lemone.apihub.support.sqlparse.expression.manager;

import xyz.lemone.apihub.support.sqlparse.expression.function.Function;

import java.util.Collection;
import java.util.Map;

/**
 * 解析方法管理器.
 * @author lemon
 * @Since 0.0.1
 */
public interface ExpressionFunctionManager {

    /**
     * 获取注册的方法.
     * @return
     */
    Map<String, Function>  getFunctions();

    /**
     * 通过名称获取方法.
     * @param name
     * @return
     */
    Function getFunction(String name);

    /**
     * 注册方法.
     * @param fun
     */
    void registerFunction(Function fun);

    /**
     * 批量注册方法.
     * @param functions
     */
    void registerFunctions(Collection<Function> functions);

}
