package treinamento.irpf;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import treinamento.irpf.Calculadora;

public class TestCalculadora {

	private static final double UM_CENTAVO = 0.01;

	@Test
	public void test() {

		// Class<Tabela> x = Tabela.class;

		Tabela tabela = EasyMock.createMock(Tabela.class);

		EasyMock.expect(tabela.buscaAliquota(30000)).andReturn(7.5);
		// se compara ao assert, o andReturn(7.5) diz que quero que retorne 7.5
		// se a aliquota for 30000
		

		EasyMock.expect(tabela.buscaParcela(30000)).andReturn(1608.99);
		// até agora o mock só está gravando o comportamento

		EasyMock.replay(tabela);
		// começa o test

		// você é obrigado a dizer como ele vai ser comportar em todos os
		// metodos.

		// o easymock subistitui a criação de uma classe que extends tabela.

		// Tabela tabela = new TabelaTeste();
		// reclama porque tabela test não é uma tabela, por isso lá em baixo ta
		// extends

		Calculadora calculadora = new Calculadora(tabela);

		double esperado = 641.01;
		// separador de decimal é o ponto "."

		double calculado = calculadora.calculaIrpf(30000.00);

		// precisa conhecer uma entrada e saida. para que ao der aquela entrada
		// e aquela saida batam.

		Assert.assertEquals(esperado, calculado, UM_CENTAVO);

		// java.lang.AssertionError: Use assertEquals(expected, actual, delta)
		// to compare floating-point numbers
		// se for trabalhar com o double tem que ter o (esperado, atual, e a
		// precisão que esperando) nessa caso 0,01 pois não podemos cobrar menos
		// de 1 centavo

		// fail("Not yet implemented");

		EasyMock.verify(tabela);
		// verifica se todos os metodos foram executados mesmo, pois se o valor
		// for setado manualmente, ele pode passar sem verificar. Isso é
		// importante pois garante a integridade do test

	}
	
	@Test
	public void Faixa0 () {
		Tabela tabela = EasyMock.createMock(Tabela.class);
		
		EasyMock.expect(tabela.buscaAliquota(21453.23)).andReturn(0.0);
		EasyMock.expect(tabela.buscaParcela(21453.23)).andReturn(0.0);
		EasyMock.replay();
		EasyMock.verify();
		
	}
	
	@Test
	public void Faixa1 () {
		Tabela tabela = EasyMock.createMock(Tabela.class);
		
		EasyMock.expect(tabela.buscaAliquota(21453.24)).andReturn(0.0);
		EasyMock.expect(tabela.buscaParcela(21453.24)).andReturn(0.0);
		EasyMock.replay();
		EasyMock.verify();
		
	}
	@Test
	public void Faixa2 () {
		Tabela tabela = EasyMock.createMock(Tabela.class);
		
		EasyMock.expect(tabela.buscaAliquota(32151.49)).andReturn(0.0);
		EasyMock.expect(tabela.buscaParcela(32151.49)).andReturn(0.0);
		EasyMock.replay();
		EasyMock.verify();
		
	}
	

//	class TabelaTeste extends Tabela {
//		// TABELA TEST SERIA UM MOCKS, QUE SIMULA O COMPORTAMENTO DE UMA TABELA
//		// EM UMA SITUAÇÃO ESPECIAL, PARA QUE ASSIM POSSA SER FEITO UM TEST
//		// UNITÁRIO
//
//		public TabelaTeste(double aliquota, double parcela) {
//			super(aliquota, parcela);
//			// TODO Auto-generated constructor stub
//		}
//
//		@Override
//		public double buscaAliquota(double base) {
//
//			return 7.5;
//		}
//
//		@Override
//		public double buscaParcela(double base) {
//
//			return 1608.99;
//		}
//
//	}

}

// criei a calculadora,
// criei a tabela
// criei os metodos
// esse metodo serve para obter independencia, pois se 2 programadores podem
// fazer cada teste isoladamente