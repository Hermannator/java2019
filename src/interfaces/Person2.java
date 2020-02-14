package interfaces;

public class Person2 implements Named {
	private String fullName;
	public Person2(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {return fullName;}
	public String getGivenName() {return fullName.split(" ")[0];}
	public String getFamilyName() {return fullName.split(" ")[1];}
	public void setFullName(String fullName) {this.fullName = fullName;}
	public void setGivenName(String givenName) {fullName = givenName + " " + fullName.split(" ")[1];}
	public void setFamilyName(String familyName) {fullName = fullName.split(" ")[0] + " " + familyName;}
}
