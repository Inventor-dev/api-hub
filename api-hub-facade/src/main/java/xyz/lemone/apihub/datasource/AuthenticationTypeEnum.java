package xyz.lemone.apihub.datasource;

/**
 * 数据源认证类型.
 *
 * @author lemon
 */
public enum AuthenticationTypeEnum {

    /**
     * 用户名密码模式.
     */
    USERNAME_PASSWORD("password", "用户名密码模式"),

    /**
     * 应用id秘钥模式.
     */
    APPID_SECRET("appId", "应用ID秘钥模式"),

    /**
     * AK/SK 模式.
     */
    AK_SK("akSk", "AK/SK 模式");

    /**
     * 标识.
     */
    public final String code;

    /**
     * 名称.
     */
    public final String name;

    AuthenticationTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
