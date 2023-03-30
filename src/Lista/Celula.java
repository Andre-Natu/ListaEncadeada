package Lista;

public class Celula<T> {

	private T elemento;
	private Celula<T> proximaCelula;

	public Celula(T elemento) {
		this.elemento = elemento;
		this.proximaCelula = null;
	}

	public Celula(T elemento, T proximo) {
		this.elemento = elemento;
		this.proximaCelula = null;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Celula<T> getProximaCelula() {
		return proximaCelula;
	}

	public void setProximaCelula(Celula<T> proximaCelula) {
		this.proximaCelula = proximaCelula;
	}

}
