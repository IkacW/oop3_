package rs.ac.ni.pmf.oop3.vezbe.vezba06.calc;

import java.util.Set;

public interface Calculator<T, R>
{
	void addOperand(T operand);
	void removeLastOperand();
	void setOperation(Character operation);
	Set<Character> getAvailableOperations();
	R calculate();
}
