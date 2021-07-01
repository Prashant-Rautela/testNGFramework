import org.testng.annotations.Test;

public class HomeTest {
	
	
	@Test (groups = "QA")
	public void test1() {
		System.out.println("this is QA group");
		
		
	}
	
	@Test (groups = "stage")
	public void test2() {
		System.out.println("this is stage");
		
		
	}
	
	
}
