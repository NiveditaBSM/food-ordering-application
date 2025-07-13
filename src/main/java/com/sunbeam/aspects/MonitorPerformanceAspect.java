package com.sunbeam.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP

@Aspect
@Component
@Slf4j
public class MonitorPerformanceAspect {

	// intercept method calls to all of the controllers
	@Around("execution(* com.sunbeam.controller.*.*(..))")
	public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("Begins monitoring ");
		long begin = System.currentTimeMillis();
		log.info("Proceeding to req handling method");
		Object ret = joinPoint.proceed();
		log.info("Time taken by method : " + joinPoint.getSignature() + " in "
				+ (System.currentTimeMillis() - begin) + "msec");
		return ret;
	}
}