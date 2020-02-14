package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Train {
	List<TrainCar> cars = new ArrayList<>();
	public void addTrainCar(TrainCar car) {cars.add(car);}
	public boolean contains(TrainCar car) {return cars.contains(car);}
	public int getTotalWeight() {
		return cars.stream()
				.mapToInt(TrainCar::getTotalWeight)
				.sum();
	}
	public int getPassengerCount() {
		return cars.stream()
				.filter(car -> car instanceof PassengerCar)
				.map(car -> (PassengerCar) car)
				.mapToInt(PassengerCar::getPassengerCount)
				.sum();
	}
	public int getCargoWeight() {
		return cars.stream()
				.filter(car -> car instanceof CargoCar)
				.map(car -> (CargoCar) car)
				.mapToInt(CargoCar::getCargoWeight)
				.sum();
	}
	public String toString() {
		String result = "";
		for(TrainCar car : cars) {
			if(car instanceof CargoCar) {
				result += "Cargo car, " + car.getTotalWeight() + " kg\n";
			}else if(car instanceof PassengerCar) {
				result += "Passenger car, " + car.getTotalWeight() + " kg\n";
			}else {
				result += "Train car, " + car.getTotalWeight() + " kg \n";
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Train train = new Train();
		PassengerCar pcar = new PassengerCar(10,100);
		CargoCar ccar = new CargoCar(500,100);
		train.addTrainCar(pcar);
		train.addTrainCar(ccar);
		System.out.println(train);
	}
}
