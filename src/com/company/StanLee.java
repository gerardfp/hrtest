package com.company;

import java.util.Locale;
import java.util.Scanner;

public class StanLee {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("(, |\\n)");

        int[] mitjanesMensuals = new int[12];

        int totalAnual = 0;
        for(int i=0; i<12; i++){
            int ndies = 0;
            switch (i+1) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    ndies = 31;
                    break;
                case 2:
                    ndies = 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    ndies = 30;
                    break;
            }
            int totalMensual = 0;
            for(int v=0; v<ndies; v++){
                totalMensual += scanner.nextInt();
            }
            mitjanesMensuals[i] = totalMensual/ndies;
            totalAnual += mitjanesMensuals[i];
        }

        int mitjanaAnual = totalAnual/12;
        System.out.println("<!DOCTYPE html>\n<div style=\"display: flex; align-items: baseline;\">");
        for(int i = 0; i<12; i++){
            System.out.println("    <div style=\"width: 16px; margin: 2px; background-color: "+ (mitjanesMensuals[i] < mitjanaAnual ? "red" : "blue") +"; height: "+ mitjanesMensuals[i] +"px;\"></div>");
        }
        System.out.println("    <div style=\"background-color: green; height: 2px; width: 240px; position: relative; bottom: "+mitjanaAnual +"px; right: 240px\"></div>\n</div>");


    }
}

/*
10
1.46 1.43 1.56 1.57 1.50 1.51 1.39 1.45 1.60 1.47

1.50


 */