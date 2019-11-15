package com.company;

import java.util.Locale;
import java.util.Scanner;

public class StanLee {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int n = scanner.nextInt();
        float[] a = new float[n];

        for(int i=0; i<n; i++){
            a[i] = scanner.nextFloat();
        }

        float m = scanner.nextFloat();

        for(int i=0; i<n; i++){
            if(a[i] >= m) System.out.println("SI");
            else System.out.println("NO");
        }

    }
}

/*
10
1.46 1.43 1.56 1.57 1.50 1.51 1.39 1.45 1.60 1.47

1.50


 */