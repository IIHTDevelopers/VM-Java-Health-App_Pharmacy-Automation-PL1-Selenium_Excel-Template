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
	public void verifyTitleOfTheHomePage() throws Exception {
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
	public void verifyPharmacyModule() throws Exception {

		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "Pharmacy");
		pharmacy_pl1_pageInstance.scrollDownAndClickPharmacyTab();
		Assert.assertEquals(pharmacy_pl1_pageInstance.getPharmacyPageUrl(), expectedData.get("URL"));
	}

	@Test(priority = 3, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section\n"
					+ "1. Click on the Pharmacy Module drop-down arrow\n" + "2. Click on Order")
	public void verifyPharmacySubModules() throws Exception {

		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightTab("Order"), "Order tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightTab("Supplier"), "Supplier tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightTab("Report"), "Report tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightTab("Setting"), "Setting tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightTab("Store"), "Store tab is not visible");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyAndHighlightTab("SupplierLedger"),
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
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Add New Good Receipt"),
				"The Add New Good Receipt button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Show Details"),
				"The Show Details button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("OK"), "The OK button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Export"), "The Export button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Print"), "The Print button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("First"), "The First button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Previous"), "The Previous button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Next"), "The Next button is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isButtonPresent("Last"), "The Last button is not present");

		Assert.assertTrue(pharmacy_pl1_pageInstance.areAgingDaysFieldsPresent(), "Aging Days field is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isSearchBarPresent(), "Search Bar is not present");

		Assert.assertTrue(pharmacy_pl1_pageInstance.areDateDropdownsPresent(), "Date dropdowns are not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isSelectSupplierDropdownPresent(),
				"Select supplier dropdown is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.isFilterDropdownPresent(), "Filter dropdown is not present");
		Assert.assertTrue(pharmacy_pl1_pageInstance.areFilterByStatusRadioButtonsPresent(),
				"Filter by status radio buttons are not present");

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

	@Test(priority = 7, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section\n"
					+ "1. Click on the new Good Receipt button\n"
					+ "User should be able to click on the new Good Receipt button\n"
					+ "User should be able to add a new receipt after filling all mandatory fields")
	public void addNewGoodReceipt() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);

		Map<String, String> newGriItemData = new FileOperations().readExcelPOI(expectedDataFilePath, "Pharmacy");
		String itemName = newGriItemData.get("itemname"), batchNumber = newGriItemData.get("batchnumber"),
				quantity = newGriItemData.get("quantity"), rate = newGriItemData.get("rate");
		int randomSixDigit = userActionsInstance.randomNumber(100000, 900000);
		randomInvoiceNumber = String.valueOf(randomSixDigit);
		System.out.println("Random Invoce Number : " + randomSixDigit);
		pharmacy_pl1_pageInstance.visitTabUnderPharmacy("Order");
		pharmacy_pl1_pageInstance.clickButtonByText("Add New Good Receipt");
		pharmacy_pl1_pageInstance.clickButtonByText("Add New Item");
		pharmacy_pl1_pageInstance.addGriItemWithMandatoryFieldsOnly(itemName, batchNumber, quantity, rate, null);
		pharmacy_pl1_pageInstance.enterMandatoryDetailsToPrintGoodReceipt(randomInvoiceNumber);
		Assert.assertEquals(pharmacy_pl1_pageInstance.verifyMessageByText("Goods Receipt is Generated and Saved."),
				"Goods Receipt is Generated and Saved.");
	}

	@Test(priority = 8, groups = { "sanity" }, description = "Verify that the user can view the added receipt.\r\n"
			+ "If the receipt is added, \r\n" + "then click on the \"View\" button.")
	public void verifyAddedGoodReceipt() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);

		userActionsInstance.click(pharmacy_pl1_pageInstance.closeModalButtonXpath2);
		pharmacy_pl1_pageInstance.closeModalBySubjectName("Add Good Receipt");
		Assert.assertTrue(pharmacy_pl1_pageInstance.clickAndEnterValueInSearchField(randomInvoiceNumber),
				"Search Bar is not Displayed");
		pharmacy_pl1_pageInstance.highlightAndClickOnButton(pharmacy_pl1_pageInstance.showDetails,
				"Show Details Button");
		pharmacy_pl1_pageInstance.clickViewButtonWithInvoice(randomInvoiceNumber);
		Assert.assertTrue(pharmacy_pl1_pageInstance.doesPrintContainsInvoiceNumber(randomInvoiceNumber));
		Assert.assertTrue(pharmacy_pl1_pageInstance.closeAddGoodReceiptModal());
	}

	@Test(priority = 9, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Pharmacy section\r\n"
					+ "1. Click on the \"From\" date\r\n" + "2. Select the \"From\" date\r\n"
					+ "3. Click on the \"To\" date\r\n" + "4. Select \"To\" date\r\n" + "5. Click on \"OK\" button")
	public void verifyDataIsAsPerAppliedDateFilter() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);
		LocalDate currentDate = LocalDate.now();
		LocalDate date7DaysAgo = currentDate.minusDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String toDate = currentDate.format(formatter);
		String fromDate = date7DaysAgo.format(formatter);
		pharmacy_pl1_pageInstance.applyDateFilter(fromDate, toDate);
		pharmacy_pl1_pageInstance.highlightAndClickOnButton(pharmacy_pl1_pageInstance.showDetails,
				"Show Details Button");
		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyActualDatesAreWithinThisRange(fromDate, toDate));
	}

	@Test(priority = 10, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section. \r\n"
					+ "1. Enter the invoice number in Search field. \r\n"
					+ "2. Click on the 'Show Details' button for a matching record. \r\n"
					+ "3. Verify that the records matching the entered keyword are displayed in the table. \r\n"
					+ "4. Click on the 'View' button for the invoice. \r\n"
					+ "5. Verify the invoice number is present in the printed details. \r\n"
					+ "6. Close the 'Add Good Receipt' modal.")
	public void verifySearchResultDisplayedInTable() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Assert.assertTrue(pharmacy_pl1_pageInstance.clickAndEnterValueInSearchField(randomInvoiceNumber),
				"Search Bar is not Displayed");
		pharmacy_pl1_pageInstance.highlightAndClickOnButton(pharmacy_pl1_pageInstance.showDetails,
				"Show Details Button");
		pharmacy_pl1_pageInstance.clickViewButtonWithInvoice(randomInvoiceNumber);
		Assert.assertTrue(pharmacy_pl1_pageInstance.doesPrintContainsInvoiceNumber(randomInvoiceNumber),
				"Print doesn't contains Invoice Number");
		Assert.assertTrue(pharmacy_pl1_pageInstance.closeAddGoodReceiptModal());
	}

	@Test(priority = 11, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section. \r\n"
					+ "1. Enter the keyword \"100\" in the price field. \r\n"
					+ "2. Verify that the records matching the entered keyword are displayed.")
	public void performScrollOperation() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Assert.assertTrue(pharmacy_pl1_pageInstance.performScrollOperation(), "Scroll operation is performed");
	}

	@Test(priority = 12, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section. \r\n"
					+ "1. Hover the mouse over the star/favourite icon. \r\n"
					+ "2. Verify that a tooltip with the text \"Remember this date\" appears when hovering over the star.")
	public void verifyToolTipText() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);

		Map<String, String> pharmacyExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "Pharmacy");
		Assert.assertEquals(pharmacy_pl1_pageInstance.verifyToolTipText(), pharmacyExpectedData.get("favouriteIcon"));
	}

	@Test(priority = 13, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section. \r\n"
					+ "1. Click on the \"Select Supplier\" dropdown. \r\n"
					+ "2. Choose the supplier name from the dropdown. \r\n"
					+ "3. Click on the \"Show Details\" button. \r\n"
					+ "4. The records should be present as per select supplier")
	public void verifyRecordsAccordingToSelectedSupplier() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);

		Map<String, String> pharmacyExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "Pharmacy");

		Assert.assertTrue(pharmacy_pl1_pageInstance.verifyGoodsReceiptTableDataIsPresentAfterEnteringSupplierName(
				pharmacyExpectedData), "Table data is not present for the selected supplier");
	}

	@Test(priority = 14, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Pharmacy section. \r\n"
					+ "1. Click on the \"View\" button. \r\n" + "2. Click on the \"Edit GR\" button. \r\n"
					+ "3. Click on the \"Edit\" pencil icon. \r\n" + "4. Make changes to the Good Receipt. \r\n"
					+ "5. Click on the \"Update\" button.")
	public void verifyUpdateOfExistingGoodReceipt() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);

		Map<String, String> pharmacyExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "Pharmacy");

		Assert.assertTrue(pharmacy_pl1_pageInstance.clickAndEnterValueInSearchField(randomInvoiceNumber),
				"Search Bar is not Displayed");
		pharmacy_pl1_pageInstance.highlightAndClickOnButton(pharmacy_pl1_pageInstance.showDetails,
				"Show Details Button");
		pharmacy_pl1_pageInstance.clickViewButtonWithInvoice(randomInvoiceNumber);
		Assert.assertTrue(pharmacy_pl1_pageInstance.clickOnEditGRButton(), "Edit GR button is not displayed");
		WebElement editGoodsRecordButton = userActionsInstance
				.findElement(pharmacy_pl1_pageInstance.editGoodsRecordButton);
		userActionsInstance.highlightElement(editGoodsRecordButton)
				.click(pharmacy_pl1_pageInstance.editGoodsRecordButton);
		pharmacy_pl1_pageInstance.addGriItemWithMandatoryFieldsOnly(null, null, null, null,
				pharmacyExpectedData.get("mrp"));
		userActionsInstance.click(pharmacy_pl1_pageInstance.updateReceiptButtonId);
		Assert.assertEquals(
				pharmacy_pl1_pageInstance.verifyMessageByText(pharmacyExpectedData.get("goodReceiptUpdatedSuccessMsg")),
				pharmacyExpectedData.get("goodReceiptUpdatedSuccessMsg"));
	}

	@Test(priority = 15, groups = {
			"sanity" }, description = "Verify that the radio buttons in the Pharmacy section can be selected:\r\n"
					+ "1. Click on the 'Complete' radio button and verify it is selectable.\r\n"
					+ "2. Click on the 'Cancelled' radio button and verify it is selectable.\r\n"
					+ "3. Click on the 'All' radio button and verify it is selectable.")
	public void verifyGoodReceiptRadioButtonsAreSelectable() throws Exception {
		pharmacy_pl1_pageInstance = new pharmacy_Pages(driver);
		userActionsInstance = new UserActions(driver);

		pharmacy_pl1_pageInstance.visitTabUnderPharmacy("Supplier");
		pharmacy_pl1_pageInstance.visitTabUnderPharmacy("Order");
		pharmacy_pl1_pageInstance.clickCompleteRadioButton();
		Assert.assertTrue(pharmacy_pl1_pageInstance.isCompleteRadioButtonSelectable());
		pharmacy_pl1_pageInstance.clickCancelledRadioButton();
		Assert.assertTrue(pharmacy_pl1_pageInstance.isCancelledRadioButtonSelectable());
		pharmacy_pl1_pageInstance.clickAllRadioButton();
		Assert.assertTrue(pharmacy_pl1_pageInstance.isAllRadioButtonSelectable());
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
