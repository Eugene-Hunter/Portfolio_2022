import java.util.Scanner;

public class Secretary {
	//attributes
	String nameAndSurname, employDate, manager;
	int age;
	double salary;	
	
	
	public String getNameAndSurname() {
		return this.nameAndSurname;
	}	
	public String getEmployDate() {
		return this.employDate;		
	}	
	public String getManager() {
		return this.manager;
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
		string += "Manager\t\t: " + manager + "\n";
		return string ;
	}
	public Secretary(String nameAndSurname, int age, String employDate, double salary, String manager) {
		this.nameAndSurname = nameAndSurname;
		this.age = age;
		this.employDate = employDate;
		this.salary = salary;
		this.manager = manager;
	}
	public static void main(String[] args) {
		
		Secretary jennyHarding = new Secretary("Jenny Harding", 46, "2012/08/01", (double) 25000.00, "Harold Carter");
		Secretary lizaWellington = new Secretary("Liza Wellington", 25, "2019/10/01", (double) 21000.00, "Steve Hunt");
		Secretary christaHolmes = new Secretary("Christa Holmes", 29, "2021/04/01", (double) 17500.00, "Sarah Janice");
		
		
		
		System.out.println(jennyHarding.toString());
		System.out.println(lizaWellington.toString());
		System.out.println(christaHolmes.toString());
	}	

}
