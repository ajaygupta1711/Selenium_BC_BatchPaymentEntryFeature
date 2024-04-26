package billingCenter;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonGuidewire.BasePageBillingCenter;
import qaDataAccess.TestDataReader;

public class BCNewPayment extends BasePageBillingCenter {

	public BCNewPayment(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "BatchPaymentEntryWizard-NewBatchPaymentScreen-Source_Ext")
	private WebElement sourceSelect; 

	@FindBy(how = How.CSS, using = "input[name='BatchPaymentEntryWizard-NewBatchPaymentScreen-BatchAmount']")
	private WebElement batchAmount;

	@FindBy(how = How.ID, using = "BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV_tb-AddEmptyPayments")
	private WebElement batchAddBtn; 
	
	@FindBy(how = How.ID, using = "BatchPaymentEntryWizard-Cancel")
	private WebElement batchCancelBtn; 
	
	@FindBy(how = How.ID, using = "BatchPaymentEntryWizard-Next")
	private WebElement batchNextBtn; 
	
	@FindBy(how = How.ID, using = "BatchSearchPage-PaymentBatchesSearchScreen-BatchSearchDV-CreatedBy-UserBrowseMenuItem")
	private WebElement selectUserBtn; 
	
	@FindBy(how = How.ID, using = "BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV_tb-PostButton")
	private WebElement batchPostBatchBtn;
		
	
	public void selectSource(String source) {
		wait.until(ExpectedConditions.elementToBeClickable(sourceSelect));
		Select dropdown = new Select(sourceSelect);
		dropdown.selectByVisibleText(source);
	}

	public void enterBatchAmount(String amount) {
		wait.until(ExpectedConditions.elementToBeClickable(batchAmount));
		writeText(batchAmount, amount);
		batchAmount.sendKeys(Keys.TAB);
	}

	/*public void selectPaymentType (String type, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-PaymentType")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-0-PaymentType"));
		Select dropdown = new Select(driver.findElement(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-PaymentType")));
		dropdown.selectByVisibleText(type);
	}*/

/*	public void enterAccount (String account, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Account")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Account"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Account"), account);
	} */
	
