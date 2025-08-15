package com.infosys.capstone.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.infosys.capstone.services..*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Method details
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        System.out.println("Method: " + methodName);
        System.out.println("Arguments: " + Arrays.toString(args));

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Execution Time: " + (end - start) + " ms");

        return result;
        }
}
