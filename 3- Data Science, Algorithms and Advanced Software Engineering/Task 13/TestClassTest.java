import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClassTest {

	private String testString = "cobra";
	@Test
	void test() {
		assertTrue(TestClass.testLength() == testLength());
		assertTrue(TestClass.testCharAt(3).equalsIgnoreCase(testCharAt(3)));
		assertTrue(TestClass.testSubstring(0,3).equalsIgnoreCase(testSubstring(0,3)));
		assertTrue(TestClass.testIndexOf("bra") == testIndexOf("bra"));
	}
	public int testLength() {
		return testString.length();
	}
	public String testCharAt(int getCharPos) {

		return String.valueOf(testString.charAt(getCharPos));
	}
	public String testSubstring(int start, int end) {
		return testString.substring(start, end);
	}
	public int testIndexOf(String indexOfTest) {

		return testString.indexOf(indexOfTest);
	}

}
