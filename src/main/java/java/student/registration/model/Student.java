package java.student.registration.model;

import java.util.Date;

public class Student {

	private Integer code;
    private String name;
    private Integer age;
    private String school;
    private Date dob; // New field for date of birth
    private String email;
    private String mobile;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getDob() {
        return dob;
    }

  

	public void setDob(Date dob) {
        this.dob = dob;
    }
}
