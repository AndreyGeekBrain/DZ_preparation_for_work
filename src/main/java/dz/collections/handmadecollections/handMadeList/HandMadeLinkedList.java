package dz.collections.handmadecollections.handMadeList;

import dz.collections.handmadecollections.HandMadeList;

public class HandMadeLinkedList <T> implements HandMadeList {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public Object get(int index) {
        return (T) getNode(index).value;
    }

    @Override
    public void add(Object o) {
        if (size == 0){
        first = new Node<T>(null, (T) o, null);
        last = first;
        } else{
            Node<T> secondLast = last;
            last = new Node<>(secondLast,(T) o, null);
            secondLast.next = last;
        }
            size++;
    }

    @Override
    public boolean removeIndex(int index) {

        Node <T> node = getNode(index);
        Node<T> nodeNext = node.next;
        Node<T> nodePrevious = node.previsions;
        if (nodeNext != null) {
            nodeNext.previsions = nodePrevious;
        } else {
            last = nodePrevious;
        }

        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public void clean() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> getNode(int index){
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node <T> {
        private Node<T> previsions;
        private T value;
        private Node<T> next;

        public Node(Node<T> previsions, T value, Node<T> next) {
            this.previsions = previsions;
            this.value = value;
            this.next = next;
        }
    }

}
