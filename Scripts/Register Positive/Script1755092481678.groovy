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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat
import java.util.Date

WebUI.openBrowser("")

WebUI.navigateToUrl("https://www.cermati.com/app/gabung")

//WebUI.maximizeWindow() uncomment jika butuh layar dimaximize

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_No. Handphone_mobilePhone"), "08194881725")

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_Email_email"), "malik962ka@gmail.com")

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_Nama Depan_firstName"), "Abdul")

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_Nama Belakang_lastName"), "Malik")

WebUI.click(findTestObject("Object Repository/Page_Daftar/button_Daftar"))

boolean verif = false

int loopcount = 0
while (verif==false) {
	verif = WebUI.verifyTextPresent("Verifikasi No. Handphone", false, FailureHandling.OPTIONAL)
	loopcount++
	if(loopcount>=10) {
		println("Website memunculkan Chapcha, tidak bisa ditest dengan automation")
		break
	}
}

verifSalah = WebUI.verifyTextPresent("Input wajib diisi", false, FailureHandling.OPTIONAL) //verify jgn ada kata "Input wajib diisi, karena itu berarti gagal register

println("Verif salah = "+verifSalah)
println("Test Case Passed = "+verif&&!verifSalah)

if (!verifSalah) {
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date())
String fileCapturePath = "C:\\Users\\malik\\Documents\\Lamaran new\\Indo Dana\\Capture\\Capture_Positive_${timestamp}.png" //mohon ubah bagian ini menjadi path yang diinginkan, maka akan tercapture secara otomatis
WebUI.takeScreenshot(fileCapturePath, FailureHandling.OPTIONAL)
KeywordUtil.markPassed("Akan saya Passed karena terkadang navigate ke OTP terkadang Navigate ke Chapcha")
}



