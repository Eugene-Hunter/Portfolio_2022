
public class Course {

	private String courseName ;
	private int numberOfStudents ;
	private String courseLecturer ;
	
	public Course(String cName, String cLecturer, int numStudents ){
		courseName = cName;
		courseLecturer = cLecturer;
		numberOfStudents = numStudents;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param cName the courseName to set
	 */
	public void setCourseName(String cName) {
		courseName = cName;
	}
	/**
	 * @return the numberOfStudents
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	/**
	 * @param numStudents the numberOfStudents to set
	 */
	public void setNumberOfStudents(int numStudents) {
		numberOfStudents = numStudents;
	}
	/**
	 * @return the courseLecturer
	 */
	public String getCourseLecturer() {
		return courseLecturer;
	}
	/**
	 * @param cLecturer the courseLecturer to set
	 */
	public void setCourseLecturer(String cLecturer) {
		courseLecturer = cLecturer;
	}
	/**
	 * @return 
	 * @Override
	 * */
	public String toString() {

		return (courseName + ", " + courseLecturer + ", " + numberOfStudents);
	}

}
