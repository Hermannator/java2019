package interfaces;

public class Person1 implements Named {
	private String givenName;
	private String familyName;
	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}
	public String getGivenName() {return givenName;}
	public String getFamilyName() {return familyName;}
	public String getFullName() {return givenName + " " + familyName;}
	public void setGivenName(String givenName) {this.givenName = givenName;}
	public void setFamilyName(String familyName) {this.familyName = familyName;}
	public void setFullName(String fullName) {
		String[] fullNameSplit = fullName.split(" ");
		this.givenName = fullNameSplit[0];
		this.familyName = fullNameSplit[1];
	}
}
