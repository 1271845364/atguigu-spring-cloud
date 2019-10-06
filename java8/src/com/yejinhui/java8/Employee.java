package com.yejinhui.java8;

public class Employee {

	// private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	private Status status;

	public Employee() {
	}

	// public Employee(Integer id) {
	// this.id = id;
	// }

	public Employee(String name) {
		this.name = name;
	}

	public Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Employee(String name, Integer age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(String name, Integer age, Double salary, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	// public Employee(Integer id, String name, Integer age, double salary) {
	// this.id = id;
	// this.name = name;
	// this.age = age;
	// this.salary = salary;
	// }

	// public Integer getId() {
	// return id;
	// }
	//
	// public void setId(Integer id) {
	// this.id = id;
	// }

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String show() {
		return "测试方法引用！";
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		// result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		// if (id == null) {
		// if (other.id != null)
		// return false;
		// } else if (!id.equals(other.id))
		// return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	public enum Status {
		FREE, BUSY, VOCATION;
	}
}
