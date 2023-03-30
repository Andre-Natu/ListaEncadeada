package Lista;

public class ListaEncadeada<T> {

	private Celula<T> inicioLista;
	private Celula<T> ultimaCelula;
	private int tamanhoLista = 0;

	public void criarLista() {
		tamanhoLista = 0;
		inicioLista = null;
		ultimaCelula = null;
	}

	public int getTamanho() {
		if (tamanhoLista == 0) {
			System.out.println("A lista está vazia.");
		}
		return tamanhoLista;
	}

	public Celula<T> obterCelula(int posicaoCelula) {
		Celula<T> auxiliar = inicioLista;

		if ((posicaoCelula < 0) || (posicaoCelula > tamanhoLista)) {
			System.out.println("Posição Inválida");
			return null;
		} else {
			for (int i = 0; i < posicaoCelula; i++) {
				auxiliar = auxiliar.getProximaCelula();
			}
		}
		return auxiliar;

	}

	public void modificarElemento(int posicaoCelula, T elemento) {
		Celula<T> auxiliar = obterCelula(posicaoCelula);

		auxiliar.setElemento(elemento);

	}

	public boolean adicionarCelula(int posicaoCelula, T elemento) {
		// testa para ver se a posição digitada é válida
		if ((posicaoCelula < 0) || (posicaoCelula > tamanhoLista)) {
			System.out.println("Posição Inválida");
			return false;
		}

		// testa para ver se a posição digitada está no começo ou no final da lista
		if (posicaoCelula == 0) {
			adicionarInicio(elemento);
			return true;
		}
		if (posicaoCelula == tamanhoLista) {
			adicionarFinal(elemento);
			return true;
		}

		// se a posição estiver no meio
		Celula<T> novaCelula = new Celula<T>(elemento);
		Celula<T> antigaCelula = obterCelula(posicaoCelula - 1);

		// troca o valor da proximaCelula para ser o da novaCelula e a
		// procimaCelula da celula antiga passa a apontar para a novaCelula.
		novaCelula.setProximaCelula(antigaCelula.getProximaCelula());
		antigaCelula.setProximaCelula(novaCelula);

		tamanhoLista++;
		return true;

	}

	public void adicionarInicio(T elemento) {
		Celula<T> novaCelula = new Celula<T>(elemento);

		if (tamanhoLista == 0) {
			inicioLista = novaCelula;
			ultimaCelula = novaCelula;
		} else {
			novaCelula.setProximaCelula(inicioLista);
			inicioLista = novaCelula;
		}
		tamanhoLista++;
	}

	public void adicionarFinal(T elemento) {
		Celula<T> novaCelula = new Celula<T>(elemento);

		if (tamanhoLista == 0) {
			inicioLista = novaCelula;
		} else {
			ultimaCelula.setProximaCelula(novaCelula);
		}
		ultimaCelula = novaCelula;
		tamanhoLista++;
	}

	public Celula<T> removerCelula(int posicaoCelula) {
		// testa para ver se a posição digitada é válida
		if ((posicaoCelula < 0) || (posicaoCelula > tamanhoLista)) {
			System.out.println("Posição Inválida");
			return null;
		}
		// testa para ver se a posição digitada está no começo ou no final da lista
		if (posicaoCelula == 0) {
			return removerInicio();
		}
		if (posicaoCelula == tamanhoLista - 1) {
			return removerFinal();
		}

		Celula<T> anteriorCelula = obterCelula(posicaoCelula - 1);
		Celula<T> atualCelula = anteriorCelula.getProximaCelula();

		anteriorCelula.setProximaCelula(atualCelula.getProximaCelula());
		atualCelula.setProximaCelula(null);
		tamanhoLista--;
		return atualCelula;
	}

	public Celula<T> removerInicio() {
		if (tamanhoLista == 0) {
			return null;
		}
		Celula<T> auxiliar = inicioLista;
		inicioLista = inicioLista.getProximaCelula();
		auxiliar.setProximaCelula(null);
		tamanhoLista--;
		if (tamanhoLista == 0) {
			ultimaCelula = null;
		}
		return auxiliar;
	}

	public Celula<T> removerFinal() {
		if (tamanhoLista == 0) {
			return null;
		}

		Celula<T> atualCelula = inicioLista;
		Celula<T> anteriorCelula = inicioLista;

		while (atualCelula.getProximaCelula() != null) {
			anteriorCelula = atualCelula;
			atualCelula = atualCelula.getProximaCelula();
		}
		ultimaCelula = anteriorCelula;
		ultimaCelula.setProximaCelula(null);
		atualCelula = null;
		tamanhoLista--;
		if (tamanhoLista == 0) {
			inicioLista = null;
			ultimaCelula = null;
		}
		return atualCelula;

	}

	public void visualisarLista() {

		if (tamanhoLista == 0) {
			System.out.println("\nA lista está vazia");
		} else {
			Celula<T> atualCelula = this.inicioLista;

			for (int i = 0; i < tamanhoLista; i++) {
				System.out.println("\nO valor do " + (i + 1) + "º elemento é: " + atualCelula.getElemento());
				atualCelula = atualCelula.getProximaCelula();
			}

		}

	}

	public void esvaziarLista() {
		Celula<T> atualCelula = this.inicioLista;
		Celula<T> auxiliar;

		while (atualCelula != null) {
			auxiliar = atualCelula.getProximaCelula();
			atualCelula.setElemento(null);
			atualCelula.setProximaCelula(null);
			atualCelula = auxiliar;
		}

		tamanhoLista = 0;
		ultimaCelula = null;
		inicioLista = null;

	}
}
