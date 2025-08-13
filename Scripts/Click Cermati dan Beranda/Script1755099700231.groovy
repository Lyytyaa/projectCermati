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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat
import java.util.Date

WebUI.openBrowser("")

WebUI.navigateToUrl("https://www.cermati.com/app/gabung")

WebUI.maximizeWindow() //uncomment jika butuh layar dimaximize

WebUI.click(findTestObject("Object Repository/Page_Daftar/div_rukoProduk"))

verif=false

while (verif==false) {
	verif = WebUI.verifyTextPresent("Laporan Kredit", false, FailureHandling.OPTIONAL)// tanda berarti berhasil
}

WebUI.navigateToUrl("https://www.cermati.com/app/gabung")

WebUI.click(findTestObject("Object Repository/Page_Daftar/img_Download App_Logo_wrapper__img__wVzd5"))

verif2=false

while (verif2==false) {
	verif2 = WebUI.verifyTextPresent("Laporan Kredit", false, FailureHandling.OPTIONAL)// tanda berarti berhasil
}

if (verif&&verif2) {
	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date())
	String fileCapturePath = "C:\\Users\\malik\\Documents\\Lamaran new\\Indo Dana\\Capture\\Capture_Click_Cermati_dan_Beranda_${timestamp}.png" //mohon ubah bagian ini menjadi path yang diinginkan, maka akan tercapture secara otomatis
	WebUI.takeScreenshot(fileCapturePath, FailureHandling.OPTIONAL)
	}