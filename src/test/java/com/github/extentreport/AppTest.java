package com.github.extentreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.squareup.okhttp.Response;

public class AppTest extends BaseTest
{
   
	App app = new App();
	
	@Test
	public void testGetRequest() throws IOException {
		test.log(LogStatus.INFO, "test starting");
		Response response = app.callGetRequest("https://reqres.in/api/users?page=2");
		Assert.assertEquals(response.code(), 200);
		System.out.println("Response body is:" + response.body().string());
		test.log(LogStatus.INFO, "test end");
	}
}
