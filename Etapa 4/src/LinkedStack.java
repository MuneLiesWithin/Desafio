
public class LinkedStack<E> implements Stack<E> {
	private Node<E> head;
	private Node<E> tail;
	private int numElements;
	
	public LinkedStack() {
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
	public void push(E element) {
		Node<E> newNode = new Node<>(element);
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		numElements++;
	}
	public E pop() throws UnderflowException{
		if(isEmpty()) throw new UnderflowException();
		E element = tail.getElement();

		if (head == tail) {
			head = tail = null;
		}
		else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			tail = current;
			current.setNext(null);
		}
		numElements--;
		return element;
	}
	public E top() throws UnderflowException{
		if(isEmpty()) throw new UnderflowException();
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
