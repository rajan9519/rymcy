package com.mygluecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Execute {
    public boolean execute(String lang) {
        System.out.println("Code started executing.");
        ProcessBuilder pb;
        if (lang.equals("java")) {
            pb = new ProcessBuilder("java", "./Test/Main");
        } else if (lang.equals("c")) {
            pb = new ProcessBuilder("./Test/Main");
        } else {
            pb = new ProcessBuilder("./Test/Main");
        }
        pb.directory(new File(System.getProperty("user.dir")));

        pb.redirectErrorStream(true);
        System.out.println("Current directory " + System.getProperty("user.dir"));

        try {

            Process p = pb.start();
            p.waitFor();
            int exitCode = p.exitValue();
            System.out.println("Exit Value = " + exitCode);

            try(BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                String line;

                // if something i got in Input Stream then surely compilation is not successful
                while ((line = output.readLine()) != null) {
                    System.out.println(line);
                }

            }
            if(exitCode != 0)
                return false;
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("Code execution finished!");

        return true;
    }
}
