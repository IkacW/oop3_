package rs.ac.ni.pmf.oop3.vezbe.vezba07.converters;

import java.util.concurrent.CountDownLatch;

public class ReverserTask extends ConverterTask
{
	public ReverserTask(CountDownLatch _countDownLatch, String _value, long _timeout)
	{
		super(_countDownLatch, _value, _timeout);
	}

	@Override
	protected String convert(final String value)
	{
		return new StringBuilder(value).reverse().toString();
	}

	@Override
	protected String getConverterName()
	{
		return "Reverser";
	}
}
