import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.fge.jsonschema.library.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat
import java.util.Date
import org.openqa.selenium.ElementNotInteractableException
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser("")

WebUI.navigateToUrl("https://www.cermati.com/app/gabung")

//WebUI.maximizeWindow() uncomment jika butuh layar dimaximize

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_No. Handphone_mobilePhone"), "JUJUII")//Negativ no HP isi angka

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_Email_email"), "malik96ka@gmail.com")

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_Nama Depan_firstName"), "Abdul")

WebUI.setText(findTestObject("Object Repository/Page_Daftar/input_Nama Belakang_lastName"), "Malik")

TestObject tombolDaftar = findTestObject("Object Repository/Page_Daftar/button_Daftar")

verif=false

while (verif==false) {
	verif = WebUI.verifyTextPresent("Input wajib diisi", false, FailureHandling.OPTIONAL)// tanda berarti gagal sesuai test case
}

verifSalah = WebUI.verifyTextPresent("Verifikasi No. Handphone", false, FailureHandling.OPTIONAL)// verify jangan sampai berhasil register, jika berhasil maka test case ini gagal

if (verif&&!verifSalah) {
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date())
String fileCapturePath = "C:\\Users\\malik\\Documents\\Lamaran new\\Indo Dana\\Capture\\Capture_Positive_${timestamp}.png" // mohon ubah bagian ini menjadi path yang diinginkan, maka akan tercapture secara otomatis
WebUI.takeScreenshot(fileCapturePath, FailureHandling.STOP_ON_FAILURE)
KeywordUtil.markPassed("Sudah sesuai dengan test case")
}


