package rs.ac.ni.pmf.oop3.vezbe.vezba02.logging;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class HtmlFormatter extends Formatter
{
	@Override
	public String getHead(Handler h)
	{
		return "<table border='1'><tr><th>LEVEL</th><th>TIME</th><th>MESSAGE</th></tr>";
	}

	@Override
	public String getTail(Handler h)
	{
		return "</table>";
	}

	@Override
	public String format(LogRecord record)
	{
		final String level = record.getLevel().getName();
		final String message = record.getMessage();
		final LocalDateTime time = LocalDateTime.ofInstant(record.getInstant(), ZoneId.of("UTC"));

		return String.format(
			"<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
			level,
			time.format(DateTimeFormatter.ISO_DATE_TIME),
			message);
	}
}
