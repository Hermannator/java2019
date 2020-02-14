package inheritance;

public class TrainCar {
	private int deadWeight;
	public TrainCar(int deadWeight) {setDeadWeight(deadWeight);}
	public int getDeadWeight() {return deadWeight;}
	public int getTotalWeight() {return getDeadWeight();}
	public void setDeadWeight(int deadWeight) {this.deadWeight = deadWeight;}
}
