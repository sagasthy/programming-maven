package com.test;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date nextStartDate = new Date();
        long interval = 4 * 1000 * 60;
        long endTime   =  nextStartDate.getTime() + interval;
        Date endDate = new Date(endTime);
        long postTime= endTime + interval;
        Date postDate = new Date(postTime);
        System.out.println("nextStartDate: " + nextStartDate + ", postDate: " + postDate);
    }
}
