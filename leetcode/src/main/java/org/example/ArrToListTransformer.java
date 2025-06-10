package org.example;

public class ArrToListTransformer<T> {
    public static <T> Node<T> transfer(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node<T> dummyHead = new Node(null);

        Node<T> currentNode = dummyHead;
        for (T t : arr) {

            Node<T> tNode = new Node<>(t);
            currentNode.setNext(tNode);
            currentNode = tNode;
        }

        return dummyHead.getNext();
    }
}
