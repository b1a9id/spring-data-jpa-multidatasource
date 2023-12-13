package com.b1a9idps.multidatasource.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "firstTransactionManager")
public @interface FirstDBTransactional {

    @AliasFor(annotation = Transactional.class, attribute = "label")
    String[] label() default {};

    @AliasFor(annotation = Transactional.class, attribute = "propagation")
    Propagation propagation() default Propagation.REQUIRED;

    @AliasFor(annotation = Transactional.class, attribute = "isolation")
    Isolation isolation() default Isolation.DEFAULT;

    @AliasFor(annotation = Transactional.class, attribute = "timeout")
    int timeout() default -1;

    @AliasFor(annotation = Transactional.class, attribute = "timeoutString")
    String timeoutString() default "";

    @AliasFor(annotation = Transactional.class, attribute = "readOnly")
    boolean readOnly() default false;

    @AliasFor(annotation = Transactional.class, attribute = "rollbackFor")
    Class<? extends Throwable>[] rollbackFor() default {};

    @AliasFor(annotation = Transactional.class, attribute = "rollbackForClassName")
    String[] rollbackForClassName() default {};

    @AliasFor(annotation = Transactional.class, attribute = "noRollbackFor")
    Class<? extends Throwable>[] noRollbackFor() default {};

    @AliasFor(annotation = Transactional.class, attribute = "noRollbackForClassName")
    String[] noRollbackForClassName() default {};
}
