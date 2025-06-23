package pages;

import appium.core.DSL;

public class MenuPage {
	
	DSL dsl = new DSL();
	
	public void acessarFormulario(String texto) {
		dsl.clicarPorTexto(texto);
		
	}

}
