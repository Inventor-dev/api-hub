package xyz.lemone.apihub.datasource;

import javax.sql.DataSource;

/**
 * DataSourceLoader.
 *
 * @author lemon
 */
public interface IDataSourceLoader {

    /**
     * 获取默认SQL数据源.
     *
     * @return 数据源
     */
    DataSource loadDataSource();

    /**
     * 获取指定标签数据源.
     *
     * @param tag 数据源标签
     * @return 数据源
     */
    DataSource loadDataSource(String tag);

}
