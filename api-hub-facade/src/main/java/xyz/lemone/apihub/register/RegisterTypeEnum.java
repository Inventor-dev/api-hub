package xyz.lemone.apihub.register;

/**
 * 注册类型枚举.
 * @author lemon
 */
public enum RegisterTypeEnum {

    /**
     * 接口执行器.
     */
    INTERFACE_RUNNER("interfaceRunner");

    /**
     * name.
     */
    public final String name;

    RegisterTypeEnum(String name) {
        this.name = name;
    }
}
