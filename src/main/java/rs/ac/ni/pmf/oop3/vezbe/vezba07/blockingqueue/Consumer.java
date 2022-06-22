package rs.ac.ni.pmf.oop3.vezbe.vezba07.blockingqueue;

import java.util.concurrent.BlockingQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;

@Slf4j
@RequiredArgsConstructor
public class Consumer implements Runnable
{
	private final BlockingQueue<Integer> _storage;

	@Override
	public void run()
	{
		try
		{
			log.info("CONSUMER: Waiting for next value...");
			int value = _storage.take();
			while (value != -1)
			{
				log.info("CONSUMER: Value {} obtained", value);
				processValue(value);

				value = _storage.take();
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		log.info("CONSUMER: Finished");
	}

	private void processValue(final int value)
	{
		System.out.println("Processing value " + value);
		WaitUtil.sleep(500);
	}
}
