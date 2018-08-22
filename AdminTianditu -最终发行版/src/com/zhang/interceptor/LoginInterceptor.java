package com.zhang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//配置拦截器
/*  1、权限检查：如检测请求是否具有登录权限，如果没有直接返回到登陆页面。 
 *	2、性能监控：用请求处理前和请求处理后的时间差计算整个请求响应完成所消耗的时间。 
 *	3、日志记录：可以记录请求信息的日志，以便进行信息监控、信息统计等。
 *  
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String URI = request.getRequestURI();
		// 防止相关资源被拦截
		if (URI.indexOf("/static/") > 0)
			return true;
		// 前台页面
		if (URI.indexOf("login") > 0 || URI.indexOf("login.jsp") > 0) {
			return true;
		}

		// 登陆验证请求，放行。
		if (URI.indexOf("login") > 0)
			return true;

		if (request.getSession().getAttribute("admin") != null) {
			return true;
		}

		response.sendRedirect("/AdminTianditu/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception arg3) throws Exception {
	}

}
