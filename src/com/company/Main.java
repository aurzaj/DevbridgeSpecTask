package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int fromYear = 0;
        int endYear = 0;
        System.out.println("You suck at programming, but you will get better soon, just try, kiddo!");
        System.out.println("Also, can you enter the year from where you want to start search: ");
        try {
            fromYear = sc.nextInt();
        } catch (Exception e)
        {
            System.out.println("Wrong format!");
        }

        System.out.println("One last time a job for you, can you enter the year where you want to end search: ");
        try {
            endYear = sc.nextInt();
        } catch (Exception e)
        {
            System.out.println("Wrong format!");
        }

        if(fromYear < endYear)
        printBonusDatesBetween(fromYear, endYear);
        else
            System.out.println("Starting year is bigger or equal to ending year!!!");

    }

    static void printBonusDatesBetween(int fromYear, int toYear)
    {
        LocalDate startDate = LocalDate.of(fromYear,1,1);
        LocalDate endDate = LocalDate.of(toYear,1,1);

        List<LocalDate> listOfDates = getDatesArray(startDate,endDate);
        String date = "";
        int en = 0;
        boolean isAnwser = true;

        for (int i = 0; i < listOfDates.size(); i++) {
            date = listOfDates.get(i).toString();
            date = date.replaceAll("-", "");
            if(checkDate(date) == 4)
            {
                if(isAnwser)
                {
                    System.out.println("Your Answer:");
                    isAnwser = false;
                }

                System.out.println(listOfDates.get(i));
            }
        }
        if(isAnwser)
        {
            System.out.println("Sorry no such dates :(");
        }
    }

    static List<LocalDate> getDatesArray(LocalDate startDate, LocalDate endDate)
    {
        List<LocalDate> listOfDates = startDate.datesUntil(endDate)
                .collect(Collectors.toList());
        return listOfDates;
    }

    static int checkDate(String date)
    {
        int en = 0;
        for (int j = 0; j < date.length() / 2; j++) {
            if(date.charAt(j) == date.charAt(date.length() - j - 1))
            {
                en +=1;
            }
        }
        return en;
    }
}
