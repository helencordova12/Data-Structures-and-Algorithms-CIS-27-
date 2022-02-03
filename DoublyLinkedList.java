// UPDATED VERSION

public class DoublyLinkedList<T extends Comparable<T>> {

    private class Node {
        T data = null;
        Node next = null;
        Node prev = null;
    }

    Node first;
    Node last;

    public boolean listEmpty = true;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public String toString(){
        Node current = first.next;
        String data = "";

        if(listEmpty){
            return "No items in list";
        }

        if(first == last){
            return String.valueOf(first.data);
        }

        data += first.data + " ";

        while(current != last){
            data += String.valueOf(current.data) + " ";
            current = current.next;

            if(current == last){
                break;
            }
        }
        data += last.data;

        return data;
    }

    public boolean itemInList(T item){
        Node current = first;

        while(current != null){
            if(item.compareTo(current.data) == 0){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(T item){

        Node current = first;
        Node previous = null;

        if((item.compareTo(current.data) == 0) && (first == last)){
            Node newNode = new Node();
            first = newNode;
            last = newNode;
            first = null;
            last = null;
            listEmpty = true;

            return true;
        }

        if(item.compareTo(current.data) == 0){ //if item equals first.data
            first = current.next;
            first.prev = null;

            return true;
        }

        while(current != null && item.compareTo(current.data) != 0){
            previous = current;
            current = current.next;
        }

        if(current != null && item.compareTo(current.data) == 0 && current != last){ //if item equals any item in the list except for the first/last items
            previous.next = current.next;
            current.next.prev = previous;

            return true;
        }

        if(current != null && item.compareTo(current.data) == 0 && item.compareTo(last.data) == 0){ //if item equals last.data
            last = previous;
            last.next = null;

            return true;
        }

        return false;
    }

    public void insert(T item) {

        Node current = first;
        Node previous = null;
        Node newNode = null;

        if(first == null && listEmpty){
            listEmpty = false;
            first = new Node();
            first.data = item;
            last = first;

            return;
        }

        newNode = new Node();
        newNode.data = item;

        if(itemLessThanFirst(current, newNode) && !listEmpty){ //if item needs to be added to the beginning of the list
            return;
        }

        while(current != null && (current.data.compareTo(item) < 0)){
            previous = current;
            current = current.next;
        }

        if(itemInMiddle(current, previous, newNode) && !listEmpty){ //if item needs to be added anywhere in the list except for the beginning/end
            return;
        }

        if(itemGreaterThanLast(previous, newNode) && !listEmpty){  //if item needs to be added to the end of the list
            return;
        }

    }

    public boolean itemInMiddle(Node current, Node previous, Node newNode){
        if(current != null && current.data.compareTo(newNode.data) > 0){

            newNode.next = current;
            newNode.prev = previous;
            previous.next = newNode;
            current.prev = newNode;

            return true;
        }
        return false;
    }

    public boolean itemGreaterThanLast(Node previous, Node newNode){
        if(previous != null && newNode.data.compareTo(previous.data) > 0 && newNode.data.compareTo(last.data) > 0){

            newNode.prev = previous;
            newNode.next = last.next;
            last = newNode; //item is added to the end of the list & last is assigned newNode
            previous.next = newNode;

            return true;
        }
        return false;

    }

    public boolean itemLessThanFirst(Node current, Node newNode){

        if(current != null && newNode.data.compareTo(current.data) < 0){

            newNode.prev = null;
            newNode.next = current;
            first = newNode; //item is added to the beginning of the list & first is assigned newNode
            current.prev = newNode;

            if(current.next == null){
                last = current;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        DoublyLinkedList<String> newList  = new DoublyLinkedList<>();

        System.out.println(newList.first);
        System.out.println(newList.last);
        newList.insert("integrals");
        newList.insert("fractions");
        newList.insert("derivatives");
        newList.insert("matrices");

        System.out.println("List contents: " + newList.toString());
        System.out.println("First item in list: " + newList.first.data);
        System.out.println("Last item in list: " + newList.last.data);

        System.out.println("\n" + "Removing the following words from the list: fractions and matrices");
        System.out.println(newList.remove("fractions"));
        System.out.println(newList.remove("matrices"));

        System.out.println("\n" + "Adding the following words to the list: calculus and logarithms ");
        newList.insert("calculus");
        newList.insert("logarithms");

        System.out.println("List contents: " + newList.toString());
        System.out.println("First item in list: " + newList.first.data);
        System.out.println("Last item in list: " + newList.last.data);

    }

}
