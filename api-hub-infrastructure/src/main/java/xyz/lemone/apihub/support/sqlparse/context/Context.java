package xyz.lemone.apihub.support.sqlparse.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 解析上下文.
 *
 * @author lemon
 */
public class Context implements Serializable {

    /**
     * 执行变量.
     */
    private Map<String, Object> variableMap = new HashMap<>();

    /**
     * 执行参数.
     */
    private Map<String, Object> parameters;

    public Context(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void putVariable(String key, Object value) {
        variableMap.put(key, value);
    }

    public void resetVariableMap() {
        variableMap.clear();
    }

    public Object getVariable(String key) {
        return variableMap.get(key);
    }
}
