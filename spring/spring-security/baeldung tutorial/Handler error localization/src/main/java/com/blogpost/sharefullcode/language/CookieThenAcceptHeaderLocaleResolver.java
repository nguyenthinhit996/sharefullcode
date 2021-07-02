package com.blogpost.sharefullcode.language;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class CookieThenAcceptHeaderLocaleResolver extends CookieLocaleResolver {
	
	@Override
	protected Locale determineDefaultLocale(HttpServletRequest request) {

		String acceptLanguage = request.getHeader("Accept-Language");
		if (acceptLanguage == null || acceptLanguage.trim().isEmpty()) {
			return super.determineDefaultLocale(request);
		}
		return request.getLocale();
	}
}
