package rs.ac.ni.pmf.oop3.vezbe.vezba02.slf4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slf4jDemo
{
	public static void main(String[] args)
	{
		log.error("A big problem");
		log.warn("I'm warning you");
		log.info("Some info");
		log.debug("Debug message");
		log.trace("The finest message");
	}
}
