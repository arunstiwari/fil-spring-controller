package com.fil.springcontroller.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // pointcut by package
    @Pointcut("execution(* com.fil.springcontroller.service..*(..))")
    public void  serviceLayer(){
    }

    // pointcut by annotation
    @Pointcut("@annotation(com.fil.springcontroller.aspect.annotation.LogExecutionTime)")
    public void annotatedWithLog() {}

    // combine them if you want
    @Around("serviceLayer() || annotatedWithLog()")
    public Object logAndTime(ProceedingJoinPoint pjp) throws Throwable {
        Signature sig = pjp.getSignature();
        System.out.printf("Entering method %s with arguments %s", sig.toShortString(), pjp.getArgs());
        long start = System.currentTimeMillis();
        try {
            Object result = pjp.proceed();
            long duration = System.currentTimeMillis() - start;
            System.out.printf("[AOP] %s executed in %d ms. Return: %s%n",
                    sig.toShortString(), duration,
                    (result != null ? result.toString() : "null"));
            System.out.printf("Return value of method %s is %s", sig.toShortString(), result);
            return result;
        } catch (Throwable ex) {
            System.out.printf("[AOP] %s threw %s%n", sig.toShortString(), ex.toString());
            throw ex;
        }
    }

    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("[AOP] Exception caught in aspect: " + ex.getMessage());
    }

    @AfterReturning(pointcut = "serviceLayer()", returning = "ret")
    public void afterReturningAdvice(Object ret) {
        // optional: post-process returned object
        System.out.println("[AOP] Exiting the method: " + ret);
    }

}
