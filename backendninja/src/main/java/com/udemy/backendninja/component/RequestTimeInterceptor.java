package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	private Log LOG = LogFactory.getLog(RequestTimeInterceptor.class); 
	
	// se ejecuta antes de entrar en el metodo del controlador
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	// se ejecuta justo antes de escupir la vista del controlador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() 
				+ "' -- TOTAL TIME: '" + (System.currentTimeMillis() - startTime)
				+ "'ms");
	}
	
}
