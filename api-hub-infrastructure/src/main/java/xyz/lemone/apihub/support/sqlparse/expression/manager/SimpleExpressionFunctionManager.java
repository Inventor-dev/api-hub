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
public class SimpleExpressionFunctionManager implements ExpressionFunctionManager {

    /**
     * 注册的方法
     */
    private Map<String, Function> registerFunctions = new HashMap<>();

    @Override
    public Map<String, Function> getFunctions() {
        return registerFunctions;
    }

    @Override
    public Function getFunction(String name) {
        return registerFunctions.get(name);
    }

    @Override
    public void registerFunction(Function function) {
        registerFunctions.put(function.name(), function);
    }

    @Override
    public void registerFunctions(Collection<Function> functions) {
        for (Function fun : functions) {
            registerFunctions.put(fun.name(), fun);
        }
    }
}
