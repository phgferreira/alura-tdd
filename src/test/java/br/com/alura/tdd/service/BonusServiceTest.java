package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService servico = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("25000"));
		
		assertThrows( IllegalArgumentException.class, () -> servico.calcularBonus(funcionario) );

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
