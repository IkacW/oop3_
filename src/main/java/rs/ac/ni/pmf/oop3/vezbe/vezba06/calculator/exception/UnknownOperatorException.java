package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception;

public class UnknownOperatorException extends CalculatorException
{
	public UnknownOperatorException(final String message)
	{
		super(ErrorCode.UNKNOWN_OPERATION, message);
	}
}
