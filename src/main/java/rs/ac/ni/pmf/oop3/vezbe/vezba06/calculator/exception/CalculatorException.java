package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception;

import lombok.Getter;

@Getter
public class CalculatorException extends Exception
{
	final ErrorCode errorCode;

	public CalculatorException(ErrorCode errorCode, String message)
	{
		super(message);
		this.errorCode = errorCode;
	}

	public enum ErrorCode
	{
		TOO_MANY_OPERANDS,
		NO_OPERANDS,
		UNKNOWN_OPERATION,
		NOT_ENOUGH_OPERANDS,
		CALCULATION_ERROR,
		OPERATION_NOT_DEFINED
	}
}
