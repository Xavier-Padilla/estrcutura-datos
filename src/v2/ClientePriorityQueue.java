package v2;
public class ClientePriorityQueue {
    private ClienteNodo front;
    private ClienteNodo rear;
    private int size;

    public ClientePriorityQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Object value, int prioridad) {
        ClienteNodo n = new ClienteNodo();
        n.setValor(value);
        n.setPrioridad(prioridad);

        if (isEmpty()) {
            front = n;
            rear = n;
        } else {
            if (prioridad < front.getPrioridad()) {
                n.setEnlace(front);
                front = n;
            } else {
                ClienteNodo actual = front;
                while (actual.getEnlace() != null && actual.getEnlace().getPrioridad() <= prioridad) {
                    actual = actual.getEnlace();
                }
                n.setEnlace(actual.getEnlace());
                actual.setEnlace(n);
                if (n.getEnlace() == null) {
                    rear = n;
                }
            }
        }
        size++;
    }

    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            size--;
            value = front.getValor();
            front = front.getEnlace();
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ClienteNodo temp = front;
        while (temp != null) {
            s.append("<").append(temp.getValor()).append(" (Prioridad: ").append(temp.getPrioridad()).append(")");
            temp = temp.getEnlace();
        }
        return s.toString();
    }
}
