package xyz.lemone.apihub.support.sqlparse.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.lemone.apihub.support.sqlparse.expression.function.AvgFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.Function;
import xyz.lemone.apihub.support.sqlparse.expression.function.JsonFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.OrderFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.ParameterFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.ParameterIsEmptyFunction;
import xyz.lemone.apihub.support.sqlparse.expression.manager.ExpressionFunctionManager;
import xyz.lemone.apihub.support.sqlparse.expression.manager.SimpleExpressionFunctionManager;
import xyz.lemone.apihub.support.sqlparse.expression.function.GetFunction;

import java.util.List;

/**
 * SqlParseAutoConfig.
 *
 * @author lemon
 * @since 0.0.1
 */
@Configuration
public class SqlParseAutoConfig {

    /**
     * 方法表达式管理器.
     *
     * @param functions 托管的方法
     * @return
     */
    @Bean
    public ExpressionFunctionManager expressionFunctionManager(List<Function> functions) {
        SimpleExpressionFunctionManager manager = new SimpleExpressionFunctionManager();
        manager.registerFunctions(functions);
        return manager;
    }

    /**
     * 参数方法.
     *
     * @return
     */
    @Bean
    public ParameterFunction parameterFunction() {
        return new ParameterFunction();
    }

    @Bean
    public ParameterIsEmptyFunction parameterIsEmptyFunction() {
        return new ParameterIsEmptyFunction();
    }

    @Bean
    public AvgFunction avgFunction(){
        return new AvgFunction();
    }

    @Bean
    public JsonFunction jsonFunction(){
        return new JsonFunction();
    }

    @Bean
    public OrderFunction orderFunction(){
        return new OrderFunction();
    }

    @Bean
    public GetFunction getFunction(){
        return new GetFunction();
    }

}
