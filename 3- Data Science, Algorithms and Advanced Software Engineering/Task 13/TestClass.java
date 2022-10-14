

/**
 * @author Eugene Hunter
 *
 * Write a test class to test the following methods in the java.lang.String
class:
- length
- charAt
- substring
- indexOf

 */
public class TestClass {

	private static String testString = "cobra";
	
	public TestClass(String testString) {
		this.setTestString(testString);
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testStr) {
		testString = testStr;
	}
	public static int testLength() {
		return testString.length();
	}
	public static String testCharAt(int getCharPos) {

		return String.valueOf(testString.charAt(getCharPos));
	}
	public static String testSubstring(int start, int end) {
		return testString.substring(start, end);
	}
	public static int testIndexOf(String indexOfTest) {

		return testString.indexOf(indexOfTest);
	}
	

}
