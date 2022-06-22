package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator;

import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.CalculatorException;

public class CalcMain
{
	public static void main(String[] args)
	{
		final IntegerCalculator calculator = new IntegerCalculator();

		try
		{
			calculator.addOperand(3);
			calculator.addOperand(5);
			calculator.setOperation('+');
			System.out.println(calculator.calculate());
		}
		catch (CalculatorException e)
		{
			e.printStackTrace();
		}
	}
}
