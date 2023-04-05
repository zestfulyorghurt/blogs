package com.zestfulYoghurt.zy.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.pojos.BasePojo;
import com.zestfulYoghurt.zy.tool.JsonConvert;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AopAround {

	Result<Object> result;
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

    	result = new Result<Object>();
    	Long startTime = System.currentTimeMillis();

        //使用ServletRequestAttributes请求上下文获取方法更多
        ServletRequestAttributes attributes =
        		(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        //使用数组来获取参数
        Object[] array = proceedingJoinPoint.getArgs();

        //执行函数前打印日志
        log.info("调用前：{}：{}", className, methodName);
        log.info("传递的参数为：{}", JsonConvert.ObjectToJson(array));
        log.info("URL:{}", request.getRequestURL().toString());
        log.info("IP地址：{}", request.getRemoteAddr());

        //对参数进行check
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object o:args){
            if (o instanceof BasePojo){
                Boolean validate = ((BasePojo) o).validate();
                //如果数据check出现问题
                if(!validate){
                	result.ModelCheckError();
                    //执行函数后打印日志
                    log.info("调用后：{}：{}", className, methodName);
                    log.info("返回值为：{}", JsonConvert.ObjectToJson(result));
                    log.info("耗时：{}ms", System.currentTimeMillis() - startTime);
                    return result;
                }
            }
        }
        //执行目标方法
        Object resultBean = proceedingJoinPoint.proceed();
        //执行函数后打印日志
        log.info("调用后：{}：{}", className, methodName);
        log.info("返回值为：{}", JsonConvert.ObjectToJson(resultBean));
        log.info("耗时：{}ms", System.currentTimeMillis() - startTime);
        return resultBean;
    }

}
