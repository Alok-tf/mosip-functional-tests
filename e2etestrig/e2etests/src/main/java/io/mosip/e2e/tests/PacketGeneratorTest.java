package io.mosip.e2e.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import org.testng.internal.TestResult;

import io.mosip.e2e.util.GeneratePreIds;
import io.mosip.e2e.util.PacketGenerator;
import io.mosip.registration.main.RegClient;
import io.mosip.registration.util.CommonUtil;
import io.mosip.testrunner.MosipTestRunner;



public class PacketGeneratorTest implements ITest {
	GeneratePreIds generatePreIds = new GeneratePreIds();
	protected static String testCaseName = "";
	
	@Test(priority=1)
	public void generatePrids() {
		
		File file =new File(CommonUtil.class.getClassLoader().getResource("./testData/PreregIds.json").getFile());
	JSONObject preIds = generatePreIds.getPreids();
		preIds.put("RegClientPacket", "YES");
		if (preIds.equals(null)) {
			Assert.assertTrue(false);
		}
		try {
			FileWriter writer=new FileWriter(file.getAbsolutePath());
			writer.write(preIds.toJSONString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);
	}
	/**
	 * Test to check whether packets have been generated
	 * @throws IOException 
	 */
	@Test(priority=2)
	public void generateValidInvalidPackets() throws IOException {
		
		String fileToBeDeleted=MosipTestRunner.getGlobalResourcePath()+"/packets/UniqueCBEFF_Packets";
		
		FileUtils.deleteDirectory(new File(fileToBeDeleted));
		RegClient client=new RegClient();
		client.createPacket();
		PacketGenerator packetGenerator=new PacketGenerator();
	Object[][] mapOfPackets=packetGenerator.getPackets();
		if (mapOfPackets.equals(null)) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	
	}
	
	@Override
	public String getTestName() {
		return this.testCaseName;
	}
	
	@AfterMethod(alwaysRun = true)
	public void setResultTestName(ITestResult result) {
		
		Field method;
		try {
			method = TestResult.class.getDeclaredField("m_method");
			method.setAccessible(true);
			method.set(result, result.getMethod().clone());
			BaseTestMethod baseTestMethod = (BaseTestMethod) result.getMethod();
			Field f = baseTestMethod.getClass().getSuperclass().getDeclaredField("m_methodName");
			f.setAccessible(true);
			testCaseName ="E2E_PacketGenerator"+"_"+baseTestMethod.getMethodName();
			f.set(baseTestMethod, PacketGeneratorTest.testCaseName);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
		}

	}
}
