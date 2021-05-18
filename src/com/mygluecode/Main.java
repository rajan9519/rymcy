package com.mygluecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Compile comp =  new Compile();

        if(comp.compile("cpp")) {
            // execute the compiled code
            Execute exe = new Execute();

            exe.execute("cpp");

        }
    }
}
