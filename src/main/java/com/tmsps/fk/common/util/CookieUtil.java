package com.tmsps.fk.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie 工具类
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class CookieUtil {
	private CookieUtil() {
	}

	/**
	 * set cookie
	 * 
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAgeInSeconds
	 * @param path
	 * @param domain
	 * @param isHttpOnly
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds,
			String path, String domain, Boolean isHttpOnly) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAgeInSeconds);
		if (path == null) {
			path = "/";
		}
		cookie.setPath(path);

		if (domain != null) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
	}

	/**
	 * get cookie
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookieObject(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}

	public static String getCookie(HttpServletRequest request, String name) {
		Cookie cookie = getCookieObject(request, name);
		return cookie != null ? cookie.getValue() : "";
	}

	public static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds) {
		setCookie(response, name, value, maxAgeInSeconds, null, null, null);
	}
}
