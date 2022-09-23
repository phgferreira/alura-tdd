package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService servico = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("25000"));
		
		//assertThrows( IllegalArgumentException.class, () -> servico.calcularBonus(funcionario) );
		
		// Dessa segunda forma estamos indo um pouco além e verificando também a mensagem da excessão
		try {
			servico.calcularBonus(funcionario);
			fail("Não entrou no catch");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Funcionário com salário maior que R$10.000 não pode receber o bônus");
		}

	}
	
	@Test
	void bonusDeveriaSerDezPorcentoDoSalario() {
		BonusService servico = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("2500"));
		BigDecimal bonus = servico.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeExatamenteDezMilReais() {
		BonusService servico = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("1000"));
		BigDecimal bonus = servico.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("100.00"), bonus);
	}

}
