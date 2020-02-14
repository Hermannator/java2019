package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
	Iterator<Double> iterator1;
	Iterator<Double> iterator2;
	BinaryOperator<Double> operator;
	Double default1;
	Double default2;
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
	}
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		this.default1 = default1;
		this.default2 = default2;
	}
	public boolean hasNext() {
		return (iterator1.hasNext() || default1 != null) && (iterator2.hasNext() || default2 != null) && (iterator1.hasNext() || iterator2.hasNext());
	}
	public Double next() {
		Double iterator1Next;
		Double iterator2Next;
		if(iterator1.hasNext()) {
			iterator1Next = iterator1.next();
		}else {
			iterator1Next = default1;
		}
		if(iterator2.hasNext()) {
			iterator2Next = iterator2.next();
		}else {
			iterator2Next = default2;
		}
		return operator.apply(iterator1Next, iterator2Next);
	}
}
