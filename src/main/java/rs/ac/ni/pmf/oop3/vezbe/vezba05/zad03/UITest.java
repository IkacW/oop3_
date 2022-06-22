package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad03;

import java.io.IOException;

public class UITest
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
//		final UnresponsiveUI ui = new UnresponsiveUI();
//		final ResponsiveUIDaemonThread ui = new ResponsiveUIDaemonThread();
		final ResponsiveUI ui = new ResponsiveUI();
		ui.start();

		final WatcherThread watcher = new WatcherThread(ui, System.err);
		watcher.start();

//		for (int i = 0; i < 10; i++)
//		{
//			Thread.sleep(300);
//			System.out.println("d = " + ui.getD());
//		}

		System.out.println("Press enter to finish");
		System.in.read();
		ui.interrupt();
		watcher.interrupt();
		ui.join();

		System.out.println("Finally, d = " + ui.getD());
	}
}
