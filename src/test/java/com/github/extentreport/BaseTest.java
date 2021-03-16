package com.github.extentreport;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ExtendReportListener.class)
public class BaseTest extends ExtendReportListener {

	@BeforeClass
	public void baseTest() {
		
	}
	
}
