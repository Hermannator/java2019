package encapsulation;
import java.util.Stack;

public class RPNCalc {
	private Stack<Double> numbers = new Stack<>();
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
	public void performOperation(char operation) {
		if(operation == '+') {
			this.push(this.pop() + this.pop());
		}else if(operation == '-') {
			double temp = this.pop();
			this.push(this.pop() - temp);
		}else if(operation == '*') {
			this.push(this.pop() * this.pop());
		}else if(operation == '/') {
			double temp = this.pop();
			this.push(this.pop() / temp);
		}else if(operation == '~') {
			Double temp1 = this.pop();
			Double temp2 = this.pop();
			this.push(temp1);
			this.push(temp2);
		}else if(operation == 'p') {
			this.push(Math.PI);
		}else if(operation == '|') {
			this.push(Math.abs(this.pop()));
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
