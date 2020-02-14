package patterns.delegation.office;

import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	private List<Employee> employees;
	private int taskCount;
	private int index;
	public Manager(List<Employee> employees) {
		if(employees.size() == 0) {
			throw new IllegalArgumentException("Must have employees!");
		}
		this.employees = employees;
		taskCount = 0;
		index = -1;
	}
	public int getTaskCount() {return taskCount;}
	public int getResourceCount() {
		return employees.stream().mapToInt(Employee::getResourceCount).sum() + 1;
	}
	public int chooseEmployee() {
		index++;
		if(index >= employees.size()) {
			index = 0;
		}
		return index;
	}
	public double doCalculations(BinaryOperator<Double> operator, double value1, double value2) {
		taskCount++;
		return employees.get(chooseEmployee()).doCalculations(operator, value1, value2);
	}
	public void printDocument(String document) {
		taskCount++;
		employees.get(chooseEmployee()).printDocument(document);
	}
	
}
