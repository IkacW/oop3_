package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad03;

import java.io.PrintStream;
import lombok.RequiredArgsConstructor;

public class WatcherThread extends Thread
{
	private final ResponsiveUI uiThread;
	private final PrintStream printStream;

	public WatcherThread(final ResponsiveUI ui, final PrintStream printStream)
	{
		setDaemon(true);
		uiThread = ui;
		this.printStream = printStream;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
			}

			printStream.printf("Current value: %f%n", uiThread.getD());
		}
	}
}
