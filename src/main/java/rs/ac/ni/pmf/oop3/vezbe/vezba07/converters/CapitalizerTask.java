package rs.ac.ni.pmf.oop3.vezbe.vezba07.converters;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CapitalizerTask extends ConverterTask
{
	public CapitalizerTask(final CountDownLatch countDownLatch, final String value, final long timeout)
	{
		super(countDownLatch, value, timeout);
	}

	@Override
	protected String convert(final String value)
	{
		return value.toUpperCase(Locale.ROOT);
	}

	@Override
	protected String getConverterName()
	{
		return "Capitalizer";
	}
}
