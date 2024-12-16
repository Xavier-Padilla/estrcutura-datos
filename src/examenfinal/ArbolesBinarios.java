package examenfinal;



public class ArbolesBinarios {
    /*
    R=raiz
    I=izquierda
    D=derecha

    Preorden  R I D
    Inorden   I R D
    Postorden I D R
    */
    private DoubleNodo raiz;

    public ArbolesBinarios() {
        raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public void add(Object value) {
        DoubleNodo nuevoNodo = new DoubleNodo();
        nuevoNodo.setValor(value);
        if (isEmpty()) {
            raiz = nuevoNodo;
        } else {
            add(nuevoNodo, raiz);
        }
    }

    private void add(DoubleNodo nuevoNodo, DoubleNodo nodoActual) {
        if ((int) nuevoNodo.getValor() > (int) nodoActual.getValor()) {
            if (nodoActual.getDerecho() == null) {
                nodoActual.setDerecho(nuevoNodo);
            } else {
                add(nuevoNodo, nodoActual.getDerecho());
            }
        } else {
            if (nodoActual.getIzquierda() == null) {
                nodoActual.setIzquierda(nuevoNodo);
            } else {
                add(nuevoNodo, nodoActual.getIzquierda());
            }
        }
    }

    // Preorden: R I D
    public void preorden() {
        preorden(raiz);
    }

    private void preorden(DoubleNodo nodoActual) {
        if (nodoActual != null) {
            System.out.println(nodoActual.getValor());
            preorden(nodoActual.getIzquierda());
            preorden(nodoActual.getDerecho());
        }
    }

    // Inorden: I R D
    public void inorden() {
        inorden(raiz);
    }

    private void inorden(DoubleNodo nodoActual) {
        if (nodoActual != null) {
            inorden(nodoActual.getIzquierda());
            System.out.println(nodoActual.getValor());
            inorden(nodoActual.getDerecho());
        }
    }

    // Postorden: I D R
    public void postorden() {
        postorden(raiz);
    }

    private void postorden(DoubleNodo nodoActual) {
        if (nodoActual != null) {
            postorden(nodoActual.getIzquierda());
            postorden(nodoActual.getDerecho());
            System.out.println(nodoActual.getValor());
        }
    }

    // Encuentra el valor más pequeño en el árbol
    public Object findMin() {
        if (isEmpty()) {
            return null;
        }
        DoubleNodo actual = raiz;
        while (actual.getIzquierda() != null) {
            actual = actual.getIzquierda();
        }
        return actual.getValor();
    }

    // Encuentra el valor más grande en el árbol
    public Object findMax() {
        if (isEmpty()) {
            return null;
        }
        DoubleNodo actual = raiz;
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho();
        }
        return actual.getValor();
    }
}
