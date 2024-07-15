package test;

import java.io.IOException;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.CandidatesPage;

public class UploadResumeTest extends BaseTest{

	@Test()
	public void uploadResume() throws InterruptedException, IOException
	{
		CandidatesPage candidatesPage = new CandidatesPage(driver, wait);
		candidatesPage.uploadResume();
	}

}
