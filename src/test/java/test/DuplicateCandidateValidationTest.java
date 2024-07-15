package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import generic.BaseTest;
import generic.Utilities;
import page.CandidatesPage;

public class DuplicateCandidateValidationTest extends BaseTest{
	
	@Test
	private void duplicateCandidateValidation() 
	{
		//Take the input from Excel sheet
		String enterFirstNameFromExcel = Utilities.getExcelData(EXCELDATA, "Create Candidate", 0, 1);
		String enterLastNameFromExcel = Utilities.getExcelData(EXCELDATA, "Create Candidate", 1, 1);
		String emailID = Utilities.getExcelData(EXCELDATA, "Create Candidate", 2, 1);
				
		CandidatesPage candidatesPage = new CandidatesPage(driver, wait);
		candidatesPage.errorValidationForEmailID(enterFirstNameFromExcel, enterLastNameFromExcel,emailID );
	}

}
