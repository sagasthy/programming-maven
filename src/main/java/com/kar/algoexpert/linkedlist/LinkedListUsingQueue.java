package com.kar.algoexpert.linkedlist;

public class LinkedListUsingQueue {

}

class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToTail(int value) {
        ListNode node = new ListNode(value);
        if(this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail = node;
            // node.next = tail;
        }
    }
}

class ListNode {
    ListNode head;
    int value;

    public ListNode(int value) {
        this.value = value;
    }
}