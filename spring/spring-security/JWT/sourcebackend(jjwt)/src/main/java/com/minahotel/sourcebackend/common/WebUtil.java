package com.minahotel.sourcebackend.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minahotel.sourcebackend.controller.StaffController;

public class WebUtil {

	final static Logger LOGGER = LoggerFactory.getLogger(WebUtil.class.toString());

	public static String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	/**
	 * return value is json to client 
	 * @param mapJsonValue
	 * @param setStatus
	 * @param req
	 * @param response
	 * @throws IOException
	 */
	public static void writeResponeToClent(Map<String, String> mapJsonValue, int setStatus, HttpServletRequest req,
			HttpServletResponse response) throws IOException {

		response.setStatus(setStatus);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		byte[] body = new ObjectMapper().writeValueAsBytes(mapJsonValue);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		LOGGER.info("response.getOutputStream().isReady() "+response.getOutputStream().isReady());
		servletOutputStream.write(body);
		servletOutputStream.close();
	}
}
