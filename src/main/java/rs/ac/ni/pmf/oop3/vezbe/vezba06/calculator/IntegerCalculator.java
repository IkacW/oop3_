package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator;

import java.util.Set;
import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.CalculatorException;

public class IntegerCalculator implements Calculator<Integer, Integer>
{
	protected Integer first;
	protected Integer second;
	protected Character operation;

	@Override
	public void addOperand(final Integer operand) throws CalculatorException
	{
		if (first == null)
		{
			first = operand;
		}
		else if (second == null)
		{
			second = operand;
		}
		else
		{
			throw new CalculatorException(CalculatorException.ErrorCode.TOO_MANY_OPERANDS, "Too many operands");
		}
	}

	@Override
	public void removeLastOperand() throws CalculatorException
	{
		if (second != null)
		{
			second = null;
		}
		else if (first != null)
		{
			first = null;
		}
		else
		{
			throw new CalculatorException(CalculatorException.ErrorCode.NO_OPERANDS, "There are no operands to delete");
		}
	}

	@Override
	public void setOperation(final Character operation) throws CalculatorException
	{
		if (!getAvailableOperations().contains(operation))
		{
			throw new CalculatorException(
				CalculatorException.ErrorCode.UNKNOWN_OPERATION,
				"Operation '" + operation + "' is not allowed");
		}

		this.operation = operation;
	}

	@Override
	public Set<Character> getAvailableOperations()
	{
		return Set.of('+', '-', '*', '/', '%');
	}

	@Override
	public Integer calculate() throws CalculatorException
	{
		if (operation == null)
		{
			throw new CalculatorException(CalculatorException.ErrorCode.OPERATION_NOT_DEFINED, "There is no operation defined");
		}

		if (first == null || second == null)
		{
			throw new CalculatorException(CalculatorException.ErrorCode.CALCULATION_ERROR, "Both operands must be defined");
		}

		switch (operation)
		{
		case '+':
			return first + second;
		case '-':
			return first - second;
		case '*':
			return first * second;
		case '/':
			assertDivisionIsPossible();
			return first / second;
		case '%':
			assertDivisionIsPossible();
			return first % second;
		default:
			throw new CalculatorException(CalculatorException.ErrorCode.UNKNOWN_OPERATION, "Unknown operation '" + operation +
				"'");
		}
	}

	private void assertDivisionIsPossible() throws CalculatorException
	{
		if (second == 0)
		{
			throw new CalculatorException(CalculatorException.ErrorCode.CALCULATION_ERROR, "Division by zero");
		}
	}
}
