package v2;

class ClienteNodo {
	private ClienteNodo enlace;
	private int prioridad;  
	private Object valor;

	public ClienteNodo getEnlace() {
		return enlace;
	}

	public void setEnlace(ClienteNodo enlace) {
		this.enlace = enlace;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
}
