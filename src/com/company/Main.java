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
        int[] d = {160, 140, 130, 110, 80, 70, 60, 30, 70, 100, 130, 150};
        for (int testnum=0; testnum<=6; testnum++) {
            FileWriter IN = new FileWriter(new File("testcases/input/input" + String.format("%02d", testnum) + ".txt"));
            FileWriter OUT = new FileWriter(new File("testcases/output/output" + String.format("%02d", testnum) + ".txt"));

            OUT.write("<!DOCTYPE html>\n" +
                    "<style>\n" +
                    "div {\n" +
                    "    display: inline-block;\n" +
                    "    background-color: blue;\n" +
                    "    width: 16px;\n" +
                    "    margin: 2px;\n" +
                    "}\n" +
                    "</style>\n");

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

                OUT.write("<div style=\"height: "+ total / ndies+"px;\"></div>\n");
                System.out.println("<div style=\"height: "+ total / ndies+"px;\"></div>" );
                IN.write(Arrays.toString(q).replace("[", "").replace("]", "") + "\n");
                System.out.println(Arrays.toString(q).replace("[", "").replace("]", ""));
            }
            IN.close();
            OUT.close();
        }

//        Runtime.getRuntime().exec("zip -r testcases.zip testcases");
    }
}
