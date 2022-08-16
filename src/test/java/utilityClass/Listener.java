package utilityClass;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClass.BaseNew;

public class Listener implements ITestListener
{

	
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("TC is Executing "+result.getName(), true);
	}
	

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("TC is Skipped "+result.getName(), true);
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("TC is Successful "+result.getName(), true);
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		
		try {
			BaseNew.captureScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
