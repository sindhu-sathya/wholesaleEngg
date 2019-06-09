/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Interceptor file for Logging
 *
 */
@Aspect
@Component
public class LoggingInterceptor {
	private static final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Autowired
	private HttpServletRequest request;

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controller() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void allMethod() {
	}

	@Around("controller() && allMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();

			LOG.info("request uri " + request.getRequestURI());
			LOG.info("request header values");
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				LOG.info(key + ":" + value);
			}
			LOG.info("classname invoked " + className);
			LOG.info("method name invoked " + methodName);
			LOG.info("Response headers");
			LOG.info("Status Code : 200");
			ObjectMapper mapper = new ObjectMapper();
			LOG.debug("The response for rest service with request uri is " + request.getRequestURI() + "\n"
					+ mapper.writeValueAsString(result));
			String a = "{ \"ROM\":" + mapper.writeValueAsString(result) + "}";
			System.out.println("JSON Print===" + a);

			return result;
		} catch (IllegalArgumentException e) {
			LOG.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}

}
