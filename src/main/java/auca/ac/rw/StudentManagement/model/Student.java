package auca.ac.rw.StudentManagement.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "student_id")
	private UUID studentId = UUID.randomUUID();

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "address")
	private String adddress;

	public Student() {

	}

	public Student(String firstName, String lastName, Date dateOfBirth, String adddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.adddress = adddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdddress() {
		return adddress;
	}

	public void setAdddress(String adddress) {
		this.adddress = adddress;
	}

}
