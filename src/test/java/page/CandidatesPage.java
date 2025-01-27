package page;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class CandidatesPage {
	
private WebDriverWait wait;
private WebDriver driver;
	
	// Declaration
	@FindBy(xpath = "//div[@class='candidates-header']//button[text()='+ Candidate']")
	private WebElement clickOnCandidateBtn;
	
	@FindBy(xpath = "//button[text()='Upload resume']/../input[@type='file']")
	private WebElement clickOnUploadResumeBtn;
	
	@FindBy(xpath = "//p[text()='Parsing resume...']")
	private WebElement Parsingresume;
	
	@FindBy(xpath = "//button[text()='Create candidate']")
	private WebElement clickOnCreateCandidate;
	
	@FindBy(xpath = "//div[@class='action-button-container enable-close-button']/div[@class='close-button']")
	private WebElement clickCloseBtn;
	
	@FindBy(xpath = "//input[@placeholder='e.g. John']")
	private WebElement enterFirstName;
	
	@FindBy(xpath = "//input[@placeholder='e.g. smith']")
	private WebElement enterLastName;
	
	@FindBy(xpath = "//input[@placeholder='e.g. johnsmith@gmail.com']")
	private WebElement enterEmilID;
	
	@FindBy(xpath = "//input[@placeholder='e.g. +1 408 600 1338']")
	private WebElement enterPhoneNumber;
	
	@FindBy(xpath = "//input[@placeholder='Search location...']")
	private WebElement clickOnSearchLocationBtn;
	
	@FindBy(xpath = "//div[@class='pac-item']")
	private List<WebElement> getTheListOfLocations;
	
	@FindBy(xpath = "//input[@placeholder='Enter company name']")
	private WebElement enterCompanyName;
	
	@FindBy(xpath = "//div[text()='Search source...']/following-sibling::div/input[@id='react-select-4-input']")
	private WebElement clickOnADDSOURCEBtn;
	
	@FindBy(xpath = "//div[text()='LinkedIn']")
	private WebElement selectLinkedInOptionFromList;
	
	@FindBy(xpath = "//div[text()='Search tags...']/following-sibling::div/input[@id='react-select-5-input']")
	private WebElement clickOnADDTAGSBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Create ')]")
	private WebElement selectCreatedTagFromtheList;
	
	@FindBy(xpath = "//div[@id='react-select-5-listbox']/div[@id='react-select-5-option-0']")
	private WebElement selectTagWhichAlreadyPresentInTheList;
	
	@FindBy(xpath = "//input[@placeholder='Linkedin link']")
	private WebElement updateLinkdinProfile;
	
	@FindBy(xpath = "//button[text()='Create candidate']")
	private WebElement clickOnCreateCandidateBtn;
	
	@FindBy(xpath = "//p[text()='A profile with this Email already exists']")
	private WebElement getAlreadyExistsUserinfo;
	
	@FindBy(xpath = "//p[text()='Saving...']")
	private WebElement savingCreatingTheUser;
	
	@FindBy(xpath = "//a[@class='title-text text-link']")
	private WebElement nameOfTheCreatedCandidate;
	
	@FindBy(xpath = "//div[text()='Search skills...']/following-sibling::div/input[@id='react-select-6-input']")
	private WebElement clickOnADDSKILLSBtn;
	
	@FindBy(xpath = "//div[@id='react-select-6-option-0' and text()='Automation']")
	private WebElement selectAutomationSkill;
	
	@FindBy(xpath = "//div[@id='react-select-6-option-0' and text()='mobile automation']")
	private WebElement selectMobileAutomationSkill;
	
	
	// Initialization
	public CandidatesPage(WebDriver driver , WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	
	// Utilization
	public void uploadResume() throws InterruptedException, IOException
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnCandidateBtn));
		clickOnCandidateBtn.click();
		
		File file = new File("./ResumeFile/SamplePDF.pdf");
		String pathOftheFile = file.getAbsolutePath();
		clickOnUploadResumeBtn.sendKeys(pathOftheFile);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("Parsingresume")));
		clickOnCreateCandidate.click();

		clickCloseButtonPostCreatingTheCandidate();
		
		// validating the created candidate
		wait.until(ExpectedConditions.visibilityOf(nameOfTheCreatedCandidate));
		System.out.println("Name of the candidate : " + nameOfTheCreatedCandidate.getText() );
		
		if (nameOfTheCreatedCandidate.getText().contains("Matthew Eliot")) 
		{
			System.out.println("Candidate is successfully created...!!! ");
		}
		else
		{
			System.out.println("Candidate creation got failed...!!! ");
		}
	}
	
	public void createCandidate(String enterFirstNameFromExcel, String enterLastNameFromExcel, String emailID, String enterLocation, String selectLocationFromList) throws InterruptedException 
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnCandidateBtn));
		clickOnCandidateBtn.click();
		
		enterFirstName.sendKeys(enterFirstNameFromExcel);
		enterLastName.sendKeys(enterLastNameFromExcel);
		enterEmilID.sendKeys(emailID);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", clickOnSearchLocationBtn);
		
		clickOnSearchLocationBtn.sendKeys(enterLocation);
		List<WebElement> listoptions = getTheListOfLocations;
		
		int getSize = getTheListOfLocations.size();
		System.out.println("Size of the SearchList : " + getSize);
		
		for(int i = 0; i<listoptions.size(); i++)
		{
            String getText = listoptions.get(i).getText();
            System.out.println("Search Results : " + getText);
            
            if (listoptions.get(i).getText().contains(selectLocationFromList)) 
            {
            	listoptions.get(i).click();
            	break;
            }
		} 
	}
	
	public void addTags(String addTag) throws InterruptedException 
	{
		clickOnADDTAGSBtn.sendKeys(addTag);
		
		if(selectTagWhichAlreadyPresentInTheList.getText().contains("Create"))
		{
			// Create the Tag
			wait.until(ExpectedConditions.elementToBeClickable(selectTagWhichAlreadyPresentInTheList));
			System.out.println("TAG Created : " + selectTagWhichAlreadyPresentInTheList.getText());
			selectCreatedTagFromtheList.click();
		}
		else
		{
			// Select the Existing Tag from the List
			wait.until(ExpectedConditions.elementToBeClickable(selectTagWhichAlreadyPresentInTheList));
			System.out.println("Tag already present in the List : " + selectTagWhichAlreadyPresentInTheList.getText());
			selectTagWhichAlreadyPresentInTheList.click();
		}
	}
	
	public void selectSource(String selectSourceFromList) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", clickOnADDSOURCEBtn);
		wait.until(ExpectedConditions.visibilityOf(clickOnADDSOURCEBtn));
		clickOnADDSOURCEBtn.sendKeys(selectSourceFromList);
		wait.until(ExpectedConditions.elementToBeClickable(selectLinkedInOptionFromList));
		selectLinkedInOptionFromList.click();
	}
	
	
	public void addSkill(String addSkill) 
	{
		clickOnADDSKILLSBtn.sendKeys(addSkill);
		wait.until(ExpectedConditions.elementToBeClickable(selectAutomationSkill));
		System.out.println("Selected Skill from the List : " + selectAutomationSkill.getText());
		selectAutomationSkill.click();
	}
	
	public void updateLinkdInProfile(String enterLinkdinURL) 
	{
		updateLinkdinProfile.sendKeys(enterLinkdinURL);
	}
	
	public void createCandidateBtn() 
	{
		clickOnCreateCandidateBtn.click();
	}
	
	public void clickCloseButtonPostCreatingTheCandidate() 
	{
		wait.until(ExpectedConditions.visibilityOf(clickCloseBtn));
		clickCloseBtn.click();
	}
	
	public void errorValidationForEmailID(String enterFirstNameFromExcel, String enterLastNameFromExcel, String emailID) 
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnCandidateBtn));
		clickOnCandidateBtn.click();
		
		enterFirstName.sendKeys(enterFirstNameFromExcel);
		enterLastName.sendKeys(enterLastNameFromExcel);
		enterEmilID.sendKeys(emailID);
		
		clickOnCreateCandidateBtn.click();
		wait.until(ExpectedConditions.visibilityOf(savingCreatingTheUser));
		System.out.println("Error Validation Message : " + getAlreadyExistsUserinfo.getText());
	}
}

