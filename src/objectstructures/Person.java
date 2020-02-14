package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private char gender;
	private Person father, mother;
	private List<Person> children = new ArrayList<>();
	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}
	public void addChild(Person child) {
		if(child == this) {
			throw new IllegalArgumentException("Cannot be your own child.");
		}
		children.add(child);
		if(gender == 'F') {
			if(child.getMother() != this) {
				child.setMother(this);
			}
		}else if(gender == 'M') {
			if(child.getFather() != this) {
				child.setFather(this);
			}
		}
	}
	public void removeChild(Person child) {
		if(children.contains(child)) {
			children.remove(child);
			if(gender == 'F') {
				child.setMother(null);
			}else if(gender == 'M') {
				child.setFather(null);
			}
		}
	}
	public void setFather(Person newFather) {
		Person oldFather = father;
		if(newFather == this) {
			throw new IllegalArgumentException("Cannot father self.");
		}
		if(newFather != null) {
			if(newFather.getGender() != 'M') {
				throw new IllegalArgumentException("Father must be male.");
			}
		}
		if(!(oldFather == null)) {
			oldFather.removeChild(this);
		}
		father = newFather;
		if(newFather != null) {
			if(!newFather.getChildren().contains(this)) {
				newFather.addChild(this);
			}
		}
	}
	public void setMother(Person newMother) {
		Person oldMother = mother;
		if(newMother == this) {
			throw new IllegalArgumentException("Cannot mother self.");
		}
		if(newMother != null) {
			if(newMother.getGender() != 'F') {
				throw new IllegalArgumentException("Mother must be female.");
			}
		}
		if(!(oldMother == null)) {
			oldMother.removeChild(this);
		}
		mother = newMother;
		if(newMother != null) {
			if(!newMother.getChildren().contains(this)) {
				newMother.addChild(this);
			}
		}
	}
	public String getName() {
		return name;
	}
	public char getGender() {
		return gender;
	}
	public Person getFather() {
		return father;
	}
	public Person getMother() {
		return mother;
	}
	public Person getChild(int n) {
		if(n < this.getChildCount()) {
			return children.get(n);
		}else {
			throw new IllegalArgumentException("Illegal child number.");
		}
	}
	public List<Person> getChildren(){
		return children;
	}
	public int getChildCount() {
		return children.size();
	}
}
