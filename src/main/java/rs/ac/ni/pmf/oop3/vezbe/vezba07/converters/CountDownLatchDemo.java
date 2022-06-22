package rs.ac.ni.pmf.oop3.vezbe.vezba07.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountDownLatchDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		final ExecutorService executorService = Executors.newCachedThreadPool();

		final List<ConverterTask> converters = new ArrayList<>();
		final List<Future<String>> futures = new ArrayList<>();

		final CountDownLatch countDownLatch = new CountDownLatch(2);
		final String message = "This is a message";

		converters.add(new ScramblerTask(countDownLatch, message, 1000));
		converters.add(new ReverserTask(countDownLatch, message, 2000));
		converters.add(new ScramblerTask(countDownLatch, message, 3000));
		converters.add(new ReverserTask(countDownLatch, message, 4000));
		converters.add(new CapitalizerTask(countDownLatch, message, 1500));
		converters.add(new ScramblerTask(countDownLatch, message, 2000));

		for (final ConverterTask converterTask : converters)
		{
			futures.add(executorService.submit(converterTask));
		}

		countDownLatch.await();

		log.info("Enough tasks have finished, abandoning other tasks");

		futures.forEach(future -> future.cancel(true));

		for (final Future<String> future : futures)
		{
			try
			{
				final String value = future.get();
				System.out.println(value);
			}
			catch (CancellationException e)
			{
				System.out.println("This task has been abandoned!");
			}
			catch (ExecutionException e)
			{
				System.out.println("This task has been canceled!");
			}
		}
	}
}
