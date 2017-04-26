package com.example.spring.boot.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("execution(* com.example.spring.boot.service.*.*(..)) ")	         
	public Object enteringAndExitingLogger(ProceedingJoinPoint joinPoint) {
		Object retVal = null;
		logger.info("Entering "+joinPoint.getSignature().getName());
		try {
			retVal = joinPoint.proceed();
		} catch (Throwable e) {
			logger.error("Exception was thrown executing " + joinPoint.getSignature().getName() + " method "
					+ e);
			e.printStackTrace();
		}
		logger.info("Exiting "+joinPoint.getSignature().getName());
		return retVal;
	}

}
