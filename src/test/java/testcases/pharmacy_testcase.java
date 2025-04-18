package testcases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.StartupPage;
import pages.pharmacy_Pages;
import testBase.AppTestBase;
import testBase.UserActions;
import testdata.LocatorsFactory;

public class pharmacy_testcase extends AppTestBase {
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.xlsx";
	String loginFilePath = loginDataFilePath + "Login.xlsx";
	StartupPage startupPage;
	String randomInvoiceNumber;
	pharmacy_Pages pharmacy_pl1_pageInstance;
	LocatorsFactory locatorsFactoryInstance;
	UserActions userActionsInstance;

	@Parameters({ "browser", "environment" })
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readExcelPOI(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);

		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl,
				configData.get("url") + " might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, description = "Verify the title and url of  the current page.")
	public void verifyTitleAndURLOfTheHomePage() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readExcelPOI(loginFilePath, "credentials");
		Assert.assertTrue(pharmacy_pl1_pageInstance.loginToHealthAppByGivenValidCredetial(loginData),
				"Login failed, Invalid credentials ! Please check manually");
		pharmacy_pl1_pageInstance.clickOnHomePageLogo();
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "healthApp");
		Assert.assertEquals(pharmacy_pl1_pageInstance.verifyTitleOfThePage(), expectedData.get("dasboardTitle"));
		Assert.assertEquals(pharmacy_pl1_pageInstance.verifyURLOfThePage(), expectedData.get("pageUrl"));
		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(),
				"total doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section\n"
					+ "1. Login in the healthapp application\n" + "2. Scroll down menu till pharmacy\n"
					+ "3. Click on the pharmacy")
	public void getPharmacyPageUrl() throws Exception {

		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "Pharmacy");
		pharmacy_pl1_pageInstance.scrollDownAndClickPharmacyTab();
		Assert.assertEquals(pharmacy_pl1_pageInstance.getPharmacyPageUrl(), expectedData.get("URL"));
	}

	@Test(priority = 3, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section\n"
					+ "1. Click on the Pharmacy Module drop-down arrow\n" + "2. Click on Order")
	public void verifyAndHighlightPharmacySubModulesTab() throws Exception {

		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightPharmacySubModulesTab("Order"), "Order tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightPharmacySubModulesTab("Supplier"), "Supplier tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightPharmacySubModulesTab("Report"), "Report tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightPharmacySubModulesTab("Setting"), "Setting tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightPharmacySubModulesTab("Store"), "Store tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightPharmacySubModulesTab("SupplierLedger"),
				"SupplierLedger tab is not visible");
	}

	@Test(priority = 4, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section\n"
					+ "1. Click on the Pharmacy Module drop-down arrow\n" + "2. Click on order\n"
					+ "Verify the presence of the order section with all fields")
	public void verifyElementsUnderOrderTab() throws Exception {

		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		pharmacy_pl1_pageInstance.visitTabUnderPharmacy("Order");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isOrderTabSelected(), "Order tab is not selected");

		Assert.assertTrue(pharmacy_pl1_pageInstance.areSubTabsUnderOrderPresent(),
				"All the sub tabs under order are not present");
		
		Assert.assertTrue(pharmacy_pl1_pageInstance.isSearchBarPresent(), "Search Bar is not present");

		Assert.assertTrue(pharmacy_pl1_pageInstance.areDateDropdownsPresent(), "Date dropdowns are not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isSelectSupplierDropdownPresent(),
				"Select supplier dropdown is not present");

	}

	@Test(priority = 5, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section\n"
					+ "1. Click on the Order\n" + "2. Click on the Supplier")
	public void verifyNavigationToAnotherSubModuleAfterOpeningTheOrderSection() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		pharmacy_pl1_pageInstance.visitTabUnderPharmacy("Supplier");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifySelectedTabIsActiveOrNot().contains("active"));
	}

	@Test(priority = 6, groups = {
			"sanity" }, description = "Verify that the user is logged in and is on the Pharmacy section.\r\n"
					+ "If the user is on the Pharmacy section, \r\n"
					+ "then click on the \"New Good Receipt\" button and \r\n"
					+ "scroll to the bottom of the screen and \r\n" + "click on the \"Print Receipt\" button.")
	public void verifyErrorMessageOnPrintingGoodReceiptWithoutDetails() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);

		pharmacy_pl1_pageInstance.visitTabUnderPharmacy("Order");
		pharmacy_pl1_pageInstance.clickButtonByText("Add New Good Receipt");
		pharmacy_pl1_pageInstance.clickPrintReceipt();
		userActionsInstance.acceptAlert();
		userActionsInstance.acceptAlert();
		pharmacy_pl1_pageInstance.verifyMessageByText("Please, Insert Valid Data");
		Assert.assertTrue(pharmacy_pl1_pageInstance.closeAddGoodReceiptModal());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}

	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}
