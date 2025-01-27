package test;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utilities;
import page.CandidatesPage;

public class CreateCandidateTest extends BaseTest{
	
	@Test
	private void createCandidate() throws InterruptedException 
	{
		
		//Take the input from Excel sheet
		String enterFirstNameFromExcel = Utilities.getExcelData(EXCELDATA, "Create Candidate", 0, 1);
		String enterLastNameFromExcel = Utilities.getExcelData(EXCELDATA, "Create Candidate", 1, 1);
		String emailID = Utilities.getExcelData(EXCELDATA, "Create Candidate", 2, 1);
		String enterLocation = Utilities.getExcelData(EXCELDATA, "Create Candidate", 3, 1);	
		String selectLocationFromList = Utilities.getExcelData(EXCELDATA, "Create Candidate", 4, 1);	
		
		String selectSourceFromList = Utilities.getExcelData(EXCELDATA, "Create Candidate", 5, 1);	
		String addTag = Utilities.getExcelData(EXCELDATA, "Create Candidate", 6, 1);	
		String addSkill = Utilities.getExcelData(EXCELDATA, "Create Candidate", 7, 1);	
		String enterLinkdinURL = Utilities.getExcelData(EXCELDATA, "Create Candidate", 8, 1);	

		
		CandidatesPage candidatesPage = new CandidatesPage(driver, wait);
		candidatesPage.createCandidate(enterFirstNameFromExcel , enterLastNameFromExcel ,emailID, enterLocation , selectLocationFromList );
		candidatesPage.selectSource(selectSourceFromList);
		candidatesPage.addTags(addTag);
		candidatesPage.addSkill(addSkill);
		candidatesPage.updateLinkdInProfile(enterLinkdinURL);
		candidatesPage.createCandidateBtn();
		candidatesPage.clickCloseButtonPostCreatingTheCandidate();
		
		
	}

}
