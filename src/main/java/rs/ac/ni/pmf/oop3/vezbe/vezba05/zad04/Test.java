package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad04;

public class Test
{
	public static void main(String[] args)
	{
		final GreenhouseController greenhouseController = new GreenhouseController();

		greenhouseController.addEvent(greenhouseController.new Bell(900));

		Event[] events = {
			greenhouseController.new ThermostatNight(0),
			greenhouseController.new LightOn(200),
			greenhouseController.new LightOff(400),
			greenhouseController.new WaterOn(600),
			greenhouseController.new WaterOff(800),
			greenhouseController.new ThermostatDay(1400)
		};

		greenhouseController.addEvent(greenhouseController.new Restart(2000, events));

		greenhouseController.addEvent(greenhouseController.new Terminate(5000));

		greenhouseController.run();
	}
}
