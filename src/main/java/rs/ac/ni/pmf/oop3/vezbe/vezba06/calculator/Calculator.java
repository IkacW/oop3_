package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator;

import java.util.Set;
import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.CalculatorException;

public interface Calculator<T, R>
{
	void addOperand(T operand) throws CalculatorException;

	void removeLastOperand() throws CalculatorException;

	void setOperation(Character operation) throws CalculatorException;

	Set<Character> getAvailableOperations();

	R calculate() throws CalculatorException;
}
