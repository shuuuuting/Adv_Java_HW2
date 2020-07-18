package list;

/**
 *
 * @author borson
 * @param <T>
 */
public class LinkedList<T> implements List<T> {

	int count;
	Node<T> head;

	public LinkedList() {
		count = 0;
		head = null;
	}

	public Node<T> getHead() {
		return head;
	}

	@Override
        @SuppressWarnings("empty-statement")
	public boolean insert(int index, T newEntry) {
		if (index < 0 || index > count) {
			return false;
		}
		if (index == 0) {
			Node<T> newNode = new Node(newEntry, head);
			head = newNode;
			count++;
			return true;
		}
		Node<T> node = head;
		for (int i = 0; i < index - 1; i++, node = node.next); 
		//insert at index
		Node<T> newNode = new Node(newEntry, node.next);
		node.next = newNode;
		count++;
		return true;
	}

	@Override
	public boolean add(T newEntry) {
		return insert(count,  newEntry);
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= count) {
			return null;
		}
		Node<T> node = head, prev = null;
		for (int i = 0; i < index; i++, prev = node, node = node.next) {
		}
		if (node == head) {
			head = head.next; // head remvoed
		} else {
			prev.next = node.next;
		}
		count--;
		return node.data;
	}

	@Override
	public T get(int index) {
		Node<T> node = head;
		for (int i = 0; i < index; i++, node = node.next) {
		}
		return node.data;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public void forEach(Visit<T> visit) {
		for (Node<T> node = head; node != null; node = node.next) {
			visit.todo(node.data);
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Node<T> node = head; node != null; node = node.next) {
			if (node != head) {
				s.append(", ");
			}
			s.append(node.toString());
		}
		return s.toString();
	}

	@Override
	public boolean isFull() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
