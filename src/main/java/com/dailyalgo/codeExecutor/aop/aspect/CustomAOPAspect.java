package com.dailyalgo.codeExecutor.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CustomAOPAspect {

	@Pointcut("@annotation(com.dailyalgo.codeExecutor.aop.annotation.CustomAOP)")
	public void customAOPPointcut() {
	}

	@Around("customAOPPointcut()")
	public void customAOPLogging(ProceedingJoinPoint jointPoint) throws Throwable {
		String methodName = jointPoint.getSignature().getName();
		log.info("Custom AOP is Running : {}", methodName);
		jointPoint.proceed();
		log.info("Custom AOP is Ended : {} [END]", methodName);
	}

}
