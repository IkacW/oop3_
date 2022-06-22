package rs.ac.ni.pmf.oop3.predavanja._07_executors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class RunnableTask implements Runnable
{
	private final int a;
	private final int b;
	private Exception e;
	private int result;

	@Override
	public void run()
	{
		log.info("Computing {}/{}", a, b);
		try
		{
			Thread.sleep(20);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			result = a/b;
		}
		catch (ArithmeticException e)
		{
			this.e = e;
		}
	}
}
