package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new File("testcases/input").mkdirs();
        new File("testcases/output").mkdirs();

        String[] noms = {"gen","feb","mar","abr","mai","jun","jul","ago","set","oct","nov","des"};
        int[] d = new int[12]; //{160, 140, 130, 110, 80, 70, 60, 30, 70, 100, 130, 150};
        for (int i = 0; i < 12; i++) {
            d[i] = (int) (Math.random()*120) + 60;
        }
        for (int testnum=0; testnum<=6; testnum++) {
            FileWriter IN = new FileWriter(new File("testcases/input/input" + String.format("%02d", testnum) + ".txt"));
            FileWriter OUT = new FileWriter(new File("testcases/output/output" + String.format("%02d", testnum) + ".txt"));

            OUT.write("<!DOCTYPE html>\n" +
                    "<div style=\"display: flex; align-items: baseline;\">\n");

            int[] ms = new int[12];
            for (int y = 1; y <= 12; y++) {
                int ndies = 0;
                switch (y) {
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

                int[] q = new int[ndies];
                int total = 0;
                for (int i = 0; i < ndies; i++) {
                    q[i] = (int) (Math.random() * (100 + Math.random() * d[y-1]));
                    total += q[i];
                }
                ms[y-1] = total/ndies;

                IN.write(Arrays.toString(q).replace("[", "").replace("]", "") + "\n");
            }

            int totalmensual = 0;
            for (int i = 0; i < 12; i++) {
                totalmensual += ms[i];
            }
            int mitjanamensual = totalmensual /12;
            for (int i = 0; i < 12; i++) {
                OUT.write("    <div style=\"width: 16px; margin: 2px; background-color: "+ (ms[i] < mitjanamensual ? "red" : "blue") +"; height: "+ ms[i] +"px;\"></div>\n");
            }
            OUT.write("    <div style=\"background-color: green; height: 2px; width: 240px; position: relative; top: -" + mitjanamensual + "px; right: 240px\"></div>\n");
            OUT.write("</div>");
            IN.close();
            OUT.close();
        }

        Runtime.getRuntime().exec("zip -r testcases.zip testcases");
    }
}
