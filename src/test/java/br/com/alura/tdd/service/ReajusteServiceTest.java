package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeAll
	static void initOfAll() {
		System.out.println("ANTES DE TODOS");
	}
	
	@BeforeEach
	void init() {
		System.out.println("INICIO");
		service = new ReajusteService();
		funcionario = new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	void end() {
		System.out.println("FIM");
	}
	
	@AfterAll
	static void endOfAll() {
		System.out.println("DEPOIS DE TODOS");
	}

	@Test
	void reajusteDeveSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveSerDeQuarentaPorcentoQuandoDesempenhoForExceptional() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
