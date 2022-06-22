package rs.ac.ni.pmf.oop3.vezbe.vezba02.logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter
{
	private static final String PREFIX = "FILE:";

	@Override
	public boolean isLoggable(LogRecord record)
	{
		final String message = record.getMessage();

		if (message == null)
		{
			return false;
		}

		return message.startsWith(PREFIX);
	}
}
