/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal;



public class BooleanPriorityQueue {

	private BooleanNodo front;
	private BooleanNodo rear;
	private int size;

	public BooleanPriorityQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	public void enqueue(BooleanNodo n) {
		if (isEmpty()) {
			front = n;
			rear = n;
		} else {
			rear.setEnlace(n);
			rear = n;
		} // el que se mueve es el rear
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(Object value, Boolean prioridad) {

		BooleanNodo n = new BooleanNodo();
		n.setValor(value);
		n.setPrioridad(prioridad);
		if (isEmpty()) {
			front = n;
			rear = n;
		} else {
			if (!prioridad || rear.getPrioridad()) {
				enqueue(n);
			} else {
				BooleanNodo actual = front;
				BooleanNodo siguiente = front.getEnlace();
				if (!front.getPrioridad()) {
					n.setEnlace(front);
					front = n;
				} else {
					while (null != siguiente) {
						if (!siguiente.getPrioridad()) {
							break;
						}
						actual = siguiente;
						siguiente = siguiente.getEnlace();

					}
					actual.setEnlace(n);
					n.setEnlace(siguiente);
				}
				

			}
			
		}size++;
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
		String s = " ";
		BooleanNodo temp = front;
		while (null != temp) {
			s += "<" + temp.getValor();
			temp = temp.getEnlace();
		}
		return s;
	}

}