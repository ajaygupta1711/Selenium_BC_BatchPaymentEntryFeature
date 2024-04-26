package BillingTests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import billingCenter.BCBatchProcessInfo;
import billingCenter.BCNewPayment;
import billingCenter.BCOpenAccount;
import commonGuidewire.BasePageBillingCenter;

public class example extends BaseTestBilling {
	@Test
	public void example() {
		String sheetName = "BatchPayment";
		String account = "";
		int fieldSize = 0;
		try {
			BasePageBillingCenter billingCenter = new BasePageBillingCenter(driver,wait);
			BCOpenAccount openAccount = new BCOpenAccount(driver,wait);
			BCBatchProcessInfo batchProcess = new BCBatchProcessInfo(driver,wait);
			BCNewPayment newPayment = new BCNewPayment(driver,wait);

			
			
	//		account = getAccountNumber(1, environment);
			
			loginToEnvironment(environment);
//			billingCenter.accountQuickSearch(account);
//			billingCenter.navigateBatchPaymentEntry();
//			
//			
//			
//			newPayment.selectSource("Cash Accounting");
//			newPayment.enterBatchAmount("100");
//			
//			fieldSize = reader.getRowCount(sheetName);
//			for (int i = 1; i < fieldSize; i++) {
//				String row = Integer.toString(i-1);
//				newPayment.selectPaymentType(reader.getCellData(sheetName, i, 0), row);
//				//How are changing accounts handled?? search function viable? Same question on Invoice.
//				//newPayment.enterAccount ("1234567", row);
//				//newPayment.enterInvoice ("1234567", row);
//				newPayment.enterProducer (reader.getCellData(sheetName, i, 1), row);
//				newPayment.enterStatementInvoice_Ext (reader.getCellData(sheetName, i, 2), row); 
//				newPayment.enterAmount (reader.getCellData(sheetName, i, 3), row); 
//				newPayment.enterRefNumber (reader.getCellData(sheetName, i, 4), row); 
//				newPayment.enterDescription (reader.getCellData(sheetName, i, 5), row); 
//				newPayment.enterPaymentInstrument (reader.getCellData(sheetName, i, 6), row);
//			}
//			
//			
//			batchProcess.batchRefresh();
			
			
			String when = billingCenter.getDayOfMonth();
			if (when.equals("First") ) {
				billingCenter.navigateBatchProcess();
				//batchProcess.actionRunBtn("direct bill commission statement???");
			} else if (when.equals("Last")) {
				billingCenter.navigateBatchProcess();
				//batchProcess.actionRunBtn("agency bill statement??");
			}
			
			
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue("Test Execution Failed.", false);
		}
	}
}
