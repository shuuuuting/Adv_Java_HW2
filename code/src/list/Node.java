
package list;

/**
 *
 * @author borson
 */
public class Node<T> {

	T data;
	Node next,prev;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
        public Node(T data){
            this.data=data;
        }

	public String toString() {
		return data.toString();
	}
}
