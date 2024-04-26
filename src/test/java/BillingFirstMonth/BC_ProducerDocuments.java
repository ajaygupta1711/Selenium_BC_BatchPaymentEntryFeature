package BillingFirstMonth;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import BillingTests.BaseTestBilling;
import billingCenter.BCBatchProcessInfo;
import billingCenter.BCDocuments;
import billingCenter.BCProducer;
import commonGuidewire.BasePageBillingCenter;

public class BC_ProducerDocuments extends BaseTestBilling {
	@Test
	public void BC_ProducerDocuments() {
		String sheetName = "ProducerDocs";
		String agent = reader.getCellData(sheetName, 1, 0);

		try {
			BasePageBillingCenter billingCenter = new BasePageBillingCenter(driver,wait);
			BCBatchProcessInfo batchProcess = new BCBatchProcessInfo(driver,wait);
			BCProducer producer = new BCProducer(driver,wait);	
			BCDocuments documents = new BCDocuments(driver,wait);	

			loginToEnvironment(environment);

			//billingCenter.navigateBatchProcess();
			//batchProcess.actionRunBtn("???");

			billingCenter.searchMenuProducers();
			producer.enterAgencyCode(agent);
			producer.clickProducerSearch();
			producer.clickFirstAgency();
			billingCenter.navigatingToProducerDocuments();
			documents.selectFolder("Agency Statements");
			documents.selectDescription("Direct Bill Statement");
			documents.clickDocSearch();
			documents.sortByUploadDate();
			documents.sortByUploadDate();
			documents.downloadDocument("PDF");
			

			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue("Test Execution Failed.", false);
		}



	}
}
