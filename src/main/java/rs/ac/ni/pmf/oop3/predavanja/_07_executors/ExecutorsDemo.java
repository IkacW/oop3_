package rs.ac.ni.pmf.oop3.predavanja._07_executors;

import java.util.*;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorsDemo
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

		log.info("Scheduling task");
		final ScheduledFuture<Integer> scheduledFuture =
			executorService.schedule(new CallableTask(100, "T1", 3, 4), 3, TimeUnit.SECONDS);

		executorService
			.scheduleAtFixedRate(() -> {
				log.info("[{}]Checking...", Thread.currentThread().isDaemon());
			}, 1, 1, TimeUnit.SECONDS);

		final int result = scheduledFuture.get();

		log.info("Result: {}", result);

		executorService.shutdown();
	}

	public static void main3(String[] args)
	{
		final Random random = new Random();
		final List<Future<Integer>> futures = new ArrayList<>();

		final ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++)
		{
			sleep(100);
			final Future<Integer> future = executorService
				.submit(new CallableTask(
					100 * (random.nextInt(10) + 1),
					"Task_" + i,
					random.nextInt(100),
					random.nextInt(100)));
			futures.add(future);
		}

		executorService.shutdown();
	}

	public static void main2(String[] args) throws InterruptedException
	{
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Application is finishing...");
		}));

		final int availableProcessors = Runtime.getRuntime().availableProcessors();

		final Random random = new Random();
		final ExecutorService executorService =
			Executors.newFixedThreadPool(availableProcessors > 1 ? availableProcessors - 1 : 1);

		final List<Future<Integer>> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++)
		{
			final Future<Integer> future = executorService
				.submit(new CallableTask(
					100 * (random.nextInt(10) + 1),
					"Task_" + i,
					random.nextInt(100),
					random.nextInt(100)));
			futures.add(future);
		}

		executorService.shutdown();

		for (final Future<Integer> future : futures)
		{
			try
			{
				int result = future.get();
				//				System.out.println(result);
			}
			catch (ExecutionException e)
			{
				System.err.println(e.getCause().getMessage());
			}
		}
	}

	public static void main1(String[] args) throws InterruptedException
	{
		final ExecutorService executorService = Executors.newSingleThreadExecutor();

		Future<Integer> future = executorService.submit(new CallableTask(50, "T1", 4, 0));

		executorService.shutdown();

		log.info("All tasks submitted");

		Integer value = null;

		while (!future.isDone())
		{
			System.out.println("Waiting for task to complete...");
			try
			{
				value = future.get(50, TimeUnit.MILLISECONDS);
			}
			catch (final ExecutionException e)
			{
				System.err.println("Task failed: " + e.getMessage());
				return;
			}
			catch (final TimeoutException e)
			{
				System.out.println("Not done yet...");
			}
		}

		if (value == null)
		{
			try
			{
				value = future.get();
			}
			catch (ExecutionException e)
			{
				System.err.println("Task failed: " + e.getMessage());
				return;
			}
		}

		System.out.println("Result: " + value);
	}

	private static void sleep(long timeout)
	{
		try
		{
			Thread.sleep(timeout);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
