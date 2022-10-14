import java.util.*;
/**
 * @author Eugene Hunter
 * The program takes a list of courses together with the lecturer and the number of students enrolled,
 * and performs several functions on the information.
 *
 */
public class AddCourse {



	public static void main(String[] args) {


		// Create a new ArrayList called courses1, add 5 courses to it and print it out.
		List<Course> courses1 = new ArrayList<>();
		courses1.add(new Course("Intermediate Java UX", "Prof. G Polly", 15));
		courses1.add(new Course("Avanced Database Development", "Lect. S McMahon", 43));
		courses1.add(new Course("Beginner Software Engineering", "Prof. E Hunter", 76));
		courses1.add(new Course("Intermediate Web Development", "Lect. Z Cooper", 58));
		courses1.add(new Course("Beginner C++", "Lect. H Barry", 30));
		Iterator<Course> itr = courses1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}		 
		System.out.println();	 

		//Sort the List according to the numberOfStudents and print it out.
		System.out.println("Sort by number of students:");	 
		Collections.sort(courses1, Comparator.comparing(Course::getNumberOfStudents));

		itr = courses1.iterator();
		while(itr.hasNext()) {		 
			System.out.println(itr.next());
		}
		
		//Sort the List according to the numberOfStudents and print it out.
		System.out.println();	 
		System.out.println("Swapping the first and second courses:");
		Collections.swap(courses1, 0, 1);
		itr = courses1.iterator();
		while(itr.hasNext()) {		 
			System.out.println(itr.next());
		}
		
		//Create a new ArrayList called courses2	 
		List<Course> courses2 = new ArrayList<>();

		//Using the addAll method add 5 courses to the courses2 List and print it out
		// Copy all of the courses from courses1 into courses2
		System.out.println();	 
		System.out.println("Adding all the courses from list 1 to list 2: ");
		courses2.addAll(courses1);
		itr = courses2.iterator();
		while(itr.hasNext()) {		 
			System.out.println(itr.next());
		}

		// Add the following two elements to courses2:
		// (Java 101, Dr. P Green, 55)
		// (Advanced Programming, Prof. M Milton, 93)

		System.out.println();	 
		System.out.println("Adding 2 new courses to list 2: ");
		courses2.add(new Course("Java 101", "Dr. P Green", 55)); 
		courses2.add(new Course("Advanced Programming", "Prof. M Milton", 43)); 
		itr = courses2.iterator();
		while(itr.hasNext()) {		 
			System.out.println(itr.next());
		}

		// Sort the courses in courses2 alphabetically according to the course name and print it out.
		System.out.println();	 
		System.out.println("Sort by course name:");	 
		Collections.sort(courses2, Comparator.comparing(Course::getCourseName));
		itr = courses2.iterator();
		while(itr.hasNext()) {		 
			System.out.println(itr.next());
		} 

		//Search for the course “Java 101” in courses2 and print out the index of the
		// course in the List.

		System.out.println();	 
		Comparator<Course> c = new Comparator<>() {
			public int compare(Course c1, Course c2) {
				return c1.getCourseName().compareTo(c2.getCourseName());
			}
		};
		System.out.print("Index position of the course \"Java 101\": ");
		int indx = Collections.binarySearch(courses2, new Course("Java 101", "", 0), c );
		System.out.println(indx + 1);	 

		// Use the disjoint function to determine whether courses1 and courses2
		// have any elements in common and print out the result.
		System.out.println();	 
		System.out.println("Compare the courses list 1 to courses list 2 determine if the lists have elements in common");
		boolean trueFalse = Collections.disjoint(courses1, courses2);
		if(trueFalse) {
			System.out.println("The lists do not have any elements in common");
		} 
		else{
			System.out.println("The lists have elements in common");
		}

		// In courses2, find the course with the most students and the course with
		//the least students and print each out
		System.out.println();	 
		System.out.print("Course with the most students: ");
		System.out.println(Collections.max(courses2, Comparator.comparing(Course::getNumberOfStudents)));
		System.out.println();	 
		System.out.print("Course with the least students: ");
		System.out.println(Collections.min(courses2, Comparator.comparing(Course::getNumberOfStudents)));


	}

}