	public void enterDataInPaymentsTable (String entity, String value, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity)));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity), value);
		driver.findElement(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity)).sendKeys(Keys.TAB);
	}

	/*public void enterInvoice (String invoice, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Invoice")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Invoice"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Invoice"), invoice);
	}*/

	/*public void enterAgencyCode (String producer, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Producer")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Producer"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Producer"), producer);
	}*/					

	/*public void enterABStatement (String statement, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-StatementInvoice_Ext")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-StatementInvoice_Ext"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-StatementInvoice_Ext"), statement);
	}*/

	public void enterAmount (String amount, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount"));
		clearText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount"), amount);
		driver.findElement(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount")).sendKeys(Keys.TAB);
	}
	
	/*public void enterRefNumber (String reference, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-RefNumber")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-RefNumber"));
		Random random = new Random();
		int randomInt = random.nextInt(999999999);
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-RefNumber"), reference+randomInt+9);
	}

	public void enterDescription (String desc, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Description")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Description"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Description"), desc);
	}*/

	public void selectDatainPaymentsTable (String entity, String value, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity)));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity));
		Select dropdown = new Select(driver.findElement(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-"+entity)));
		dropdown.selectByVisibleText(value);
	}
	
	/*public void enterPaymentInstrument (String paymentIns, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-paymentinstrument")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-paymentinstrument"));
		Select dropdown = new Select(driver.findElement(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-paymentinstrument")));
		dropdown.selectByVisibleText(paymentIns);
	}*/

	public void clickAddBatchBtn() {
		scrollToView(batchAddBtn);
		click(batchAddBtn);
	}
	
	public void clickCancelBatchBtn() {
		scrollToView(batchCancelBtn);
		click(batchCancelBtn);
		wait.until(ExpectedConditions.elementToBeClickable(selectUserBtn));
	}
	
	public void clickNextBatchBtn() {
		scrollToView(batchNextBtn);
		click(batchNextBtn);
	}
	
	public void clickPostbatchBtn() {
		scrollToView(batchPostBatchBtn);
		click(batchPostBatchBtn);
	}
	

/**
* @author Ajay
* Post and verify payments through Batch Payment Entry 
*/	
	
	
// -- Web element details for Batch Payment Entry feature
	
	@FindBy(how = How.ID, using = "BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV_tb-SplitMultiPayment")
	private WebElement btnSplit;
	
	@FindBy(how = How.ID, using = "NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV_tb-Add")
	private WebElement btnAddSplit;
	
	@FindBy(how = How.ID, using = "NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-Update")
	private WebElement btnOKSplit;
	
	@FindBy(how = How.ID, using = "BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-AmountFooter")
	private WebElement txtTotalAmount;
		
	@FindBy(how = How.XPATH, using = "//*[@id='BatchPaymentEntryWizard-NewBatchPaymentScreen-BatchNumber']//div[@class='gw-value-readonly-wrapper']")
	private WebElement txtbatchNumber;
	
	@FindBy(how = How.CSS, using = "*[id=BatchProcessInfo-BatchProcessScreen-BatchProcessesLV-57-RunBatchWithoutNotify]")
	private WebElement btnrunPostBatch;
		
	@FindBy(how = How.XPATH, using = "//div[@role='button']//div[@aria-label='Actions']")
	private WebElement btnaction;
		
	@FindBy(how = How.XPATH, using = "(//div[text()='Return to BillingCenter'])[1]")
	private WebElement lnkreturnToBillingCenter;
	
	@FindBy(how = How.XPATH, using = "//div[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments']//div[@class='gw-icon gw-icon--expand']")
	private WebElement paymentsIcon;
	
	@FindBy(how = How.CSS, using = "div[id=AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments-AccountDetailPayments_AccountPayments]")
	private WebElement screenPayments;
	
	@FindBy(how = How.XPATH, using = "//*[@id='AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV']//tbody//tr//td[10]")
	private WebElement tablepaymentsColumn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"TabBar-ProducersTab\"]/div[3]")
	private WebElement producerSubMenuBtn;
	
	@FindBy(how = How.NAME, using = "TabBar-ProducersTab-ProducerNameSearchItem")
	private WebElement producerSearch;
	
	@FindBy(how = How.ID, using = "TabBar-ProducersTab-ProducerNameSearchItem_Button")
	private WebElement producerSearchBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ProducerDetailGroup-MenuLinks-ProducerDetailGroup_AgencyBillPayments']//div[@class='gw-icon gw-icon--expand']")
	private WebElement agencyBillPaymentSubMenuBtn;
	
	@FindBy(how = How.ID, using = "ProducerDetailGroup-MenuLinks-ProducerDetailGroup_AgencyBillPayments-AgencyBillPayments_AgencyBillExecutedPayments")
	private WebElement agencyExecutedPaymentsScreen;
	
	@FindBy(how = How.ID, using = "TabBar-DesktopTab")
	private WebElement desktopScreen;
	
	@FindBy(how = How.ID, using = "ProducerDetailGroup-MenuLinks-ProducerDetailGroup_ProducerTransactions")
	private WebElement agencyTransactionsScreen;
	
	@FindBy(how = How.ID, using = "ProducerTransactions-ProducerTransactionsScreen-PaymentsCardTab")
	private WebElement agencyTransactionsPaymentsTab;
	
	
