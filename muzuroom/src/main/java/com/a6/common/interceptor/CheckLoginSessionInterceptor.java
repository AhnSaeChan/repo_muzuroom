package com.a6.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginSessionInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		관리자용
		if(request.getRequestURI().contains("Xdm")) {
			if (request.getSession().getAttribute("sessSeqXdm") != null) {
				// by pass
			} else {
				response.sendRedirect("xdm/adminlogin/adminLoginXdmForm");
		        return false;
			}
		} else {
//			by pass
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
