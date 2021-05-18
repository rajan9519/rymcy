package com.mygluecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compile {
    public boolean compile(String lang) {
        System.out.println("Code compilation started...");
        ProcessBuilder pb;
        boolean compiled = true;
        if (lang.equals("java")) {
            System.out.println("Compiling Java code");
            pb = new ProcessBuilder("javac", "./Test/Main.java");
        } else if (lang.equals("c")) {
            System.out.println("Compiling C code");
            pb = new ProcessBuilder("gcc","-std=c++0x","-w","-o", "./Test/Main", "./Test/Main.c");
        } else {
            System.out.println("Compiling C++ code");
            pb = new ProcessBuilder("g++", "-std=c++0x", "-w", "-o", "./Test/Main", "./Test/Main.cpp");
        }
        // no need to anything for the python code

        pb.directory(new File(System.getProperty("user.dir")));
        pb.redirectErrorStream(true);
        // try catch block for input output exception
        System.out.println(pb.directory());
        try {
                Process p = pb.start();

                try(BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                    String line;

                    while ((line = output.readLine()) != null) {
                        compiled = false;
                        System.out.println(line);
                    }
                }
        } catch (IOException e) {
            System.out.println(e);
        }

        return compiled;
    }
}
