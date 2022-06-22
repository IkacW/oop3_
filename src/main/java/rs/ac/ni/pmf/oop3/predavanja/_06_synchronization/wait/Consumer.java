package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.wait;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Consumer extends Thread
{
	private final SharedStorage _storage;

	@Override
	public void run()
	{
		log.info(_storage.get());
	}
}
