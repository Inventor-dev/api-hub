package xyz.lemone.apihub.support.sqlparse.expression.manager;

import xyz.lemone.apihub.support.sqlparse.expression.function.Function;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 表达式管理器实现.
 *
 * @author lemon
 * @since 0.0.1
 */
public class ExpressionFunctions {

    /**
     * 注册的方法.
     */
    private static final Map<String, Function> REGISTER_FUNCTIONS = new HashMap<>();

    public static Map<String, Function> getFunctions() {
        return REGISTER_FUNCTIONS;
    }

    public static Function getFunction(String name) {
        return REGISTER_FUNCTIONS.get(name);
    }

    public void registerFunction(Function function) {
        REGISTER_FUNCTIONS.put(function.name(), function);
    }

    /**
     * 注册方法函数处理器.
     * @param functions function
     */
    public void registerFunctions(Collection<Function> functions) {
        for (Function fun : functions) {
            REGISTER_FUNCTIONS.put(fun.name(), fun);
        }
    }
}
