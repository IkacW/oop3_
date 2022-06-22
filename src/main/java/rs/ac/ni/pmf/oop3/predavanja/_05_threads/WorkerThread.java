package rs.ac.ni.pmf.oop3.predavanja._05_threads;

import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerThread extends Thread
{
	private final int n;
	private final Random random = new Random();

	@Override
	public void run()
	{
		for (int i = 0; i < n; i++)
		{
			System.out.println(Thread.currentThread().getName() + ": " + i);
			try
			{
				Thread.sleep(random.nextInt(1000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
