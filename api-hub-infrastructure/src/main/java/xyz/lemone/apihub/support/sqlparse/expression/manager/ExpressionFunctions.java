package xyz.lemone.apihub.support.sqlparse.expression.manager;

import xyz.lemone.apihub.support.sqlparse.expression.function.Function;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 表达式管理器实现.
 *
 * @author lemon
 * @Since 0.0.1
 */
public class ExpressionFunctions {

    /**
     * 注册的方法
     */
    private static final Map<String, Function> registerFunctions = new HashMap<>();

    public static Map<String, Function> getFunctions() {
        return registerFunctions;
    }

    public static Function getFunction(String name) {
        return registerFunctions.get(name);
    }

    public void registerFunction(Function function) {
        registerFunctions.put(function.name(), function);
    }

    public void registerFunctions(Collection<Function> functions) {
        for (Function fun : functions) {
            registerFunctions.put(fun.name(), fun);
        }
    }
}
