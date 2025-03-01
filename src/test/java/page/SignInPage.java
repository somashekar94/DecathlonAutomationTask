package page;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.tracing.model.StreamCompression;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.Utilities;

public class SignInPage {
	
private WebDriverWait wait;
private WebDriver driver;
	
	// Declaration
	@FindBy(linkText = "Sign in")
	private WebElement clickSignIn;
	
	@FindBy(xpath = "//input[@placeholder='Enter email ID']")
	private WebElement enterEmailID;
	
	@FindBy(xpath = "//input[@placeholder='Enter password']")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement clickOnSignInBtn;
	
	@FindBy(xpath = "//p[text()='Sign in to your account']")
	private WebElement scrollThepageTillSignInText;
	
	

	
	// Initialization
	public SignInPage(WebDriver driver , WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	
	// Utilization
	public void login(String env) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(clickSignIn));
		clickSignIn.click();
		
		wait.until(ExpectedConditions.visibilityOf(scrollThepageTillSignInText));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollThepageTillSignInText);
		
		String emailID = Utilities.getProperties(env, "EmailID");
		enterEmailID.sendKeys(emailID);
		
		String password = Utilities.getProperties(env, "Password");
		enterPassword.sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSignInBtn));
		clickOnSignInBtn.click();
	}
    
} 