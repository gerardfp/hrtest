package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    new File("testcases/input").mkdirs();
	    new File("testcases/output").mkdirs();

	    int testnum = 0;

        FileWriter IN = new FileWriter(new File("testcases/input/input"+String.format("%02d", testnum)+".txt"));
        FileWriter OUT = new FileWriter(new File("testcases/output/output"+String.format("%02d", testnum)+".txt"));

        IN.close();
        OUT.close();
    }
}
