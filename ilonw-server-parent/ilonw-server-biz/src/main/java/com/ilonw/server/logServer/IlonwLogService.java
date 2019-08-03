package com.ilonw.server.logServer;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IlonwLogService {

    /**
     * 默认参数
     *
     * @return
     */
    String value() default "";

    /**
     * 请求IP
     *
     * @return
     */
    String requestIp() default "127.0.0.1";

    /**
     * @return
     */
    Class<?> param() default Object.class;

    /**
     * 请求参数
     *
     * @return
     */
    String request() default "";

    /**
     * 返回参数
     *
     * @return
     */
    String result() default "";

    /**
     * 状态
     *
     * @return
     */
    String status() default "";

    /**
     * 使用时间
     *
     * @return
     */
    long times() default 0L;

    /**
     * 类型
     *
     * @return
     */
    String type() default "";
}
