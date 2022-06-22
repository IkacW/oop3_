package rs.ac.ni.pmf.oop3.predavanja._07_executors.listeners;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyListeners implements ListeningCallableTask.MyCallableListener
{
	public static void main(String[] args)
	{
		new MyListeners().doDemo();
	}

	public void doDemo()
	{
		final ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new ListeningCallableTask(100, "T1", 4, 2, this));
		executorService.submit(new ListeningCallableTask(100, "T2", 4, 0, this));
	}

	@Override
	public void onTaskFinished(final String taskId, final int result)
	{
		log.info("Task {}: {}", taskId, result);
	}

	@Override
	public void onTaskFailed(final String taskId, final Throwable error)
	{
		log.error("Task {}: {}", taskId, error.getMessage());
	}
}
