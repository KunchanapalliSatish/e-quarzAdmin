package com.Utils;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.Pageobjects.Homepage;
import com.base.Testbase;


public class Utils extends Testbase {
	private static final String filepath= "./src/main/java/com/testdata/equarzdata.xlsx ";

	@DataProvider

	public static String[][] setdata(String sheetname) throws Throwable {

		File file = new File(filepath);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(sheetname);

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows - 1][columns];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		return data;
	}
	public static void robo() throws Throwable
	{
		Robot robo=new Robot();
		robo.delay(3000);

		StringSelection upload=new StringSelection("C:\\Users\\sree\\Downloads\\pic");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void dropdown(WebElement value, String text) {
		Select sel = new Select(value);
		sel.selectByValue(text);

	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
}
	public Homepage Windowhandless(String window)
	{
		Set<String> handles = driver.getWindowHandles();
		for (String hand : handles) {
			if (!window.equals(hand)) {
				driver.switchTo().window(hand);
				driver.manage().window().maximize();
				
				
			}
		}
		return new Homepage();
	}

}


