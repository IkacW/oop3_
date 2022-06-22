package rs.ac.ni.pmf.oop3.vezbe.vezba07.converters;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class ScramblerTask extends ConverterTask
{
	public ScramblerTask(CountDownLatch _countDownLatch, String _value, long _timeout)
	{
		super(_countDownLatch, _value, _timeout);
	}

	@Override
	protected String convert(String value)
	{
		final List<Character> chars = value.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
		Collections.shuffle(chars);
		return chars.stream().map(String::valueOf).reduce("", (s, character) -> s + character);
	}

	@Override
	protected String getConverterName()
	{
		return "Scrambler";
	}
}