// Methods for above defined elements locators
	/**
	* @author Ajay
	* @ Post and verify payments through Batch Payment Entry 
	*/
		
	public void selectDBCommissionChkBox(String chkBox, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-DBCommissions_Ext_checkboxDiv")));
		scrollToView(By.id("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-DBCommissions_Ext_checkboxDiv"));
		driver.findElement(By.id("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-DBCommissions_Ext_checkboxDiv")).click();
	}

	public void selectSplitChkBox(String chkBox, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-_Checkbox_checkboxDiv")));
		scrollToView(By.id("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-_Checkbox_checkboxDiv"));
		driver.findElement(By.id("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-_Checkbox_checkboxDiv")).click();
	}
	
	public void clickSplitBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSplit));
		scrollToView(btnSplit);
		click(btnSplit);
	}
	
	public void clickAddBtnSplit() {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddSplit));
		scrollToView(btnAddSplit);
		click(btnAddSplit);
	}
	
	/*public void enterTotalSplitAmount (String amount, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount")));
		scrollToView(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount"));
		clearText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount"));
		writeText(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount"), amount);
		driver.findElement(By.name("BatchPaymentEntryWizard-NewBatchPaymentScreen-NewMultiPaymentLV-"+row+"-Amount")).sendKeys(Keys.TAB);
	}*/

	/* public void selectPaymentTypeSplit (String type, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-PaymentType")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-PaymentType"));
		Select dropdown = new Select(driver.findElement(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-PaymentType")));
		dropdown.selectByVisibleText(type);
	}*/
	
	public void selectDataInSplitPaymentsTable(String entity, String value, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity)));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity));
		Select dropdown = new Select(driver.findElement(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity)));
		dropdown.selectByVisibleText(value);
	}

	public void enterDataInSplitPaymentsTable (String entity, String value, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity)));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity), value);
		driver.findElement(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-"+entity)).sendKeys(Keys.TAB);
	}
	
	/*public void enterAccountSplit (String account, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Account")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Account"));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Account"), account);
	}

	public void enterInvoiceSplit (String invoice, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Invoice")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Invoice"));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Invoice"), invoice);
	}

	public void enterAgencyCodeSplit (String producer, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Producer")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Producer"));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Producer"), producer);
	}					

	public void enterABStatementSplit (String statement, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-StatementInvoice_Ext")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-StatementInvoice_Ext"));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-StatementInvoice_Ext"), statement);
	}*/
	
	public void selectDBCommissionChkBoxSplit(String chkBox, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-DBCommissions_Ext")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-DBCommissions_Ext"));
		driver.findElement(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-DBCommissions_Ext")).click();
	}
	

	/*public void enterAmountSplit (String amount, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Amount")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Amount"));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Amount")));
		clearText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Amount"));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Amount"), amount);
		driver.findElement(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Amount")).sendKeys(Keys.TAB);
	}

	public void enterDescriptionSplit (String desc, String row) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Description")));
		scrollToView(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Description"));
		writeText(By.name("NewMultiPaymentSplitExtPopup-NewMultiPaymentSplitExtScreen-NewMultiPaymentLV-"+row+"-Description"), desc);
	} */
	
	public void clickOKBtnSplit() {
		wait.until(ExpectedConditions.elementToBeClickable(btnOKSplit));
		scrollToView(btnOKSplit);
		click(btnOKSplit);
	}
	
	public void enterTotalAmountInBatchAmount()
	{
		String TotalAmount = wait.until(ExpectedConditions.elementToBeClickable(txtTotalAmount)).getText();
		wait.until(ExpectedConditions.elementToBeClickable(batchAmount));
		writeText(batchAmount, TotalAmount);
		batchAmount.sendKeys(Keys.TAB);
	}
	
	public void batchNumber()
	{
		String batchNumberValue = wait.until(ExpectedConditions.elementToBeClickable(txtbatchNumber)).getText();
		System.out.println(batchNumberValue);
	}
	
	public void clickRunBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnrunPostBatch));
		btnrunPostBatch.sendKeys(Keys.ENTER);
		btnrunPostBatch.sendKeys(Keys.ENTER);
	}
	
	public void clickActionBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnaction));
		click(btnaction);
	}
	
	public void clickreturnToBillingCenter()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lnkreturnToBillingCenter));
		click(lnkreturnToBillingCenter);
	}
	
	public void clickPaymentsScreen()
	{
		wait.until(ExpectedConditions.elementToBeClickable(paymentsIcon));
		click(paymentsIcon);
		wait.until(ExpectedConditions.elementToBeClickable(screenPayments));
		click(screenPayments);
	}
	
	public void producerQuickSearch(String agencycode) {
		click(producerSubMenuBtn);
		writeText(producerSearch, agencycode);
		click(producerSearchBtn);
	}
	
	public void navigatDesktopScreen() {
		wait.until(ExpectedConditions.elementToBeClickable(desktopScreen));
		click(desktopScreen);
	}
	
	public void navigateAgencyExecutedPaymentsScreen() {
		wait.until(ExpectedConditions.elementToBeClickable(agencyBillPaymentSubMenuBtn));
		click(agencyBillPaymentSubMenuBtn);
		wait.until(ExpectedConditions.elementToBeClickable(agencyExecutedPaymentsScreen));
		click(agencyExecutedPaymentsScreen);
	}
	
	public void navigateAgencyTransactionsScreen() {
		click(agencyTransactionsScreen);
		click(agencyTransactionsPaymentsTab);
	}
	
	
