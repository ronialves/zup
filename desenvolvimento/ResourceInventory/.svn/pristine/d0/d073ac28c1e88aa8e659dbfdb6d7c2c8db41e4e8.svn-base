package com.tlf.oss.resourceinventory.web.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(description = "Mecanismo para gerenciar as rotas e arquivos do Angular", urlPatterns = { "/cpe/*" })
public class WebApplicationConfiguration implements Filter {

	public static final String PATH_TO_THE_WEBAPP = "/cpe/";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();

		if (isWebAppRequest(url, req.getMethod())) {
			req.getRequestDispatcher(getPath(url)).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

	private String getPath(String uri) {
		if (!isWebApplicationFile(uri)) {
			return WebApplicationConfiguration.PATH_TO_THE_WEBAPP + "index.html";
		} else {
			return WebApplicationConfiguration.PATH_TO_THE_WEBAPP + uri;
		}
	}

	private boolean isWebApplicationFile(String uri) {
		return uri.contains("assets") || uri.matches("(?i)^\\/.*\\.([a-z])+$");
	}

	private boolean isWebAppRequest(String uri, String method) {
		return !uri.contains(WebApplicationConfiguration.PATH_TO_THE_WEBAPP) && method.equals("GET");
	}
}