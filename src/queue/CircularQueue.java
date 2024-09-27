package queue;

public class CircularQueue {
	private int f;
	private int r;
	private Object[] queue;
	private int size;

	public CircularQueue(int size) {
		f = 0;
		r = 0;
		queue = new Object[size];
		this.size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Boolean isFull() {
		return size == queue.length;
	}

// Size
	public int size() {
		return size;
	}

	public void enqueue(Object value) {
		if (!isFull()) {
			queue[f] = value;
			f++;
			size++;
			if (f == queue.length) {
				f = 0;

			}
		}
	}

	public Object dequeue() {
		Object value = null;
		if (!isEmpty()) {
			value = queue[r];
			queue[r] = null;
			r++;
			size--;
			if (r == queue.length) {
				r = 0;
			}

		}
		return value;
	}

	public Object front() {
		Object value = null;
		if (!isEmpty()) {
			int temp = f - 1;
			temp = temp == -1 ? queue.length - 1 : temp;
			value = queue[temp];
		}
		return value;
	}

	public Object rear() {
		Object value = null;
		if (!isEmpty()) {
			value = queue[r];
		}
		return value;
	}

	public String toString() {
		String s = " ";
		for(int i=0; i<size; i++) {
			int temp = i+r;
			temp = temp == queue.length-1 ? 0 : temp;
			s+= queue[temp] + " > ";
		}
		return s;
	}
	
}
