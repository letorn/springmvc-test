package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Sogger {

	private static Logger logger = null;
	static {
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("logging.properties");
		LogManager logManager = LogManager.getLogManager();
		try {
			logManager.readConfiguration(inputStream);
			logger = Logger.getLogger("springmvc");
		} catch (SecurityException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void info(String msg) {
		logger.info(msg);
	}
}