public void validateBatchNumberInPaymentsTable()
	{		
		WebElement table = driver.findElement(By.xpath("//*[@id='AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV']//tbody"));
		
		List<WebElement> tableHeadings =  table.findElements(By.xpath("//*[@id='AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV']//tbody//td"));
		List<String> tableHeadingsTexts = new ArrayList<String>();
		
		for(WebElement heading : tableHeadings) {
			String tableHeadingsText = heading.getTagName();
			tableHeadingsTexts.add(tableHeadingsText);
		}
			String columnName = "Batch Number";
			int columnIndex = tableHeadingsTexts.indexOf(columnName);
			
			List<WebElement> columnDatas = table.findElements(By.xpath("//td["+(columnIndex+11)+"]"));
			
			for (WebElement columnData : columnDatas) {
				System.out.println(columnData.getText());
			}
					
			/*if (columnDatas.contains(batchNumberValue)) {
				System.out.println("Account Payment Batch Number Found");
			} else {
				System.out.println("Account Payment Batch Number NOT Found");
			}*/
}
	
	
public void enterDataOnAccountLevel(String sheet, String testID) {
		
		String testIdColHeader = "Tag";
		TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");
		
		String source = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Source"));
		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String account = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Account #"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectSource(source);
		selectDatainPaymentsTable("PaymentType", type, "0");
		enterDataInPaymentsTable("Account", account, "0");		
		enterAmount(amount, "0");
		enterDataInPaymentsTable("RefNumber", checkRef, "0");
		enterDataInPaymentsTable("Description", description, "0");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "0");
		}

public void enterDataOnInvoiceLevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String invoice = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Invoice #"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectDatainPaymentsTable("PaymentType", type, "1");
		enterDataInPaymentsTable("Invoice", invoice, "1");		
		enterAmount(amount, "1");
		enterDataInPaymentsTable("RefNumber", checkRef, "1");
		enterDataInPaymentsTable("Description", description, "1");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "1");
		}

public void enterDataOnAgencyLevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String agencycode = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Agency Code"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectDatainPaymentsTable("PaymentType", type, "2");
		enterDataInPaymentsTable("Producer", agencycode, "2");		
		enterAmount(amount, "2");
		enterDataInPaymentsTable("RefNumber", checkRef, "2");
		enterDataInPaymentsTable("Description", description, "2");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "2");
		}

public void enterDataOnAgencyStatementLevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String agencycode = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Agency Code"));
		String agencystatement = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "AB Statement #"));		
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectDatainPaymentsTable("PaymentType", type, "3");
		enterDataInPaymentsTable("Producer", agencycode, "3");
		enterDataInPaymentsTable("StatementInvoice_Ext", agencystatement, "3");		
		enterAmount(amount, "3");
		enterDataInPaymentsTable("RefNumber", checkRef, "3");
		enterDataInPaymentsTable("Description", description, "3");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "3");
		}

public void enterDataOnDBCommissionsLevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String agencycode = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Agency Code"));		
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectDatainPaymentsTable("PaymentType", type, "4");
		enterDataInPaymentsTable("Producer", agencycode, "4");
		selectDBCommissionChkBox("True", "4");	
		enterAmount(amount, "4");
		enterDataInPaymentsTable("RefNumber", checkRef, "4");
		enterDataInPaymentsTable("Description", description, "4");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "4");
		}

public void enterDataOnSuspenseLevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));		
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectDatainPaymentsTable("PaymentType", type, "5");
		enterAmount(amount, "5");
		enterDataInPaymentsTable("RefNumber", checkRef, "5");
		enterDataInPaymentsTable("Description", description, "5");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "5");
		}

public void enterDataOnSplitLevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));		
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String checkRef = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Check/Ref #"));
		String paymentInstrument = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Payment Instrument"));
		
		selectDatainPaymentsTable("PaymentType", type, "6");
		enterAmount(amount, "6");
		enterDataInPaymentsTable("RefNumber", checkRef, "6");
		selectDatainPaymentsTable("paymentinstrument", paymentInstrument, "6");
		}

public void enterDataOnSplitAccountlevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String account = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Account #"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		
		selectSplitChkBox("True", "6");
		clickSplitBtn();
		clickAddBtnSplit();
		selectDataInSplitPaymentsTable("PaymentType", type, "0");		
		enterDataInSplitPaymentsTable("Account", account, "0");
		enterDataInSplitPaymentsTable("Amount", amount, "0");
		enterDataInSplitPaymentsTable("Description", description, "0");
		clickOKBtnSplit();
		}

public void enterDataOnSplitInvoicelevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String invoice = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Invocie #"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		
		clickAddBtnSplit();
		selectDataInSplitPaymentsTable("PaymentType", type, "1");		
		enterDataInSplitPaymentsTable("Invoice", invoice, "1");
		enterDataInSplitPaymentsTable("Amount", amount, "1");
		enterDataInSplitPaymentsTable("Description", description, "1");
		}

public void enterDataOnSplitAgencylevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String agencycode = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Agency Code"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		
		clickAddBtnSplit();
		selectDataInSplitPaymentsTable("PaymentType", type, "2");		
		enterDataInSplitPaymentsTable("Producer", agencycode, "2");
		enterDataInSplitPaymentsTable("Amount", amount, "2");
		enterDataInSplitPaymentsTable("Description", description, "2");
		}

public void enterDataOnSplitAgencyStatementlevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String agencycode = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Agency Code"));
		String agencyStatement = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Ab Statement #"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		
		clickAddBtnSplit();
		selectDataInSplitPaymentsTable("PaymentType", type, "3");		
		enterDataInSplitPaymentsTable("Producer", agencycode, "3");
		enterDataInSplitPaymentsTable("StatementInvoice_Ext", agencyStatement, "3");
		enterDataInSplitPaymentsTable("Amount", amount, "3");
		enterDataInSplitPaymentsTable("Description", description, "3");
		}

public void enterDataOnSplitDBCommissionslevel(String sheet, String testID) {
	
	String testIdColHeader = "Tag";
	TestDataReader reader = new TestDataReader(System.getProperty("user.dir") + "//DataFiles" + "//" + sheet + ".csv");

		String type = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Type"));
		String agencycode = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Agency Code"));
		String amount = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Amount"));
		String description = reader.getCellData(sheet, reader.getRowByKey(sheet,testIdColHeader, testID),reader.getColumnByKey(sheet, "Description"));
		
		clickAddBtnSplit();
		selectDataInSplitPaymentsTable("PaymentType", type, "4");		
		enterDataInSplitPaymentsTable("Producer", agencycode, "4");
		selectDBCommissionChkBoxSplit("True", "4");
		enterDataInSplitPaymentsTable("Amount", amount, "4");
		enterDataInSplitPaymentsTable("Description", description, "4");
		clickOKBtnSplit();
		}

public void VerifyBatchNumberAccountLevel() {
		accountQuickSearch("3398889");
		clickPaymentsScreen();
		validateBatchNumberInPaymentsTable();
		}

public void VerifyBatchAndChkNumberAgencyLevel() {
		producerQuickSearch("C0010");
		navigateAgencyExecutedPaymentsScreen();
		//Verify the Batch Number Batch Number
		navigateAgencyTransactionsScreen();
		//Verify the Batch Number Check/Ref# Number
		//newpayment.logout("qa1_bc");
		}
}