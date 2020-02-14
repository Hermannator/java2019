package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	Map<Employee, List<String>> history;
	public Printer() {
		history = new HashMap<>();
	}
	public void printDocument(String document, Employee employee) {
		if(!history.containsKey(employee)) {
			history.put(employee, new ArrayList<>());
		}
		history.get(employee).add(document);
	}
	List<String> getPrintHistory(Employee employee){
		if(history.containsKey(employee)) {
			return history.get(employee);
		}else {
			return new ArrayList<>();
		}
	}
}
