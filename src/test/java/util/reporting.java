
	
	package util;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public abstract class reporting {

		public static ExtentReports report;

		public ExtentTest test;

		public String testCaseName, testCaseDescription;

		public String author, category;
		

		public void StartReport() {
			report = new ExtentReports("./reports/Result.html", false);// path of folder where report are saved.
		}

		public void startTest(String testName, String Description) {
			test = report.startTest(testName, Description);
			test.assignAuthor(author);
			test.assignCategory(category);
		}

		public abstract long takeSnap();

		public void reportStep(String details, String status) {
			long snapNumber = takeSnap();

			if (status.equalsIgnoreCase("Pass")) {
				test.log(LogStatus.PASS,
						details + test.addScreenCapture(".././reports/screenshots/" + snapNumber + ".jpg"));
			} else if (status.equalsIgnoreCase("Fail")) {
				test.log(LogStatus.FAIL,
						details + test.addScreenCapture(".././reports/screenshots/" + snapNumber + ".jpg"));
			}
		}

		public void reportStep(String details, String status, boolean snap) {
			if (!snap) {
				long snapNumber = takeSnap();

				if (status.equalsIgnoreCase("pass")) {
					test.log(LogStatus.PASS,
							details + test.addScreenCapture(".././reports/screenshots/" + snapNumber + ".jpg"));
				} else if (status.equalsIgnoreCase("fail")) {
					test.log(LogStatus.FAIL,
							details + test.addScreenCapture(".././reports/screenshots/" + snapNumber + ".jpg"));
				}
			}
		}
		
		public void endTest()
		{
			report.endTest(test);
		}
		
		public void endReport()
		{
			report.flush();
		}

	}



