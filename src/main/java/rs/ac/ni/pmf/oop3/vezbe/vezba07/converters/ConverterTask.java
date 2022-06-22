package rs.ac.ni.pmf.oop3.vezbe.vezba07.converters;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public abstract class ConverterTask implements Callable<String>
{
	private final CountDownLatch _countDownLatch;
	private final String _value;
	private final long _timeout;

	@Override
	public String call() throws Exception
	{
		log.info("Converting the value with converter: {}", getConverterName());
		final String convertedValue = convert(_value);

		try
		{
			Thread.sleep(_timeout);
		}
		catch (InterruptedException e)
		{
			log.warn("{} -: Conversion abandoned", getConverterName());
			throw e;
		}
		log.info("{} - Countdown", getConverterName());
		_countDownLatch.countDown();
		log.info("{} - Converted value: {}", getConverterName(), convertedValue);
		return convertedValue;
	}

	protected abstract String convert(final String value);

	protected abstract String getConverterName();
}
