package test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        LocalDateTime l1 = LocalDateTime.now();
        for (Integer i : linkedList) {
            System.out.println(i);
        }
        System.out.println("LL diff: " + Duration.between(l1, LocalDateTime.now()).toMillis());

        LocalDateTime l2 = LocalDateTime.now();
        for (Integer i : arrayList) {
            System.out.println(i);
        }
        System.out.println("Array diff: " + Duration.between(l2, LocalDateTime.now()).toMillis());
    }
}