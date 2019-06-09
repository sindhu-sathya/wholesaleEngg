/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex;

import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.hash.Hashing;
/**
 * 
 *Interceptor file
 *
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOG = LoggerFactory.getLogger(RequestInterceptor.class);

	private final static String REQUEST_START_TIME = "requestStartTime";
	private String apiSalt = "";

	public RequestInterceptor(String apiSalt) {
		this.apiSalt = apiSalt;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOG.trace("inside preHandle");
		String apiSecretHeader = request.getHeader("IGREEN_API_INPUT_SECRET");
		LOG.info("API secret header value " + apiSecretHeader);
		String pathInfo = request.getServletPath();
		if (pathInfo.startsWith("/fetchTransactionList") || pathInfo.startsWith("/fetchAccountList")) {
			String keyValue = pathInfo.substring(pathInfo.lastIndexOf("/") + 1);
			String originalString = keyValue + ":" + apiSalt;
			String hashSalt = Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
			if (!hashSalt.equals(apiSecretHeader)) {
				throw new Exception("Not Authorized");
			}
		}
		addRequestStartTime(request);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		long startTime = (Long) request.getAttribute(REQUEST_START_TIME);
		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;

		LOG.info("Request Served in {} milli seconds", executeTime);
	}

	private void addRequestStartTime(HttpServletRequest request) {
		long startTime = System.currentTimeMillis();
		MDC.put("CONTEXT_ID", RandomStringUtils.randomAlphanumeric(6) + startTime);
		request.setAttribute(REQUEST_START_TIME, startTime);

		LOG.debug("Request start time is {}", startTime);
	}

}