package java3.module9; 
public class LinkedList<E> {

    private class Node {
        private E data;
        private Node next;
        private Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;
    private final Class<E> type;

    public LinkedList(Class<E> type){
        head = null;
        size = 0;
        this.type = type;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void add(int index, E data){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        if (index == 0){
            head = new Node(data, head);
            size++;
            return;
        }
        Node pointer = head;
        for (int i = 0; i < index - 1; i++){
            pointer = pointer.next;
        }
        Node newNode = new Node(data, pointer.next);
        pointer.next = newNode;
        size++;
    }
    
    public void add(E data){
        add(size - 1, data);
    }

    public boolean contains(Object o){
        if (indexOf(o)==-1)
            return false;
        return true;
    }
   
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node pointer = head;
        for (int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        return pointer.data;
    }

    public int indexOf(Object o){
        Node pointer = head;
        if (o == null){
            for (int i = 0; i < size; i++){
                if (pointer.data == null)
                    return i;
                pointer = pointer.next;
            }
            return -1;
        }

        if (type.isInstance(o)){
            for (int i = 0; i < size; i++){
                if (pointer.data.equals(o))
                    return i;
                pointer = pointer.next;
            }
            return -1;
        }

        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        E removedData;
        if (index==0){
            removedData=head.data;
            head=head.next;
            size--;
            return removedData;
        }
        Node pointer = head;
        for (int i = 0; i < index-1; i++){
            pointer = pointer.next;
        }
        removedData=pointer.next.data;
        pointer.next=pointer.next.next;
        size--;
        return removedData;
    }

    public boolean remove(Object o){
        if (isEmpty())
            return false;
        Node pointer = head;
        if (o == null){
            if (pointer.data == null){
                head=head.next;
                size--;
                return true;
            }
            for (int i = 0; i < size-1; i++){
                if (pointer.next.data == null){
                    pointer.next=pointer.next.next;
                    size--;
                    return true;
                }
                pointer = pointer.next;
            }
            return false;
        }

        if (type.isInstance(o)){
            if (pointer.data.equals(o)){
                head=head.next;
                size--;
                return true;
            }
            for (int i = 0; i < size-1; i++){
                if (pointer.next.data.equals(o)){
                    pointer.next=pointer.next.next;
                    size--;
                    return true;
                }
                pointer = pointer.next;
            }
            return false;
        }

        return false;
    }

    public E set(int index, E newData){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node pointer = head;
        for (int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        E oldData = pointer.data;
        pointer.data = newData;
        return oldData;
    }

    public String toString(){
        String text = "[";
        Node pointer = head;
        for (int i = 0; i < size; i++){
            if (i == 0)
                text += String.valueOf(pointer.data);
            else
                text += ", " + String.valueOf(pointer.data);
            pointer = pointer.next;
        }
        text += "]";
        return text;
    }

    public boolean equals(Object o){
        if (!(o instanceof LinkedList)){
            return false;
        }
        LinkedList<?> otherList = (LinkedList<?>) o;
        if (size != otherList.size){
            return false;
        }
        Node pointer = head;
        LinkedList<?>.Node otherPointer = otherList.head;
        for (int i = 0; i < size; i++){
            if (pointer.data == null){
                if (otherPointer.data == null)
                    return true;
                return false;
            }
            if (!(pointer.data.equals(otherPointer.data)))
                return false;
            pointer = pointer.next;
            otherPointer = otherPointer.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Unit tests for equals(Object o)
        LinkedList<String> listA = new LinkedList<>(String.class);
        LinkedList<String> listB = new LinkedList<>(String.class);
        LinkedList<String> listC = new LinkedList<>(String.class);

        // Test 1: Both empty lists
        System.out.println("Equals Test 1 (empty lists): " + (listA.equals(listB) == true));

        // Test 2: One empty, one non-empty
        listA.add(0, "A");
        System.out.println("Equals Test 2 (one empty, one non-empty): " + (listA.equals(listB) == false));

        // Test 3: Same elements, same order
        listB.add(0, "A");
        System.out.println("Equals Test 3 (same elements): " + (listA.equals(listB) == true));

        // Test 4: Same elements, different order
        listA.add(1, "B");
        listB.add(1, "C");
        System.out.println("Equals Test 4 (different order): " + (listA.equals(listB) == false));

        // Test 5: Same elements, same order
        listB.set(1, "B");
        System.out.println("Equals Test 5 (same elements, same order): " + (listA.equals(listB) == true));

        // Test 6: Different sizes
        listC.add(0, "A");
        System.out.println("Equals Test 6 (different sizes): " + (listA.equals(listC) == false));

        // Test 7: Null elements
        LinkedList<String> listD = new LinkedList<>(String.class);
        LinkedList<String> listE = new LinkedList<>(String.class);
        listD.add(0, null);
        listE.add(0, null);
        System.out.println("Equals Test 7 (null elements): " + (listD.equals(listE) == true));

        // Test 8: Compare to non-LinkedList object
        System.out.println("Equals Test 8 (non-LinkedList): " + (listA.equals("not a list") == false));
    }
}
