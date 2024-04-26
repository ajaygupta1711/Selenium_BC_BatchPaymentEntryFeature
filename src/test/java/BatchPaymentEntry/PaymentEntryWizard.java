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
		
 /* 	System.out.println("\n 11. Enter payemnt details on split invoice level");
		newpayment.enterDataOnSplitInvoicelevel("BatchPaymentEntries", "6.2");
		
		System.out.println("\n 12. Enter payemnt details on split Agency level");
		newpayment.enterDataOnSplitAgencylevel("BatchPaymentEntries", "6.3");
		
		System.out.println("\n 13. Enter payemnt details on split Agency statement level");
		newpayment.enterDataOnSplitAgencyStatementlevel("BatchPaymentEntries", "6.4");
		
		System.out.println("\n 14. Enter payemnt details on split Agency DB commissions level");
		newpayment.enterDataOnSplitDBCommissionslevel("BatchPaymentEntries", "6.5"); */
		
		System.out.println("\n 15. Enter the Total Amount in Batch Amount and Save the Batch Number");
		newpayment.enterTotalAmountInBatchAmount();
		newpayment.batchNumber();
	
		System.out.println("\n 16. Click on Post Batch button");
		newpayment.clickNextBatchBtn();
		newpayment.clickPostbatchBtn();
		
		System.out.println("\n 17. Run the PostSurePathBatch job");
		newpayment.navigateBatchProcess();
		newpayment.clickRunBtn();
		
		System.out.println("\n 18. Navigate to the Desktop screen");
		newpayment.clickActionBtn();
		newpayment.clickreturnToBillingCenter(); 
		
		System.out.println("\n 19. Verify the Batch Number of posted payments on account level");
		newpayment.VerifyBatchNumberAccountLevel();
		
		System.out.println("\n 20. Verify the Batch Number and Check/Ref of posted payments on agency level");
		newpayment.VerifyBatchAndChkNumberAgencyLevel(); 
		
		//System.out.println("\n 21. Logout from BillingCenter");
		//newpayment.logout("qa1_bc");
		}
}