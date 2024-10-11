package nodo;
import java.time.LocalDate;

class DateNodo {
    private Object valor;
    private LocalDate prioridad;
    private DateNodo enlace;

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public LocalDate getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(LocalDate prioridad) {
        this.prioridad = prioridad;
    }

    public DateNodo getEnlace() {
        return enlace;
    }

    public void setEnlace(DateNodo enlace) {
        this.enlace = enlace;
    }
}