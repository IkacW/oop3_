package rs.ac.ni.pmf.oop3.predavanja._07_executors.listeners;

import rs.ac.ni.pmf.oop3.predavanja._07_executors.CallableTask;

public class ListeningCallableTask extends CallableTask
{
	public interface MyCallableListener
	{
		public void onTaskFinished(String taskId, int result);

		public void onTaskFailed(String taskId, Throwable error);
	}

	private final MyCallableListener listener;

	public ListeningCallableTask(
		final long timeout,
		final String taskId,
		final int a,
		final int b,
		final MyCallableListener listener)
	{
		super(timeout, taskId, a, b);
		this.listener = listener;
	}

	@Override
	public Integer call() throws Exception
	{
		try
		{
			int value = super.call();
			listener.onTaskFinished(getTaskId(), value);
			return value;
		}
		catch (Exception e)
		{
			listener.onTaskFailed(getTaskId(), e);
			throw e;
		}
	}
}
