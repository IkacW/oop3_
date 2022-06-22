package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread extends Thread
{
	@Override
	public void run()
	{
		log.info("custom run()");
	}

	@Override
	public synchronized void start()
	{
		log.info("start ()");
		run();
		super.start();
	}

	public static void main(String[] args)
	{
		final MyThread myThread = new MyThread();
//		myThread.start();
//		log.info("main");

		new Thread(myThread::run).start();
		new Thread(myThread::start).start();
	}
}
