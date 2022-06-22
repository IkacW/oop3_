//package rs.ac.ni.pmf.oop3.vezbe.vezba06;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CyclicBarrier;
//
//class Solver
//{
//	final int N;
//	final float[][] data;
//	final CyclicBarrier barrier;
//
//	class Worker implements Runnable
//	{
//		int myRow;
//
//		public Worker(int row)
//		{
//			myRow = row;
//		}
//
//		public void run()
//		{
//			while (!done())
//			{
//				processRow(myRow);
//				try
//				{
//					barrier.await();
//				}
//				catch (InterruptedException ex)
//				{
//					return;
//				}
//				catch (BrokenBarrierException ex)
//				{
//					return;
//				}
//			}
//		}
//	}
//
//	public Solver(float[][] matrix) throws InterruptedException
//	{
//		data = matrix;
//		N = matrix.length;
//		Runnable barrierAction = () -> mergeRows(...);
//		barrier = new CyclicBarrier(N, barrierAction);
//		List<Thread> threads = new ArrayList<>(N);
//		for (int i = 0; i < N; i++)
//		{
//			Thread thread = new Thread(new Worker(i));
//			threads.add(thread);
//			thread.start();
//		}          // wait until done
//		for (Thread thread : threads)
//		{
//			thread.join();
//		}
//	}
//}
