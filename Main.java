import java.io.*;
class Main {
    public static void main(String args[]) {
    
        String command = "g++ rajan.cpp -o rajan.exe";
        String command2 = "python rajan.py";
 
        try {
            // Hello world from c++
            Process process = Runtime.getRuntime().exec(command);
            Process process1 = Runtime.getRuntime().exec("./rajan.exe");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process1.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            // Hello world from python
            Process process2 = Runtime.getRuntime().exec("python rajan.py");

            BufferedReader reader1 = new BufferedReader(
                    new InputStreamReader(process2.getInputStream()));
            String line1;
            while ((line1 = reader1.readLine()) != null) {
                System.out.println(line1);
            }

            reader1.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}