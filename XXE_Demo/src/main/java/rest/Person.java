
package rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {

  
	private String firstName;
	private String lastName;
	private int age;
  private int id;

	// Must have no-argument constructor
	public Person() {}

	public Person(String fname, String lname, int age) {
		this.firstName = fname;
		this.lastName = lname;
		this.age = age;
	}

	@XmlElement
	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getFirstName() {
		return this.firstName;
	}

  @XmlElement
  public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String getLastName() {
		return this.lastName;
	}

@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", age=" + age + '}';
  }
  


}