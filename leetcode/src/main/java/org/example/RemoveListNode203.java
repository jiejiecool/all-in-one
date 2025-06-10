package org.example;

/**
 * 移除链表元素
 */
public class RemoveListNode203 {

    public static void main(String[] args) {
        Node<Integer> head = ArrToListTransformer.transfer(new Integer[]{7,7,7,7,7});
        Handler handler = new Handler(head, 6);
        Node<Integer> handle = handler.handle();
        while (handle != null) {
            System.out.println(handle.getVal());
            handle = handle.getNext();
        }

    }

    static class Handler {
        private Node<Integer> head;
        private int target;

        public Handler(Node head, int target) {
            this.head = head;
            this.target = target;
        }

        public Node<Integer> handle() {
            if (this.head == null) {
                return null;
            }

            Node<Integer> dummyHead = new Node(null);
            dummyHead.setNext(head);

            Node<Integer> currentNode = dummyHead;
            while (currentNode.getNext() != null) {
                if (currentNode.getNext().getVal() == target) {
                    currentNode.setNext(currentNode.getNext().getNext());
                } else {
                    currentNode = currentNode.getNext();
                }
            }

            return dummyHead.getNext();
        }

    }


}
