package xyz.lemone.apihub.datasource;

/**
 * 数据源类型枚举.
 *
 * @author lemon
 */
public enum DatasourceTypeEnum {

    /**
     * jdbc.
     */
    JDBC("jdbc");

    /**
     * 识别码.
     */
    public final String code;

    DatasourceTypeEnum(String code) {
        this.code = code;
    }

}
