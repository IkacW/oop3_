package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.wait;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Producer extends Thread
{
	private final int _value;
	private final SharedStorage _storage;

	@Override
	public void run()
	{
		_storage.set("Message " + _value);
	}
}
