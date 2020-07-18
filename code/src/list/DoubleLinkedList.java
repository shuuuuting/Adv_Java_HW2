/*
 * B10433006_張舒婷
 */
package list;

/**
 *
 * @author zhangshuting
 * @param <T>
 */
public class DoubleLinkedList<T> implements List<T> {
    
        int count;
	Node<T> head,last;

	public DoubleLinkedList() {
		count = 0;
		head = null;
                last=null;
	}

	public Node<T> getHead() {
		return head;
	}

	@Override
        @SuppressWarnings("empty-statement")
	public boolean insert(int index, T newEntry) {
                Node<T> newNode = new Node(newEntry);
		if (index < 0 || index > count) {
		    return false;
		}
		if (index == 0) {
                    head = newNode;
                    last = head;
                    count++;
	            return true;
		}
                else if (index ==count){
                    last.next = newNode;
                    newNode.prev = last;
                    last = newNode;    
                    count++;
                    return true;
                }
                else {
                    Node<T> current = head;
                    for (int i = 0; i < index; i++) {
                        current = current.next;
                    }
                    Node<T> previous = current.prev;
                    previous.next = newNode;
                    newNode.prev = previous;
                    newNode.next = current;
                    current.prev = newNode;
                    count++;
                    return true;
                }
	}

	@Override
	public boolean add(T newEntry) {
		return insert(count,  newEntry);
	}

	@Override
	public  T remove(int index) {
		if (index < 0 || index >= count) {
			return null;
		}
                Node<T> current=head;
		for(int i =0;i<index;i++){
			current=current.next;
		}
		if(current==head){
                    if(count>1){
			current.next.prev=null;
			head=current.next;
			}
                    else{
                        current.next=null;
                    }
                }
                else{
                    current.prev.next=current.next;
                    current.next.prev=current.prev;
		}
		count--;
		return current.data;
                /*else if (index == 0) {
                    head.next.prev = null;
                    head = head.next;
                    count--;
                    return head.data;
                } 
                else if (index == count - 1) {
                    last = last.prev;
                    last.next = null;
                    count--;
                    return last.data;
                }
                else {
                    Node<T> current = head;
                    for (int i = 0; i < index; i++) {
                        current = current.next;
                    }
                    Node<T> previous = current.prev;
                    Node next = current.next;
                    previous.next = current.next;
                    next.prev = previous;
                    count--;
                    return current.data;
                }*/
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
