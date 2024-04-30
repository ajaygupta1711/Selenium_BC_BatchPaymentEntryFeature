package BatchPaymentEntry;

import org.testng.annotations.Test;
import billingCenter.BCNewPayment;

public class PaymentEntryWizard extends BaseBillingTest {
	
	@Test
	public void BC_PaymentEntryWizard() throws InterruptedException {
		
		System.out.println("\n 1. Login to Guidewire BillingCenter");
		loginToApp("qa1_bc");
		
		BCNewPayment newpayment = new BCNewPayment(driver,wait);
		
		System.out.println("\n 2. Navigate to the Batch Payment Entry feature");
		newpayment.navigateBatchPaymentEntry();
		 
		System.out.println("\n 3. Enter payment details on account level");
		newpayment.enterDataOnAccountLevel("BatchPaymentEntries", "0");
		
		System.out.println("\n 4. Enter payment details on invoice level");
		newpayment.enterDataOnInvoiceLevel("BatchPaymentEntries", "1");
		
		System.out.println("\n 5. Enter payment details on agency level");
		newpayment.enterDataOnAgencyLevel("BatchPaymentEntries", "2");
		
		System.out.println("\n 6. Enter payment details on agency statement level");
		newpayment.enterDataOnAgencyStatementLevel("BatchPaymentEntries", "3");
		
		System.out.println("\n 7. Enter payment details on agency DB commission level");
		newpayment.enterDataOnDBCommissionsLevel("BatchPaymentEntries", "4");
		
		System.out.println("\n 8. Enter payment details on suspense level");
		newpayment.enterDataOnSuspenseLevel("BatchPaymentEntries", "5"); 
		
		System.out.println("\n 9. Enter payemnt details on split level");
		newpayment.enterDataOnSplitLevel("BatchPaymentEntries", "6");
		
		System.out.println("\n 10. Enter payemnt details on split account level");
		newpayment.enterDataOnSplitAccountlevel("BatchPaymentEntries", "6.1");
		
		System.out.println("\n 11. Enter payemnt details on split invoice level");
		newpayment.enterDataOnSplitInvoicelevel("BatchPaymentEntries", "6.2");
		
		System.out.println("\n 12. Enter payemnt details on split Agency level");
		newpayment.enterDataOnSplitAgencylevel("BatchPaymentEntries", "6.3");
		
		System.out.println("\n 13. Enter payemnt details on split Agency statement level");
		newpayment.enterDataOnSplitAgencyStatementlevel("BatchPaymentEntries", "6.4");
		
		System.out.println("\n 14. Enter payemnt details on split Agency DB commissions level");
		newpayment.enterDataOnSplitDBCommissionslevel("BatchPaymentEntries", "6.5");
		
		System.out.println("\n 15. Enter payemnt details on split suspense level");
		newpayment.enterDataOnSplitSuspenselevel("BatchPaymentEntries", "6.6");
		
		System.out.println("\n 16. Enter the Total Amount in Batch Amount and Save the Batch Number");
		newpayment.enterTotalAmountInBatchAmount();
		String expectedBatchNumber = newpayment.batchNumber();
	
		System.out.println("\n 17. Click on Next and Post Batch buttons and Save the CheckRef Numner");
		newpayment.clickNextBatchBtn();
		String expectedCheckRefNumber = newpayment.checkRefNumber();
		newpayment.clickPostbatchBtn();
		
		System.out.println("\n 18. Run the PostSurePathBatch job");
		newpayment.navigateBatchProcess();
		newpayment.clickRunBtn();
		
		System.out.println("\n 19. Navigate to the Desktop screen");
		newpayment.clickActionBtn();
		newpayment.clickreturnToBillingCenter(); 
		
		System.out.println("\n 20. Verify the Batch Number of posted payments on account level");
		newpayment.navigatePaymentsScreenOnAccountLevel("BatchPaymentEntries", "0");
		newpayment.validateBatchNumberInPaymentsTable(expectedBatchNumber);
		
		System.out.println("\n 21. Verify the Batch Number of posted payments on agency level");
		newpayment.navigateExecutedPaymentsScreenOnAgencyLevel("BatchPaymentEntries", "2");
		newpayment.validateBatchNumberInExecutedPaymentsTable(expectedBatchNumber); 
		
		System.out.println("\n 22. Verify the Check/Ref of posted payments on agency level");
		newpayment.navigateTransactionsScreenOnAgencyLevel("BatchPaymentEntries", "4");
		newpayment.validateCheckRefNumberInTransactionTable(expectedCheckRefNumber);
		
		System.out.println("\n 23. Verify the Batch Number of posted payments on suspense level");
		newpayment.navigateSuspensePaymentsScreenOnDesktopLevel();
		newpayment.validateBatchNumberInSuspensePaymentsTable(expectedBatchNumber);
		
		System.out.println("\n 24. Logout from BillingCenter");
		newpayment.logout("BillingCenter");
		}
}