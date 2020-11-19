package br.luiz.appium.srbarriga.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.luiz.appium.core.BaseTest;
import br.luiz.appium.page.MenuPage;
import br.luiz.appium.srbarriga.page.ContasPage;
import br.luiz.appium.srbarriga.page.MovPage;
import br.luiz.appium.srbarriga.page.ResumoPage;
import br.luiz.appium.srbarriga.page.SBLoginPage;
import br.luiz.appium.srbarriga.page.SBHomePage;

public class SBTest extends BaseTest{
	
	private SBLoginPage login = new SBLoginPage();
	private MenuPage menu = new MenuPage();
	private ContasPage conta = new ContasPage();
	private SBHomePage home = new SBHomePage();
	private MovPage mov = new MovPage();
	private ResumoPage res = new ResumoPage();
	
	@Before
	public void login() {
		menu.clickByText("SeuBarriga Nativo");
		login.setLogin();
		login.setSenha();
		login.entrar();
		Assert.assertTrue(login.isExisteElementoPorTexto("RESET"));
		home.reset();
		Assert.assertTrue(login.isExisteElementoPorTexto("Dados resetados com sucesso!"));
		
	}
	
	@Test
	public void cadastarConta() {
		home.accessContas();
		conta.setConta();
		conta.salvar();
		Assert.assertTrue(conta.isExisteElementoPorTexto("Conta adicionada com sucesso"));
		
	}
	
	@Test
	public void excluirConta() {
		home.accessContas();
		conta.cliqueLongoContaMesmoNome();
		conta.clickarExcluir();
		Assert.assertTrue(conta.isExisteElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void validarMovimentacao() {
		home.accessMov();
		mov.setDescricao();
		mov.setInteressado();
		mov.setValor();
		mov.clicarSwitch();
		mov.cliqueSelecionarConta();
		mov.clicarContaMesmoNome();
		mov.salvar();
		Assert.assertTrue(conta.isExisteElementoPorTexto("Movimentação cadastrada com sucesso"));
		
	}
	
	@Test
	public void validarResumo() {
		home.accessResumo();
		res.swipeCalculo();
		res.cliqueDel();
		res.cliqueAtualizar();
		
	}

}
