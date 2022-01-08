package com.zestfulYoghurt.zy.aop.loggerAop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAopAround {

    @Pointcut("execution(* *..controllers..*.*(..))")
    public void pointCutController() {
    }

    @Pointcut("execution(* *..services..*.*(..))")
    public void pointCutService(){
    }

    //给controller添加环绕通知
    @Around("pointCutController()")
    public Object doControllerAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        return aroundAdvice(proceedingJoinPoint);

    }

    //给service添加环绕通知
    @Around("pointCutService()")
    public Object doServiceAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        return aroundAdvice(proceedingJoinPoint);

    }



    private Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //定义开始日志
        StringBuilder loggerStart = new StringBuilder("\n");
        loggerStart.append("start====").
                append("\n").
                append("全路径名：").
                append(proceedingJoinPoint.getTarget().toString()).//打印目标类的全路径名称
                append("\n").
                append("方 法 名：").
                append(proceedingJoinPoint.getSignature().getName()).//打印目标类的方法名
                append("\n").
                append("====start").
                append("\n");

        //定义结束日志
        StringBuilder loggerEnd = new StringBuilder("\n");
        loggerStart.append("end====").
                append("\n").
                append("全路径名：").
                append(proceedingJoinPoint.getTarget().toString()).//打印目标类的全路径名称
                append("\n").
                append("方 法 名：").
                append(proceedingJoinPoint.getSignature().getName()).//打印目标类的方法名
                append("\n").
                append("====end").
                append("\n").
                append("\n");

        log.info(loggerStart.toString());

        //执行目标方法
        Object resultBean = proceedingJoinPoint.proceed();

        log.info(loggerEnd.toString());

        return resultBean;

    }

}
