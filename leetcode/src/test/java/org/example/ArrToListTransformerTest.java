package org.example;


import org.junit.jupiter.api.Test;

public class ArrToListTransformerTest {
    @Test
    public void test1() {
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Node<Integer> head = ArrToListTransformer.transfer(arr);
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
    }

    @Test
    public void test2() {
        Integer[] arr = new Integer[]{};
        Node<Integer> head = ArrToListTransformer.transfer(arr);
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"a","b","c"};
        Node<String> head = ArrToListTransformer.transfer(arr);
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
    }
}
