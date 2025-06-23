package appium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	private static AndroidDriver driver;

	public static AndroidDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	@SuppressWarnings("deprecation")
	private static void createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:deviceName", "emulator-5554");
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:appPackage", "com.ctappium");
		capabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");
		capabilities.setCapability("appium:autoGrantPermissions", true);
		capabilities.setCapability("appium:noReset", true);

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("URL do Appium está mal formada!", e);
		}
	}

	public static void killDriver() {
		if (driver != null) {
			System.out.println("Finalizando driver...");
			try {
				driver.terminateApp("com.ctappium"); // Fecha o app
				driver.quit(); // Encerra a sessão
			} catch (Exception e) {
				System.out.println("Erro ao finalizar driver:");
				e.printStackTrace();
			} finally {
				driver = null;
			}
		} else {
			System.out.println("Driver já está null, nada para finalizar.");
		}
	}
}
