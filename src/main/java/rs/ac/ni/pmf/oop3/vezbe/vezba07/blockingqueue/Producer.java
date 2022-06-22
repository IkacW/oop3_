package rs.ac.ni.pmf.oop3.vezbe.vezba07.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;

@Slf4j
@RequiredArgsConstructor
public class Producer implements Runnable
{
	private final BlockingQueue<Integer> _storage;
	private final int _limit;

	@Override
	public void run()
	{
		for (long count = _limit; count > 0; count--)
		{
			int i = createProduct();
			try
			{
				_storage.put(i);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		log.info("PRODUCER: Production completed");
		try
		{
			_storage.put(-1);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private int createProduct()
	{
		final int timeout = ThreadLocalRandom.current().nextInt(10);
		final int value = ThreadLocalRandom.current().nextInt(100) + 1;
		log.info("PRODUCER: Producing value: {}", value);
		WaitUtil.sleep(timeout * 100);

		log.info("PRODUCER: Value {} created", value);
		return value;
	}
}
