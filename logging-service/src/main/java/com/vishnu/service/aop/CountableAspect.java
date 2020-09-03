package com.vishnu.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Aspect to count method call.
 *
 * @author : vishnu.g
 * created on : 03/Sep/2020
 */
@Aspect
public class CountableAspect {

    private final Logger log;
    private static final Map<String, Integer> countingMap = new HashMap();

    public CountableAspect(String loggerName){
        super();
        log = LoggerFactory.getLogger(loggerName);
    }

    @Pointcut("@annotation(com.vishnu.service.Countable)")
    public void executeCounting() {
    }

    @Before("executeCounting()")
    public void incrementCount(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();
        if (countingMap.containsKey(methodName)) {
            int current = countingMap.get(methodName);
            current++;
            countingMap.put(methodName, current);
        } else {
            countingMap.put(methodName, 1);
        }
        StringBuilder message = new StringBuilder("Service '");
        countingMap.forEach((k, v) -> message.append(k + "' executed (" + v + ") times"));
        log.info(message.toString());
    }
}
