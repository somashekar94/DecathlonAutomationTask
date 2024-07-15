package generic;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listener extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("");
		System.out.println("Listener : " + result.getName() + " Test Case is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Listener : " + result.getName() + " Test Case is Success");
		extentTest = extentReports.createTest(result.getName());
		extentTest.pass(result.getName() + " : Test case is success..!!!");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Listener : " + result.getName() + " Test Case is Failed");
		extentReports.createTest(result.getName())
		.fail(result.getName() + " : Test case is failed..!!!")
		.info(MarkupHelper.createLabel(result.getName() + "Test case is failed..!!!", ExtentColor.RED));
	}
}
	