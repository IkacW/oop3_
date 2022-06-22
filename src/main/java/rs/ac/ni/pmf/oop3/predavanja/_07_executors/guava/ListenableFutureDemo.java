package rs.ac.ni.pmf.oop3.predavanja._07_executors.guava;

import java.util.concurrent.*;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.predavanja._07_executors.CallableTask;

@Slf4j
public class ListenableFutureDemo implements FutureCallback<Integer>
{
	public static void main(String[] args)
	{
		//		new ListenableFutureDemo().doDemo();

		final ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		final ExecutorService exitingExecutorService =
			MoreExecutors.getExitingExecutorService(executor, 50, TimeUnit.MILLISECONDS);

		for (int i = 0; i < 10; i++)
		{
			exitingExecutorService.submit(new CallableTask(500 * (i + 1), "Task_" + i, 2 * i, i));
		}

		double sum = 0.0;
		log.info("Doing some complicated stuff...");
		for (int i = 1; i < 100000000; i++)
		{
			if (i % 10000000 == 0)
			{
				log.info("Still working...");
			}
			sum += Math.sqrt(Math.log(i));
		}
	}

	private void doDemo()
	{
		final ExecutorService executorService = Executors.newFixedThreadPool(2);
		final ListeningExecutorService listeningExecutorService =
			MoreExecutors.listeningDecorator(executorService);

		final ListenableFuture<Integer> listenableFuture =
			listeningExecutorService.submit(new CallableTask(100, "Task-1", 5, 2));

		Futures.addCallback(listenableFuture, this, executorService);

		double sum = 0.0;

		log.info("Doing some complicated stuff...");
		for (int i = 1; i < 1000000000; i++)
		{
			if (i % 100000000 == 0)
			{
				log.info("Still working...");
			}
			sum += Math.sqrt(Math.log(i));
		}

		log.info("Done");

		listeningExecutorService.shutdown();
	}

	@Override
	public void onSuccess(final Integer result)
	{
		log.info("Result: {}", result);
	}

	@Override
	public void onFailure(final Throwable throwable)
	{
		log.error("Error: ", throwable);
	}
}
