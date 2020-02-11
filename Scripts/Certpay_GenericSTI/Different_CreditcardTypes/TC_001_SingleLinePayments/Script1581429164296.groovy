import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import org.openqa.selenium.Keys as Keys

ExcelData data = findTestData('Data Files/Certpay/CardTypes_SingleLinePayment')

for (def index : (1..data.getRowNumbers())) {
	
	FirstName=data.getValue('FirstName', index)
	
	LastName=data.getValue('LastName', index)
	
	Amount=data.getValue('Amount', index)
	
	cardNum = data.getValue('CardNumber', index)

	expMonth = data.getValue('ExpMonth', index)

	expYear = data.getValue('ExpYear', index)

	securityCode = data.getValue('SecurityCode', index)

	cardType = data.getValue('CardType', index)
	
	Comments= data.getValue('Comments', index)
	
	Address1=data.getValue('Address1', index)
	
	Address2=data.getValue('Address2', index)
	
	City=data.getValue('City', index)
	
	State=data.getValue('State', index)
	
	Postal=data.getValue('Postal', index)
	
	Telephone=data.getValue('Telephone', index)
	
	Email=data.getValue('EmailAddress', index)
	
	AccountType=data.getValue('AccountType', index)
	
	RoutingNumber=data.getValue('RoutingNumber', index)
	
		
	AccountNumber=data.getValue('AccountNumber', index)
	
	ConfirmAccountNumber=data.getValue('ConfirmAccountNumber', index)
	
	Signature=data.getValue('Signature', index)
	
	Agreement=data.getValue('Agreement', index)
	
	'Open Certpay Genericsti application'
	CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.Genericsti_url, (([GlobalVariable.pageLoadTime]) as int[]))

	'Click on \'Demo pages\''
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Demo_Pages/BEGIN_PAYMENT'), 'Begin Payment',
			(([GlobalVariable.pageLoadTime]) as int[]))

	'Create XML'
	
	XMLString=CustomKeywords.'utilities.SafeActions.CreateXML'(FirstName,LastName,Amount,Address1,Address2,City,State,Postal,Email,Telephone)
	
	
	
	'Enter XML'
	CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/XML_Page/XML'), XMLString,'XMLContent', (([GlobalVariable.pageLoadTime]) as int[]))

	
	'Click on \'Submit XML\''
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/XML_Page/SUBMIT'), 'Submit XML',
			(([GlobalVariable.pageLoadTime]) as int[]))

	if(cardType=='Visa')
	{
	'Click on \'VISA CARD\''
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/VISA'),
		'VISA Card', (([GlobalVariable.pageLoadTime]) as int[]))
	}
	else if(cardType=='MasterCard')
	{
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/MASTER_CARD'),
			'Master Card', (([GlobalVariable.pageLoadTime]) as int[]))
	}
	else if(cardType=='AmericanExpress')
	{
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/AMERICAN_EXPRESS'),
			'AmericanExpress', (([GlobalVariable.pageLoadTime]) as int[]))
	}
	else if(cardType=='Discover')
	{
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/DISCOVER'),
			'Discover', (([GlobalVariable.pageLoadTime]) as int[]))
	}
	
	else if(cardType=='Echeck')
	{
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/ECHECK'),
			'Echeck', (([GlobalVariable.pageLoadTime]) as int[]))
		
		
		
		
	}
	

	'Enter Comments'
	CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/COMMENTS'), 'Testing',
		'Comments', (([GlobalVariable.pageLoadTime]) as int[]))
	
	if(cardType=='Echeck')
	{
	
		if(AccountType=='Checking')
		{
			CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/ECHECK_CHECKING'),
				'Echeck Checking', (([GlobalVariable.pageLoadTime]) as int[]))
		}
		else if(AccountType=='Savings')
		{
			CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/ECHECK_SAVINGS'),
				'Echeck Savings', (([GlobalVariable.pageLoadTime]) as int[]))
		}
		'Enter RoutingNumber'
		CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/ROUTING_NUMBER'), RoutingNumber,
			'Routing Number', (([GlobalVariable.pageLoadTime]) as int[]))
		
		
		
		'Click BankName'
		
		WebUI.sendKeys(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/BANK_NAME'), Keys.chord(Keys.TAB))
		
		'Enter AccountNumber'
		
		CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/ACCOUNT_NUMBER'), AccountNumber,
			'Account Number', (([GlobalVariable.pageLoadTime]) as int[]))
		
		'Enter ConfirmAccountNumber'
		CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/CONFIRM_ACCOUNT_NUMBER'), ConfirmAccountNumber,
			'ConfirmAccountNumber', (([GlobalVariable.pageLoadTime]) as int[]))
		
		'Enter Signature'
		CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/SIGNATURE'), Signature,
			'Signature', (([GlobalVariable.pageLoadTime]) as int[]))
		
		'Enter Agreement'
		CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/AGREEMENT'), Agreement,
			'Agreement', (([GlobalVariable.pageLoadTime]) as int[]))
		
		'Click on \'Next\''
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/ECHECK_NEXT'),
			'Next', (([GlobalVariable.pageLoadTime]) as int[]))
		
		'Click on \'Accept\''
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Confirm_Payment_Page/ECHECK_ACCEPT'),
			'Accept', (([GlobalVariable.pageLoadTime]) as int[]))
		
		
	}
	else
	{
		'Enter card number'
		CardNumber = CustomKeywords.'pages.Genericsti.setUserPaymentDetails'(cardNum)
	
		'ENter exp date,security code'
		CustomKeywords.'pages.Genericsti.setExpDate'(expMonth, expYear, securityCode)
		'Click on \'Next\''
		CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/NEXT'),
			'Next', (([GlobalVariable.pageLoadTime]) as int[]))
	
		}
	
	'Click on \'Process Payment\''
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Review_Payment_Page/PROCESS_PAYMENT'),
		'Process payment', (([GlobalVariable.pageLoadTime]) as int[]))
	
	
	'Click on \'Confirm Payment\''
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Confirm_Payment_Page/CONFIRM_YES'),
		'Confirm Yes', (([GlobalVariable.pageLoadTime]) as int[]))
	
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Details_Verification_Page/NEXT'),
		'Next', (([GlobalVariable.pageLoadTime]) as int[]))
	
	
}
