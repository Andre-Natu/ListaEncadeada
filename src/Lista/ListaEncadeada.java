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
		posicaoCelula--;

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

	public void adicionarElemento(T elemento) {

		Celula<T> novaCelula = new Celula<T>(elemento);

		if (tamanhoLista == 0) {
			inicioLista = novaCelula;
		} else {
			ultimaCelula.setProximaCelula(novaCelula);
		}
		ultimaCelula = novaCelula;
		tamanhoLista++;

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

		System.out.println("\nA lista foi esvaziada.");

	}
}
