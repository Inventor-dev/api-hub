package xyz.lemone.apihub.runner;

import org.springframework.core.annotation.AliasFor;
import xyz.lemone.apihub.register.RegisterTypeEnum;
import xyz.lemone.apihub.register.Registration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 接口执行器注册.
 *
 * @author lemon
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Registration(registerType = RegisterTypeEnum.INTERFACE_RUNNER)
public @interface RunnerRegistration {

    /**
     * 获取唯一标识.
     *
     * @return 唯一标识
     */
    @AliasFor(annotation = Registration.class)
    String name();

}
