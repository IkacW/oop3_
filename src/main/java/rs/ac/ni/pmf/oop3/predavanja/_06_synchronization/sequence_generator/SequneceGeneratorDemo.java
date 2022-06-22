package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.sequence_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequneceGeneratorDemo
{
	//private final SequenceGenerator _sequenceGenerator = new UnsafeSequenceGenerator();
	private final SequenceGenerator _sequenceGenerator = new SafeSequenceGenerator();

	private void generateNumbers() throws InterruptedException
	{
		final List<SequenceWorker> workers = new ArrayList<>();
		IntStream.range(0, 10)
			.forEach(i -> workers.add(new SequenceWorker(_sequenceGenerator, "worker_" + i, 10)));

		workers.forEach(Thread::start);

		for (final Thread t : workers)
		{
			t.join();
		}

		System.out.println("Done!");
	}

	public static void main(String[] args) throws InterruptedException
	{
		log.info("Starting number generation");
		log.error("Only to file");
		new SequneceGeneratorDemo().generateNumbers();
	}
}
