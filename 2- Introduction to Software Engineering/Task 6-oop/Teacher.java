
public class Teacher {	//attributes
	String nameAndSurname, employDate, subject;
	int age;
	double salary;	
	
	
	public String getNameAndSurname() {
		return this.nameAndSurname;
	}	
	public String getEmployDate() {
		return this.employDate;		
	}	
	public String getSubject() {
		return this.subject;
	}	
	public int getAge() {
		return this.age;
	}	
	public double getSalary() {
		return this.salary;
	}
	public String toString() {
		String string = "Name and Surname: " + nameAndSurname + "\n";
		string += "Age\t\t: " + age + "\n";
		string += "Employ Date\t: " + employDate + "\n";
		string += "Salary\t\t: " + salary + "\n";
		string += "Subject\t\t: " + subject + "\n";
		return string ;
	}
	public Teacher(String nameAndSurname, int age, String employDate, double salary, String subject) {
		this.nameAndSurname = nameAndSurname;
		this.age = age;
		this.employDate = employDate;
		this.salary = salary;
		this.subject = subject;
	}
	public static void main(String[] args) {
		Teacher peterTownsend = new Teacher("Peter Townsend", 25, "2015/09/01", (double) 30000.00, "Geography");
		Teacher melissaParker = new Teacher("Melissa J Parker", 61, "1998/06/01", (double) 45000.00, "Art");
		Teacher jackFrost = new Teacher("Jack Frost", 33, "2002/02/02", (double) 40000.00, "Life Sciences");
		
		System.out.println(peterTownsend.toString());
		System.out.println(melissaParker.toString());
		System.out.println(jackFrost.toString());
	}	

}
