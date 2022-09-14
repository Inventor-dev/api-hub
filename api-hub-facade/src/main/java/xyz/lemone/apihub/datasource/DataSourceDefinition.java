package xyz.lemone.apihub.datasource;

import java.io.Serializable;

/**
 * 数据源定义.
 *
 * @author lemon
 */
public class  DataSourceDefinition implements Serializable {

    /**
     * 数据源类型.
     */
    private DatasourceTypeEnum dataSourceType;

    /**
     * 连接地址.
     */
    private String url;

    /**
     * 认证类型.
     */
    private AuthenticationTypeEnum authenticationType;

    /**
     *  授权key.
     */
    private String authKey;

    /**
     * 授权密码.
     */
    private String authSecret;

    public DataSourceDefinition() {
    }

    public DatasourceTypeEnum getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(DatasourceTypeEnum dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AuthenticationTypeEnum getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationTypeEnum authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthSecret() {
        return authSecret;
    }

    public void setAuthSecret(String authSecret) {
        this.authSecret = authSecret;
    }

}
