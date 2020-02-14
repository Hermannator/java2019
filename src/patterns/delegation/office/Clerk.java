package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {
	Printer printer;
	int taskCount;
	public Clerk(Printer printer) {
		this.printer = printer;
		taskCount = 0;
	}
	public int getTaskCount() {return taskCount;}
	public int getResourceCount() {return 1;}
	public double doCalculations(BinaryOperator<Double> operator, double value1, double value2) {
		taskCount++;
		return operator.apply(value1, value2);
	}
	public void printDocument(String document) {
		taskCount++;
		printer.printDocument(document, this);
	}
}
