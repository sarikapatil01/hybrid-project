package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;
import pagePackage.TaskListPage;
import pagePackage.UsersPage;
@Listeners(CustomeListner.class)
public class ValidLoginTestCase extends BaseTest {

	@Test
	public void validTestCase() throws IOException, InterruptedException
	{
		BaseTest bt = new BaseTest();
		bt.setUp();
		Flib flib = new Flib();
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(flib.readPropertyData(PROP_PATH,"username"),flib.readPropertyData(PROP_PATH,"password"));
        Thread.sleep(2000);
        HomePage hp = new HomePage(driver);
        hp.usersModuleMethod();
        Thread.sleep(2000);
        UsersPage ulp = new UsersPage(driver);
        ulp.createUserMethod(flib.readExcelData(EXCEL_PATH,"CreateUsers",1,0), flib.readExcelData(EXCEL_PATH,"CreateUsers",1,1),flib.readExcelData(EXCEL_PATH,"CreateUsers",1,2),flib.readExcelData(EXCEL_PATH,"CreateUsers",1,3));
		ulp.selectCheckBox();
		ulp.managerCreateMethod();
		Thread.sleep(2000);
		hp.taskModuleMethod();
		TaskListPage task = new TaskListPage(driver);
		task.createNewCustomerMethod(flib.readExcelData(EXCEL_PATH,"CustomerList",1,0));
		Thread.sleep(2000);
		task.createProjectMethod(0,flib.readExcelData(EXCEL_PATH,"CustomerList",1,1));

	}

}