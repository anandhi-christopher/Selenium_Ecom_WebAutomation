package tutorialNinja.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

int i=0;
int count=1;
	public boolean retry(ITestResult result) {
		if(i<count) {
			i++;
			return true;
		}
		return false;
	}

}
