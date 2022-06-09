package xyz.lemone.apihub.runner;

import xyz.lemone.apihub.context.InterfaceConfig;
import xyz.lemone.apihub.datasource.IDataSourceLoader;

/**
 * 配置化接口执行器.
 *
 * @param <C> 参数配置DTO
 * @param <R> 返回值类型
 * @author lemon
 */
public interface IConfigurableRunner<C extends InterfaceConfig, R> {

    /**
     * run.
     *
     * @param sourceLoader 数据源加载器
     * @param config       接口配置
     * @param param        参数
     * @return 执行结果
     */
    R run(IDataSourceLoader sourceLoader, C config, Object param);

}
