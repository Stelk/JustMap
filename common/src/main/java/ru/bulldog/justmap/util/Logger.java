package ru.bulldog.justmap.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import ru.bulldog.justmap.JustMap;

public final class Logger {
	
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
	
	private final String modPref = "[" + JustMap.MOD_ID + "] ";
	
	private Logger() {}
	
	public static Logger get() {
		return new Logger();
	}
	
	public void log(Level level, String message) {
		LOGGER.log(level, modPref + message);
	}
	
	public void log(Level level, String message, Object... params) {
		LOGGER.log(level, modPref + message, params);
	}
	
	public void debug(Object message) {
		log(Level.DEBUG, message.toString());
	}
	
	public void debug(Object message, Object... params) {
		log(Level.DEBUG, message.toString(), params);
	}
	
	public void catching(Throwable ex) {
		this.error(ex.getLocalizedMessage());
		LOGGER.catching(ex);
	}
	
	public void info(String message) {
		log(Level.INFO, message);
	}
	
	public void info(String message, Object... params) {
		this.log(Level.INFO, message, params);
	}
	
	public void warning(String message) {
		log(Level.WARN, message);
	}
	
	public void warning(String message, Object obj, Exception ex) {
		LOGGER.warn(modPref + message, obj, ex);
	}
	
	public void error(String message) {
		log(Level.ERROR, message);
	}
	
	public void error(String message, Object obj, Exception ex) {
		LOGGER.error(modPref + message, obj, ex);
	}
	
	public void error(String message, Exception ex) {
		LOGGER.error(modPref + message, ex);
	}
}
