package treinamento.irpf;

public class Tabela {

	public Tabela(double base) {
		this.aliquota = buscaAliquota(base);
		this.parcela = buscaParcela(base);

	}

	private double aliquota;
	private double parcela;

	public double buscaAliquota(double base) {

		if (base < 21453.24) {
			return 0;

		} else if (base > 21453.24 && base < 32151.49) {
			return 7.5;

		} else if (base > 32151.49 && base < 42869.17) {
			return 15.0;

		} else if (base > 42869.17 && base < 53565.73) {
			return 22.5;

		} else if (base > 53565.73) {
			return 27.5;

		}

		return 0;
	}

	public double buscaParcela(double base) {

		if (base < 21453.24) {
			return 0;

		} else if (base > 21453.24 && base < 32151.49) {
			return 1608.99;

		} else if (base > 32151.49 && base < 42869.17) {
			return 4020.35;

		} else if (base > 42869.17 && base < 53565.73) {
			return 7235.54;

		} else if (base > 53565.73) {
			return 9913.83;

		}

		return 0;
	}

}
