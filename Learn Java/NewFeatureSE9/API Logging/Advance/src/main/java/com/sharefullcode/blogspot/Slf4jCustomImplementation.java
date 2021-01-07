package com.sharefullcode.blogspot;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jCustomImplementation implements System.Logger {

	private String name;
	private Logger loggerSlf4j;

	public Slf4jCustomImplementation(String name) {
		this.name = name;
		this.loggerSlf4j = LoggerFactory.getLogger(name);
	}

	public String getName() {
		return name;
	}

	public boolean isLoggable(Level level) {
		switch (level) {
		case OFF:
			return false;
		case TRACE:
			return loggerSlf4j.isTraceEnabled();
		case DEBUG:
			return loggerSlf4j.isDebugEnabled();
		case INFO:
			return loggerSlf4j.isInfoEnabled();
		case WARNING:
			return loggerSlf4j.isWarnEnabled();
		case ERROR:
			return loggerSlf4j.isErrorEnabled();
		case ALL:
		default:
			return true;
		}
	}

	public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
		if (!isLoggable(level)) {
			return;
		}

		switch (level) {
		case TRACE:
			loggerSlf4j.trace(msg, thrown);
			break;
		case DEBUG:
			loggerSlf4j.debug(msg, thrown);
			break;
		case INFO:
			loggerSlf4j.info(msg, thrown);
			break;
		case WARNING:
			loggerSlf4j.warn(msg, thrown);
			break;
		case ERROR:
			loggerSlf4j.error(msg, thrown);
			break;
		case ALL:
		default:
			loggerSlf4j.info(msg, thrown);
		}
	}

	public void log(Level level, ResourceBundle bundle, String format, Object... params) {
		if (!isLoggable(level)) {
			return;
		}
		String msg = MessageFormat.format(format, params);

		switch (level) {
		case TRACE:
			loggerSlf4j.trace(msg);
			break;
		case DEBUG:
			loggerSlf4j.debug(msg);
			break;
		case INFO:
			loggerSlf4j.info(msg);
			break;
		case WARNING:
			loggerSlf4j.warn(msg);
			break;
		case ERROR:
			loggerSlf4j.error(msg);
			break;
		case ALL:
		default:
			loggerSlf4j.info(msg);
		}
	}
}
