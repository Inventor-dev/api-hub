package xyz.lemone.apihub.register;

import java.lang.annotation.Target;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * 组件注册器.
 *
 * @author lemon
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Registration {

    /**
     * 获取注册类型.
     * @return 注册类型
     */
    RegisterTypeEnum registerType();

    /**
     * 获取唯一标识.
     * @return 唯一标识
     */
    String name() default "";

}
