package br.bc.automacao.appium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import appium.core.DSL;
import appium.core.DriverFactory;
import pages.FormularioPage;
import pages.MenuPage;

public class FormularioTeste {

	private DSL dsl = new DSL();

	private MenuPage menu = new MenuPage();
	private FormularioPage formularioPage = new FormularioPage();

	@BeforeEach
	public void inicializarAppium() throws MalformedURLException, InterruptedException {
		Thread.sleep(4000);
		menu.acessarFormulario("Formulário");
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void preencherCampoTexto() {
		formularioPage.escreverNome("Wagner");

		assertEquals("Wagner", formularioPage.obterNome());
	}
	

	@Test
	public void interagirCombo() {
		
		formularioPage.selecionarCombos("Nintendo Switch");

		assertEquals("Nintendo Switch", formularioPage.obterValorDoCombo());
	}

	@Test
	public void interagirComSwitchECheckBox() {
		assertFalse(formularioPage.isCheckMarcked());
		assertTrue(formularioPage.isSwitchMarked());

		formularioPage.clicarCheckBox();
		formularioPage.clicarSwitch();

		assertTrue(formularioPage.isCheckMarcked());
		assertFalse(formularioPage.isSwitchMarked());
	}

	@Test
	public void deveRealizarCadastro() {

		formularioPage.escreverNome("Wagner");
		formularioPage.clicarCheckBox();
		formularioPage.clicarSwitch();
		formularioPage.selecionarCombos("Nintendo Switch");

		dsl.clicar(By.xpath("//*[@text='SALVAR']"));

		assertEquals("Nome: Wagner", formularioPage.obterNomeCadastrado());

		assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));

		assertTrue(formularioPage.obterConsoleCadastrado().endsWith("switch"));

		assertTrue(formularioPage.obterCheckCadastrado().endsWith("Marcado"));

	}
}
