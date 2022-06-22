package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.sequence_generator;

import java.io.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SequenceWorker extends Thread
{
	private final SequenceGenerator _sequenceGenerator;
	private final String _name;
	private final int _count;

	@Override
	public void run()
	{
		try (final BufferedWriter out = new BufferedWriter(new FileWriter("sequnce_" + _name + ".out")))
		{
			for (int i = 0; i < _count; i++)
			{
				out.write(String.format("%d ", _sequenceGenerator.getAndIncrease()));

				if (i % 10 == 9)
				{
					out.newLine();
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
