package rs.ac.ni.pmf.oop3.vezbe.vezba02.logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConfigurableLogging
{
	private static final Logger _log;

	static
	{
//		final String path = ConfigurableLogging.class.getClassLoader()
//			.getResource("logging.properties")
//			.getPath();
//
//		System.out.println(path);
//
//		System.setProperty("java.util.logging.config.file", path);

		final InputStream is = ConfigurableLogging.class.getClassLoader()
			.getResourceAsStream("logging.properties");

		if (is != null)
		{
			try
			{
				LogManager.getLogManager().readConfiguration(is);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Logging configuration not found in resources!");
		}

		_log = Logger.getLogger(ConfigurableLogging.class.getName());
	}

	public static void main(String[] args)
	{
		_log.severe("FILE:A big problem");
		_log.info("FILE:Some info");
		_log.fine("FILE:Fine message");
		_log.finest("FILE:The finest message");
	}
}
