package pages;

import org.openqa.selenium.By;

import appium.core.DSL;
import io.appium.java_client.AppiumBy;

public class FormularioPage {

	DSL dsl = new DSL();

	public void escreverNome(String nome) {
		dsl.escrever(AppiumBy.accessibilityId("nome"), nome);
	}

	public String obterNome() {
		return dsl.obterTexto(AppiumBy.accessibilityId("nome"));

	}

	public void selecionarCombos(String nome) {
		dsl.selecionarCombos(AppiumBy.accessibilityId("console"), nome);
	}


	public String obterValorDoCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheckBox() {
		 dsl.clicar(By.className("android.widget.CheckBox"));

	}

	public void clicarSwitch() {
		 dsl.clicar(AppiumBy.accessibilityId("switch"));
	}
	
	public boolean isCheckMarcked() {
		return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));		
	}
	
	public boolean isSwitchMarked() {
		return dsl.isCheckMarcado(AppiumBy.accessibilityId("switch"));		
	}
	
	public void salvar() {
		 dsl.clicar(By.xpath("//*[@text='SALVAR']"));
	}
	
	public String obterNomeCadastrado() {
	    return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String obterConsoleCadastrado() {
	    return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}

	public String obterCheckCadastrado() {
	    return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}

	public String obterSwitchCadastrado() {
	    return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}


	
	

}
