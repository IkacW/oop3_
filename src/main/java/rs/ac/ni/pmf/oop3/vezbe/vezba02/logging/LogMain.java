package rs.ac.ni.pmf.oop3.vezbe.vezba02.logging;

import java.io.IOException;
import java.util.logging.*;

public class LogMain
{
	public static void main(String[] args) throws IOException
	{
		final Logger logger = Logger.getLogger("MyLog");
		logger.setLevel(Level.ALL);

		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);

		Handler xmlHandler = new FileHandler("log.xml", false);
		xmlHandler.setLevel(Level.INFO);
		xmlHandler.setFormatter(new XMLFormatter());

		logger.setUseParentHandlers(false);
		logger.addHandler(xmlHandler);
		logger.addHandler(consoleHandler);

		logger.info("Hello from logger!");
		logger.severe("Hello from logger!");
		logger.warning("Hello from logger!");
		logger.fine("Hello from logger!");
		logger.finest("Hello from logger!");
	}
}
