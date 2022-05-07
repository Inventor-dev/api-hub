package xyz.lemone.apihub.context;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * InterfaceConfig.
 * @author lemon
 */
public class InterfaceConfig implements Serializable {

    /**
     * 接口名称.
     */
    protected String name;

    /**
     * 接口唯一标识.
     */
    protected String code;

    /**
     * 执行器类型.
     */
    protected String runnerType;

    /**
     * 数据源匹配标识.
     */
    protected String dataSourceTag;

    /**
     * 接口执行逻辑.
     */
    protected String execLogic;

    /**
     * 参数配置.
     */
    protected String paramConfig;

    /**
     * 返回值配置.
     */
    protected String resultConfig;

    public InterfaceConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRunnerType() {
        return runnerType;
    }

    public void setRunnerType(String runnerType) {
        this.runnerType = runnerType;
    }

    public String getDataSourceTag() {
        return dataSourceTag;
    }

    public void setDataSourceTag(String dataSourceTag) {
        this.dataSourceTag = dataSourceTag;
    }

    public String getExecLogic() {
        return execLogic;
    }

    public void setExecLogic(String execLogic) {
        this.execLogic = execLogic;
    }

    public String getParamConfig() {
        return paramConfig;
    }

    public void setParamConfig(String paramConfig) {
        this.paramConfig = paramConfig;
    }

    public String getResultConfig() {
        return resultConfig;
    }

    public void setResultConfig(String resultConfig) {
        this.resultConfig = resultConfig;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InterfaceConfig.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("code='" + code + "'")
                .add("runnerType='" + runnerType + "'")
                .add("dataSourceTag='" + dataSourceTag + "'")
                .add("execLogic='" + execLogic + "'")
                .add("paramConfig='" + paramConfig + "'")
                .add("resultConfig='" + resultConfig + "'")
                .toString();
    }
}
