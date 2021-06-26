import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest {
	
	
	@Test
	public void test1() {
		System.out.println("this is feature change");
	}

	
	@Test
	public void test2() {
		
		System.out.println("changes on feature branch");
		
		Assert.assertEquals(false, false);
		
	}
	
}
