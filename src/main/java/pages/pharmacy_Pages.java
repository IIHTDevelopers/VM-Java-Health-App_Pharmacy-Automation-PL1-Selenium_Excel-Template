package pages;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pharmacy_Pages extends StartupPage {

	By usernameTextbox = By.xpath(" ");
	By passwordTextbox = By.xpath(" ");
	By signInButton = By.xpath(" ");
	By pharmacyTabXpath = By.xpath(" ");
	By orderTabXpath = By.xpath(" ");
	By supplierTabXpath = By.xpath("  ");
	By reportTabXpath = By.xpath("  ");
	By settingTabXpath = By.xpath("  ");
	By storeTabXpath = By.xpath("  ");
	By supplierLedgerTabXpath = By.xpath("  ");
	By substoreRequestAndDispatchTabXpath = By
			.xpath(" ");
	By purchaseOrderSubTabXpath = By.xpath("  ");
	By goodsReceiptSubTabXpath = By.xpath("  ");
	By agingDaysFromXpath = By.xpath("  ");
	By agingDaysToXpath = By.xpath("  ");
	public By searchBarId = By.id("  ");
	public By supplierNameDropdownXpath = By.xpath("  ");
	public By showDetails = By.xpath(" ");
	By calendarFromDropdown = By.xpath(" ");
	By calendarToDropdown = By.xpath("  ");
	By okButtonXpath = By.xpath(" ");
	By filterDropdownXpath = By.xpath("  ");
	By radiButtonCompleteXpath = By.xpath("  ");
	public By radiButtonCancelledXpath = By.xpath("  ");
	By radiButtonAllXpath = By.xpath("  ");
	By homepageLogo = By.cssSelector("  ");
	By printReceiptButtonId = By.id("  ");
	public By updateReceiptButtonId = By.id(" ");
	By itemNameId = By.id("  ");
	By batchNumberId = By.id("  ");
	By quantityId = By.id("  ");
	By rateId = By.id("  ");
	By saveButtonId = By.id("  ");
	By mrpId = By.id("MRP");
	By supplierNameDropdownId = By.id("  ");
	By invoiceNumberFieldId = By.id("  ");
	By paymentModeDropdownId = By.id("  ");
	By closeModalButtonXpath = By.xpath("  ");
	public By closeModalButtonXpath2 = By.xpath("  ");
	By expiryDateFieldId = By.id("  ");
	By addNewItemModalXpath = By.xpath("  ");
	By modalXpath = By.xpath("  ");
	By favouriteOrStarIcon = By.xpath("  ");
	By goodReceiptTableDataRow = By.cssSelector("  ");
	public By editGRButton = By.cssSelector("  ");
	public By cancelGoodsReceiptSButton = By.id("  ");
	public By cancelRemarks = By.id("  ");
	public By proceedButton = By.xpath("  ");
	public By editGoodsRecordButton = By.id("  ");
	public By cancelledStamp = By.xpath("  ");
	By actualDatesOfGoodReceiptTableXpath = By
			.xpath("  ");
	By gridXpath = By.xpath("  ");
	By actualDatesOfPurchaseOrderTableXpath = By.xpath("  ");
	public By purchaseOrderXpath = By.xpath("  ");
	public By patientTabXpath = By.xpath("  ");
	public By registerPatient = By.xpath("  ");
	public By profilePicture = By.cssSelector("  ");
	public By newPhoto = By.xpath("  ");
	public By chooseFileButton = By.cssSelector("  ");
	public By doneButton = By.xpath("  ");
	public By uploadedImage = By.cssSelector("  ");
	public By uploadedProfilePhotoXpath = By.xpath("  ");
	public By exportButton = By.cssSelector("  ");

	private By tabXpath;

	String pageName = this.getClass().getSimpleName();

	public pharmacy_Pages(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Test1.1 about this method loginTohealthAppByGivenValidCredetial()
	 * 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in
	 *              button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		
		return false;
	}
	
	/**
	 * @Test1.2 about this method clickOnHomePageLogo()
	 * 
	 * @param : null
	 * @description : This method finds the homepage logo on the screen. If the logo
	 *              is displayed, it highlights the logo and clicks on it.
	 * @return : void
	 * @author : YAKSHA
	 */
	public void clickOnHomePageLogo() {
		//nothing to return
		
	}


	/**
	 * @Test1.3 about this method verifyTitleOfThePage()
	 * 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the
	 *              current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTitleOfThePage() throws Exception {
		
		return null;
	}

	/**
	 * @Test1.4 about this method verifyURLOfThePage()
	 * 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the
	 *              current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyURLOfThePage() throws Exception {
		return null;
	}

	
	/**
	 * @Test2.1 about this method scrollDownAndClickPharmacyTab()
	 * 
	 * @param : null
	 * @description : verify the pharmacy tab, scroll to it, and click it
	 * @return : String
	 * @author : YAKSHA
	 */
	public void scrollDownAndClickPharmacyTab() throws Exception {
		
	}

	/**
	 * @Test2.2 about this method getPharmacyPageUrl()
	 * 
	 * @param : null
	 * @description : This method retrieves the current URL of the page to verify if
	 *              the user is on the Pharmacy page.
	 * @return : String - the current URL of the page
	 * @author : YAKSHA
	 */
	public String getPharmacyPageUrl() throws Exception {
		return null;
	}

	/**
	 * @Test3 about this method verifyAndHighlightTab()
	 * @param : String tabName - The name of the tab to verify and highlight
	 * @description : This method locates the tab specified by the tabName parameter
	 *              in the Pharmacy module, highlights it, and returns true if the
	 *              tab is displayed.
	 * @return : boolean - true if the tab is displayed, false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the tab
	 * @author : YAKSHA
	 */
	public boolean verifyAndHighlightTab(String tabName) throws Exception {
		return false;
	}

	private void setTabXpath(String tabName) {
		
	}

	/**
	 * @Test4.1, @Test5.1, @Test6.1 @Test7.1 @Test15.1 @Test15.2 about
	 * this method visitOrderTabUnderPharmacy()
	 * 
	 * @param : null
	 * @description : navigates the user to the order screen
	 * @return : void
	 * @author : YAKSHA
	 */
	public void visitTabUnderPharmacy(String tabName) throws Exception {
		
	}

	/**
	 * @Test4.2 about this method isOrderTabSelected()
	 * 
	 * @param : null
	 * @description : verify whether the order tab is the currently selected tab
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean isOrderTabSelected() throws Exception {
		return false;
	}

	/**
	 * @Test4.3 about this method areSubTabsUnderOrderPresent()
	 * 
	 * @param : null
	 * @description : verify all sub tabs under order are present
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean areSubTabsUnderOrderPresent() throws Exception {
		return false;
	}

	/**
	 * @Test4.4 about this method isButtonPresent()
	 * 
	 * @param : String
	 * @description : verify button presence through text
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean isButtonPresent(String buttonText) throws Exception {
		return false;
	}

	/**
	 * @Test4.5 about this method areAgingDaysFieldsPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'Aging Days From' and 'Aging Days
	 *              To' fields are present and highlighted.
	 * @return : boolean - true if both fields are displayed, false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           fields
	 * @author : YAKSHA
	 */
	public boolean areAgingDaysFieldsPresent() throws Exception {
		return false;
	}

	/**
	 * @Test4.6 about this method isSearchBarPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the search bar is present and
	 *              highlighted on the page.
	 * @return : boolean - true if the search bar is displayed, false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           search bar
	 * @author : YAKSHA
	 */
	public boolean isSearchBarPresent() throws Exception {
		return false;
	}

	/**
	 * @Test4.7 about this method areDateDropdownsPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'From' and 'To' date dropdowns are
	 *              present and highlighted on the page.
	 * @return : boolean - true if both date dropdowns are displayed, false
	 *         otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           dropdowns
	 * @author : YAKSHA
	 */
	public boolean areDateDropdownsPresent() throws Exception {
		return false;
	}

	/**
	 * @Test4.8 about this method isSelectSupplierDropdownPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'Select Supplier' dropdown is
	 *              present and highlighted on the page.
	 * @return : boolean - true if the 'Select Supplier' dropdown is displayed,
	 *         false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           dropdown
	 * @author : YAKSHA
	 */
	public boolean isSelectSupplierDropdownPresent() throws Exception {
		return false;
	}

	/**
	 * @Test4.9 about this method isFilterDropdownPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the filter dropdown is present and
	 *              highlighted on the page.
	 * @return : boolean - true if the filter dropdown is displayed, false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           dropdown
	 * @author : YAKSHA
	 */
	public boolean isFilterDropdownPresent() throws Exception {
		return false;
	}

	/**
	 * @Test4.10 about this method areFilterByStatusRadioButtonsPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'Completed', 'Cancelled', and
	 *              'All' radio buttons are present and highlighted on the page.
	 * @return : boolean - true if all three radio buttons are displayed, false
	 *         otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the radio
	 *           buttons
	 * @author : YAKSHA
	 */
	public boolean areFilterByStatusRadioButtonsPresent() throws Exception {
		return false;
	}

	/**
	 * @Test5.2 about this method verifySelectedTabIsActiveOrNot()
	 * 
	 * @param : null
	 * @description : This method verifies if the "Supplier" tab is displayed and
	 *              returns its "class" attribute value. This can be used to
	 *              determine if the tab is active or not based on its class
	 *              attributes.
	 * @return : String - the value of the "class" attribute of the "Supplier" tab
	 *         if it is displayed, an empty string otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the tab,
	 *           or getting its attribute
	 * @author : YAKSHA
	 */
	public String verifySelectedTabIsActiveOrNot() throws Exception {
		String locatorAttributeValue = "";
		return null;
	}

	/**
	 * @Test6.2, @Test7.2 and @Test7.3 about this method clickButtonByText()
	 * 
	 * @param buttonText : String - The text of the button to be clicked
	 * @description : This method locates a button using its text and performs a
	 *              click action on it. If the button is found and successfully
	 *              clicked, it highlights the button first. In case of failure
	 *              (e.g., button not found or click error), an error message is
	 *              printed and an exception is thrown.
	 * @return : void
	 * @throws : Exception - if there is an issue finding the button or performing
	 *           the click action
	 * @author : YAKSHA
	 */
	public void clickButtonByText(String buttonText) throws Exception {
		
	}

	/**
	 * @Test6.3 about this method clickPrintReceipt()
	 * 
	 * @param : null
	 * @description : This method locates the "Print Receipt" button using its
	 *              identifier and performs a click action on it. The button is
	 *              highlighted before clicking to ensure visibility. If an
	 *              exception occurs during the finding or clicking of the button,
	 *              it is re-thrown.
	 * @return : void
	 * @throws : Exception - if there is an issue finding the button or performing
	 *           the click action
	 * @author : YAKSHA
	 */
	public void clickPrintReceipt() throws Exception {
		
	}

	/**
	 * @Test6.4, @Test7.6 @Test14.6 about this method
	 * verifyMessageByText()
	 * 
	 * @param messageText - the text to match within the message element
	 * @description : This method locates a message element on the page by searching
	 *              for a paragraph (`
	 *              <p>
	 *              `) that contains the specified text (`messageText`) or has a
	 *              class `main-message`. It highlights the message element and
	 *              returns its text content. If an exception occurs while finding
	 *              or retrieving the message, it logs an error and re-throws the
	 *              exception.
	 * @return : String - the text content of the located message element
	 * @throws : Exception - if there is an issue finding the message or retrieving
	 *           its text
	 * @author : YAKSHA
	 */
	public String verifyMessageByText(String messageText) throws Exception {
		return null;
	}

	/**
	 * @Test6.5, @Test8.5 and @Test10.5 about this method closeAddGoodReceiptModal()
	 * 
	 * @param : null
	 * @description : This method locates the "Close" button of the "Add Good
	 *              Receipt" modal using the provided XPath
	 *              (`closeModalButtonXpath`). It highlights the button and then
	 *              clicks it to close the modal. If an exception occurs while
	 *              finding or interacting with the button, it logs an error and
	 *              re-throws the exception.
	 * @return : void
	 * @throws : Exception - if there is an issue finding or clicking the "Close"
	 *           button
	 * @author : YAKSHA
	 */
	public boolean closeAddGoodReceiptModal() throws Exception {
		return false;
	}

	/**
	 * @Test7.4 and @Test14.5 about this method addGriItemWithMandatoryFieldsOnly()
	 * 
	 * @param itemName    - the name of the item to be added
	 * @param batchNumber - the batch number of the item
	 * @param quantity    - the quantity of the item
	 * @param rate        - the rate of the item
	 * @param mrp         - the MRP (Maximum Retail Price) of the item
	 * @description : This method adds an item to the GRI (Goods Receipt Inventory)
	 *              with mandatory fields only. It highlights and enters values for
	 *              item name, batch number, expiry date, quantity, rate, and MRP.
	 *              If any of these fields are not provided, they are skipped. The
	 *              method then clicks the save button. If the modal appears, it
	 *              waits for the modal to fully load.
	 * @return : void
	 * @throws : Exception - if there is any issue locating elements, entering data,
	 *           or clicking the save button
	 * @author : YAKSHA
	 */
	public void addGriItemWithMandatoryFieldsOnly(String itemName, String batchNumber, String quantity, String rate,
			String mrp) throws Exception {
	
	}

	/**
	 * @Test7.5 about this method enterMandatoryDetailsToPrintGoodReceipt()
	 * 
	 * @param invoiceNumber - the invoice number to be entered in the field
	 * @description : This method enters mandatory details required to print a good
	 *              receipt. It locates and highlights the supplier dropdown,
	 *              invoice number field, and payment mode dropdown. It then enters
	 *              the provided invoice number and selects the necessary options
	 *              from the dropdowns before clicking the print receipt button.
	 * @return : void
	 * @throws : Exception - if there is any issue locating elements, entering data,
	 *           or clicking buttons
	 * @author : YAKSHA
	 */
	public void enterMandatoryDetailsToPrintGoodReceipt(String invoiceNumber) throws Exception {
		
	}

	/**
	 * @Test8.1 about this method closeModalBySubjectName()
	 * 
	 * @param : String
	 * @description : Closes the modal with the subject name
	 * @return : void
	 * @throws : Exception - if there is an issue finding or clicking the cross
	 *           button
	 * @author : YAKSHA
	 */
	public void closeModalBySubjectName(String modalTitle) throws Exception {
		
	}

	/**
	 * @Test8.4 @Test10.3 @Test14.3 about this method
	 * clickViewButtonWithInvoice()
	 * 
	 * @param : String
	 * @description : Clicks on the "view" button next to a particular invoice
	 *              number
	 * @return : void
	 * @throws : Exception - if there is an issue finding or clicking the "view"
	 *           button
	 * @author : YAKSHA
	 */
	public void clickViewButtonWithInvoice(String invoiceNumber) throws Exception {
		
	}

	/**
	 * @Test8.6 @Test10.4 about this method doesPrintContainsInvoiceNumber()
	 * 
	 * @param : String
	 * @description : Verify whether the printed report contains expected invoice
	 *              number
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding or clicking the invoice
	 *           number text button
	 * @author : YAKSHA
	 */
	public boolean doesPrintContainsInvoiceNumber(String invoiceNumber) throws Exception {
		return false;
	}

	/**
	 * @Test8.2 @Test10.1 @Test14.1 about this method
	 * clickAndEnterValueInSearchField()
	 * 
	 * @param : String
	 * @description : Enters value in the search bar
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding or typing the text
	 * @author : YAKSHA
	 */
	public boolean clickAndEnterValueInSearchField(String searchData) {
		
		return false;
	}

	/**
	 * @Test12 about this method verifyToolTipText()
	 * @param : null
	 * @description : Verify the text of the tooltip
	 * @return : String
	 * @throws : Exception - if there is an issue finding the text
	 * @author : YAKSHA
	 */
	public String verifyToolTipText() {
		return null;
	}

	/**
	 * @Test13 about this method
	 *         verifyGoodsReceiptTableDataIsPresentAfterEnteringSupplierName()
	 * 
	 * @param : null
	 * @description : Verify result appears after searching with supplier name
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the result
	 * @author : YAKSHA
	 */
	public boolean verifyGoodsReceiptTableDataIsPresentAfterEnteringSupplierName(
			Map<String, String> pharmacyExpectedData) {
		return false;
	}

	/**
	 * @Test14.4 about this method clickOnEditGRButton()
	 * 
	 * @param : null
	 * @description : Clicks on the edit GR button
	 * @return : boolean
	 * @throws : Exception - if there is an issue clicking the edit GR button
	 * @author : YAKSHA
	 */
	public boolean clickOnEditGRButton() {
		return false;
	}

	/**
	 * @Test8.3 @Test9.2 @Test10.2 @Test14.2
	 * about this method highlightAndClickOnButton()
	 * 
	 * @param : By, String
	 * @description : Highlights the provided element and clicks on it
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the element
	 * @author : YAKSHA
	 */
	public boolean highlightAndClickOnButton(By element, String buttonName) {
		return false;
	}

	/**
	 * @Test11 about this method performScrollOperation()
	 * @param : null
	 * @description : Scrolls till Pharmacy tab, selects it, and clicks "Order" sub
	 *              tab
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the tab
	 * @author : YAKSHA
	 */
	public boolean performScrollOperation() {
		return false;
	}

	/**
	 * @Test9.1 about this method applyDateFilter()
	 * 
	 * @param : String, String
	 * @description : Applies the date filter with date range
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding or filling the date fields
	 * @author : YAKSHA
	 */
	public boolean applyDateFilter(String fromDate, String toDate) throws Exception {
		return false;
	}

	/**
	 * @Test9.3 about this method verifyActualDatesAreWithinThisRange()
	 * 
	 * @param : String, String
	 * @description : Verify whether results are within the applied date range
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the actual dates within
	 *           the results
	 * @author : YAKSHA
	 */
	public boolean verifyActualDatesAreWithinThisRange(String fromDate, String toDate) {
		return false;
	}

	

	/**
	 * @Test15.3 about this method clickCompleteRadioButton()
	 * 
	 * @param : null
	 * @description : Clicks on the "Complete" radio button
	 * @return : void
	 * @throws : Exception - if there is an issue finding the radio button
	 * @author : YAKSHA
	 */
	public void clickCompleteRadioButton() throws Exception {
		
	}

	/**
	 * @Test15.4 about this method isCompleteRadioButtonSelectable()
	 * 
	 * @param : null
	 * @description : Verify whether the "Complete" radio button is selectable
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the radio button
	 * @author : YAKSHA
	 */
	public boolean isCompleteRadioButtonSelectable() throws Exception {
		return false;	
	}

	/**
	 * @Test15.5 about this method clickCancelledRadioButton()
	 * 
	 * @param : null
	 * @description : Clicks the "Cancelled" radio button
	 * @return : void
	 * @throws : Exception - if there is an issue finding the radio button
	 * @author : YAKSHA
	 */
	public void clickCancelledRadioButton() throws Exception {
		
	}

	/**
	 * @Test15.6 about this method isCancelledRadioButtonSelectable()
	 * 
	 * @param : null
	 * @description : Verify whether the "Cancelled" radio button is selectable
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the radio button
	 * @author : YAKSHA
	 */
	public boolean isCancelledRadioButtonSelectable() throws Exception {
		return false;
		}

	/**
	 * @Test15.7 about this method clickAllRadioButton()
	 * 
	 * @param : null
	 * @description : Clicks the "All" radio button
	 * @return : void
	 * @throws : Exception - if there is an issue finding the radio button
	 * @author : YAKSHA
	 */
	public void clickAllRadioButton() throws Exception {
		
	}

	/**
	 * @Test15.8 about this method isAllRadioButtonSelectable()
	 * 
	 * @param : null
	 * @description : Verify whether the "All" radio button is selectable
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the radio button
	 * @author : YAKSHA
	 */
	public boolean isAllRadioButtonSelectable() throws Exception {
		return false;
	}

}
