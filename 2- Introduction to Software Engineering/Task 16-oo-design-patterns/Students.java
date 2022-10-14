
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// enumerate the different bootcamp objects
enum Camps{
	SE,
	WD
}
// Enumerate the different level accomplishment objects 
enum Levels{
	L1,
	L2,
	L3
}

// Students class with list of students
class Students{
	
	private static Student student; // instantiating student object
	private static List<Student> students;

	// Students main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Instantiating bootcamps and level accomplishment objects
		Camps[] bCs1 = {Camps.SE, Camps.WD}; 
		Levels[] bCLs1 = {Levels.L1,Levels.L3};
		students = new ArrayList<Student>();
		
		student = Student.getInstance(1, "Harry Potter", bCs1, bCLs1); // Instantiating a new student object
		students.add(student);
		// Instantiating bootcamps and level accomplishment objects
		Camps[] bCs2 = {Camps.WD};
		Levels[] bCLs2 = {Levels.L2};
		
		student = Student.getInstance(2, "Pete Skeet", bCs2, bCLs2); // Instantiating a new student object
		students.add(student);
		// Instantiating bootcamps and level accomplishment objects
		Camps[] bCs3 = {Camps.SE};
		Levels[] bCLs3 = {Levels.L1};
		
		student = Student.getInstance(3, "Charl Dickson", bCs3, bCLs3); // Instantiating a new student object
		students.add(student);
		int more = 0;
		//student2.describe();	
		do {
		student = Student.addStudent(); // Instantiating a new student
		students.add(student);

		System.out.print("Add another sudent?: 1: Yes or 2: No: ");
		more = Integer.parseInt(input.nextLine()); // variable to store the user input
		}while(more == 1); // do while loop to allow user to add more than 1 student record
		
		for(Student student: students) {
			student.describe();;
		}
}
}
class Student{
	
	// Initialize the object attributes
	private static  Student studentWriter;
	private static BootCamp bCamp;

	private static int studentNumber;
	private static String studentName;

	private static Camps[] bCamps;
	private static Levels[] bLevels;

	private static Camps camp;
	private static Levels level;
	
	// Describe method
	public void describe() {


		System.out.print("Student number: " );
		System.out.print(studentNumber + " : " );	
		System.out.println(studentName);

		for(int x = 0; x < bCamps.length; x++) {
			bCamp.print(bCamps[x], bLevels[x]);
		}

	}

	// Student getInstance method 		
	public static Student getInstance(int studNumber, String studName, Camps[] camps, Levels[] campLevels) {

		// instantiating new student object
		studentWriter = new Student(studNumber, studName, camps, campLevels);
		
		return studentWriter;
	}
	
	// Add student method
	public static Student addStudent() {
		
		Scanner input = new Scanner(System.in); // Instantiating scanner object to allow user input
		
		System.out.println("Add new Student: \r\n");
		System.out.print("\tStudent Number:");
		int studNr = Integer.parseInt(input.nextLine()); // variable to store the user input
		System.out.print("\tStudent Name:");
		String studName = input.nextLine(); // variable to store the user input

		List<Camps> bCs = new ArrayList<Camps>(); // ArrayList variable to store the user input
		List<Levels> bLs = new ArrayList<Levels>(); // ArrayList variable to store the user input
		int campCount = 0;  
		int more = 1;
		do { // do/while loop to display the boot camps the user is part of
		System.out.print("BootCamp Attended::\r\n\t1: Software Engineering\r\n" 
						   + "\t2: Web Development: ");
		String bootC = String.valueOf(input.nextInt());
		
		switch(bootC) { //switch statement to switch between the bootCamp options
		case "1": 
			 camp = Camps.SE; 
			 
			break;

		case "2":

			 camp = Camps.WD;
			break;
		default:
			System.out.println("Input not recognised.");
			break;
		}
		System.out.println("Level Completed:\r\n\t1: Level 1" 
				+ "\r\n\t2: Level 2"
				+ "\r\n\t3: Level 3");
		String bootL = String.valueOf(input.nextInt());
		
		switch(bootL) { //switch statement to switch between the bootCamp options
		case "1":
			 level = Levels.L1; 
			break;

		case "2":
			 level = Levels.L2; 
			break;
		case "3":
			 level = Levels.L3; 

			break;
		default:
			System.out.println("Input not recognised.");
			break;
		}
		
		bCs.add(camp);
		bLs.add(level);
		System.out.print("Add another bootcamp? 1- Yes, 2- No");
		more = input.nextInt(); // variable to store the user coice to add more bootcamps
		campCount++;
		}while (more == 1); // do/while loop condition 
		
		Camps[] campList = new Camps[bCs.size()]; // instantiating the list object
		Levels[] levelList = new Levels[bCs.size()]; // instantiating the level  object
		
		for(int x = 0; x < campList.length; x++) { // For loop to cycle throught thelist op camps and assign it to an arrayList
		campList[x] = bCs.get(x);
		levelList[x] = bLs.get(x);
		}
		Student newStudent = Student.getInstance(studNr, studName, campList, levelList); // Instantiating a Student object

		return newStudent; // return the object
	}
	// Student constructor methos
	private Student(int studNumber, String studName, Camps[] camps, Levels[] campLevels) {
		//bootCamps = new ArrayList<BootCamp>();
		
		// Assign values to the new Student object attributes
		studentNumber = studNumber;
		studentName = studName;
		bCamps = camps;
		bLevels = campLevels;
		bCamp = BootCamp.getInstance(camps, campLevels); // Instantiating a BootCamp object
		
		
		describe(); // display the result
	}

}
// Bootcamp class
class BootCamp{

	// instantiating the object attributes
	private static BootCamp campWriter;
	private Camps camp;
	private Levels level;
	
	// Bootcamp getInstance method
	public static BootCamp getInstance(Camps[] camp,Levels[] levels) {
		
		//if(campWriter == null) { // if state
			campWriter = new BootCamp(camp, levels);
		//}
		return campWriter; // Return BootCamp object
	}
	
	// BootCamp constructor method
	private BootCamp(Camps[] bootC, Levels[] bootCLevel) {
		
		// for loop to cycle through the bootcamp options and assign values to the camp and level attributes
		for(int x = 0; x < bootC.length; x++) {
		camp = bootC[x];
		level = bootCLevel[x];
		}
		}
	// BootCamp print method
	public void print(Camps camp, Levels level) {

		switch (camp) { // switch statement to display the information for the current student
		case SE:
			
			System.out.println("Registered for the Software Engineering Bootcamp");

			break;
		case WD:

			System.out.println("Registered for the Web Developer Bootcamp");
			break;
		default:

			System.out.println("Input not recognised");
			break;
		}
		switch(level) { // switch statement to display the information for the current student
		case L1:

			System.out.println("Completed Level 1");
			break;
			
		case L2:
			
			System.out.println("Completed Level 1");
			System.out.println("Completed Level 2");
			break;
			
		case L3:

			System.out.println("Completed Level 1");
			System.out.println("Completed Level 2");
			System.out.println("Completed Level 3");
			break;

		default:

			System.out.println("Input not recognised");
		}

		System.out.println();
		}	


	
}

