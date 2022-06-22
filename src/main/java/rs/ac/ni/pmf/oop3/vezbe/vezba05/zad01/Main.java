package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad01;

public class Main
{
	public static void main(String[] args)
	{
		MyThread t = new MyThread("Other Thread");
		t.start();
	}
}
