package interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalc {
	private Stack<Double> numbers = new Stack<>();
	private Map<Character, BinaryOperator<Double>> operators = new HashMap<>();
	public boolean addOperator(char sign, BinaryOperator<Double> operator) {
		if(operators.get(sign) == null) {
			operators.put(sign, operator);
			return true;
		}else {
			return false;
		}
	}
	public void removeOperator(char sign) {
		operators.remove(sign);
	}
	public void push(double newNum) {
			numbers.push(newNum);
	}
	public double pop() {
		if(numbers.empty()) {
			return Double.NaN;
		}else {
			return numbers.pop();
		}
	}
	public double peek(int index) {
		if(index < numbers.size() && index >= 0) {
			return(numbers.get(numbers.size() - 1 - index));
		}else {
			return Double.NaN;
		}
	}
	public int getSize() {
		return(numbers.size());
	}
	public void performOperation(char sign) {
		if(sign == '~') {
			Double temp1 = this.pop();
			Double temp2 = this.pop();
			this.push(temp1);
			this.push(temp2);
		}else if(sign == 'p') {
			this.push(Math.PI);
		}else if(sign == '|') {
			this.push(Math.abs(this.pop()));
		}else if(operators.containsKey(sign)) {
			Double temp1 = this.pop();
			Double temp2 = this.pop();
			push(operators.get(sign).apply(temp2, temp1));
		}else {
			throw new UnsupportedOperationException("Operation unsupported");
		}
	}
	public String toString() {
		String tempStr = "";
		for(int i = 0; i < numbers.size(); i++) {
			tempStr += numbers.get(i) + ", ";
		}
		return tempStr.substring(0,tempStr.length() - 2);
	}
	public static void main(String[] args) {
		RPNCalc c = new RPNCalc();
		System.out.println(c.pop());
		c.push(4);
		c.push(3);
		c.performOperation('p');
		System.out.println(c);
		System.out.println(c.getSize());
		System.out.println(c.peek(2));
		System.out.println(c.pop());
		System.out.println(c);
		c.performOperation('+');
		System.out.println(c);
	}
}
