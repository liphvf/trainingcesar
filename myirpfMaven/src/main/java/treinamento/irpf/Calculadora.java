package treinamento.irpf;

public class Calculadora {

	public Calculadora(Tabela tabela) {

		this.tabela = tabela;
	
	}
	
	private Tabela tabela;


	public double calculaIrpf(double base) {
		
		//testar o metodo sem precisar implementar a aliquota e a base
		double aliquota = tabela.buscaAliquota(base);
		double parcela = tabela.buscaParcela(base);

		return (base * aliquota / 100) - parcela;
	}

}
