package rs.ac.ni.pmf.oop3.vezbe.vezba07.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo
{
	public static void main(String[] args)
	{
		final BlockingQueue<Integer> storage = new ArrayBlockingQueue<>(2);
		new Thread(new Producer(storage, 10)).start();
		new Thread(new Consumer(storage)).start();
	}
}
