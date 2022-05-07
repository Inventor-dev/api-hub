package xyz.lemone.apihub.runner;

import xyz.lemone.apihub.context.InterfaceConfig;
import xyz.lemone.apihub.datasource.IDataSourceLoader;

/**
 * sql接口逻辑执行器.
 *
 * @author lemon
 */
public class SqlRunner implements IConfigurableRunner<InterfaceConfig, Object, Object> {

    @Override
    public Object run(IDataSourceLoader sourceLoader, InterfaceConfig config, Object param) {
        return null;
    }
}
