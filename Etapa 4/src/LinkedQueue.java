
public class LinkedQueue<E> implements Queue<E> {
	private Node<E> head;
	private Node<E> tail;
	private int numElements;
	
	public LinkedQueue() {
		this.head = null;
		this.tail = null;
		this.numElements = 0;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public boolean isFull() {
		return false;
	}
	public int numElements() {
		return numElements;
	}
	public void enqueue(E element) {
		Node<E> newNode = new Node<>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		numElements++;	
	}
	public E dequeue() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();

		E element = head.getElement();

		if (head == tail) {
			head = tail = null;
		}
		else {
			head = head.getNext();
		}	

		numElements--;
		return element;
	}
	public E front() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		return head.getElement();
	}
	public E back() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		return tail.getElement();
	}
	public String toString() {
		String s = "";

		Node<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + ", ";
			current = current.getNext();
		}
		return s;
	}
}
