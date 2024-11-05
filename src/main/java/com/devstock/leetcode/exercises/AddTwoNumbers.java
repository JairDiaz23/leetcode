package com.devstock.leetcode.exercises;

import org.w3c.dom.NodeList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Example 1
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
/*
        ListNode nodeL1 = new ListNode(4, new ListNode(3));
        ListNode l1 = new ListNode(2, nodeL1);

        ListNode nodeL2 = new ListNode(6, new ListNode(4));
        ListNode l2 = new ListNode(5, nodeL2);
*/

        ListNode l1 = new ListNode(9);
        l1 = insertAtEnd(l1, 9);
        l1 = insertAtEnd(l1, 9);
        l1 = insertAtEnd(l1, 9);
        l1 = insertAtEnd(l1, 9);
        l1 = insertAtEnd(l1, 9);
        l1 = insertAtEnd(l1, 9);
        l1 = insertAtEnd(l1, 9);

        ListNode l2 = new ListNode(9);
        l2 = insertAtEnd(l2, 9);
        l2 = insertAtEnd(l2, 9);
        l2 = insertAtEnd(l2, 9);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("Resultado final");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0); // Dummy head node
        ListNode current = result; // Pointer to the current node in the result list
        int extraSumVal = 0; // Carry value

        // Traverse both lists until the end of both is reached
        while (l1 != null || l2 != null || extraSumVal != 0) {
            // Get the values from the current nodes or 0 if the node is null
            int currentL1 = (l1 != null) ? l1.val : 0;
            int currentL2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and carry
            int sum = currentL1 + currentL2 + extraSumVal;
            extraSumVal = sum / 10; // Update carry
            int resultVal = sum % 10; // The last digit of the sum to store in the current node

            // Insert result value at the end of the result list
            current.next = new ListNode(resultVal);
            current = current.next;

            // Move to the next nodes in l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return result.next; // Return the next node to skip the dummy head
    }


    public static ListNode insertAtEnd(ListNode node, int val) {
        // Base case: if we reach the end, insert the new node
        if (node == null) {
            return new ListNode(val);
        }

        // Recursive call: set node.next to the result of inserting into the rest of the list
        node.next = insertAtEnd(node.next, val);
        return node;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Recursive method to insert at the end
    public ListNode insertAtEnd(ListNode node, int val) {
        // Base case: if we reach the end, insert the new node
        if (node == null) {
            return new ListNode(val);
        }

        // Recursive call: set node.next to the result of inserting into the rest of the list
        node.next = insertAtEnd(node.next, val);
        return node;
    }

}
