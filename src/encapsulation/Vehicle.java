package encapsulation;

public class Vehicle {
	private char vehicleType,fuelType;
	private String regNum;
	public Vehicle(char vehicleType, char fuelType, String regNum) {
		if(vehicleType == 'M' || vehicleType == 'C') {
			this.vehicleType = vehicleType;
		}else {
			throw new IllegalArgumentException("Invalid vehicle type.");
		}
		if((fuelType == 'H' && this.vehicleType == 'C')|| fuelType == 'E' || fuelType == 'D' || fuelType == 'G') {
			this.fuelType = fuelType;
		}else {
			throw new IllegalArgumentException("Invalid fuel type.");
		}
		setRegistrationNumber(regNum);
	}
	public void setRegistrationNumber(String regNum) {
		String regNumLetters = "";
		String regNumNumbers = "";
		if(fuelType == 'E'){
			regNumLetters = "(EL|EK)";
		}else if(fuelType == 'H') {
			regNumLetters = "(HY)";
		}else {
			regNumLetters = "[A-Z][A-Z]";
		}
		if(vehicleType == 'M') {
			regNumNumbers = "[0-9]{4}";
		}else {
			regNumNumbers = "[0-9]{5}";
		}
		if(regNum.matches(regNumLetters + "" + regNumNumbers) && !(regNum.substring(0,2).matches("(EL|EK|HY)") && (fuelType == 'D' || fuelType == 'G'))) {
			this.regNum = regNum;
		}else {
			throw new IllegalArgumentException("Invalid registration number");
		}
	}
	public String getRegistrationNumber() {
		return regNum;
	}
	public char getVehicleType() {
		return vehicleType;
	}
	public char getFuelType() {
		return fuelType;
	}
	public static void main(String[] args) {
		Vehicle v = new Vehicle('C','G',"AB12345");
		System.out.println(v.getRegistrationNumber());
	}
}
