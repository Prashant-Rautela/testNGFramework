import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.BasePage.baseClass;
import com.qa.Pages.SignInPage;


public class SignInTest extends baseClass {

	SignInPage signInPage;
	
	public SignInTest() {

		super();
		signInPage = new SignInPage();
		

	}

	@BeforeMethod
	public void initialiseBrowser() {
		launchBrowser();

	}

	@Test
	public void verifyTitleOfSignUpPage() {
	
		String expectedPageTitle = "ToolsQA";
		String actualPageTitle = signInPage.getPageTitle();
		boolean flag = false;
		if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
			flag = true;
		}
		Assert.assertEquals(flag, true);
		

	}

	@AfterMethod
	public void tearDown(){

		driver.close();
	}
}
