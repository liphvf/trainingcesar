package treinamento.irpf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NewCalculadora {

	public NewCalculadora() {

	}

	private double base;

	Tabela tabela = new Tabela(base);

	Calculadora calculadora = new Calculadora(tabela);

	private double calc;

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getCalc() {
		return calc = calculadora.calculaIrpf(base);
	}

	public void setCalc(double calc) {
		this.calc = calc;
	}

	public void saveCalc() {
	//	calc = calculadora.calculaIrpf(base);
		System.out.println();
	}

}
