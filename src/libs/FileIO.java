/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Tobias Grundtvig
 */
public class FileIO {
    private String path = "resources/";

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<String> readFile(String fileName) throws IOException {
        File file = new File(path + fileName);
        BufferedReader buffered = new BufferedReader(new FileReader(file.getAbsolutePath()));
        ArrayList<String> contents = new ArrayList<>();
        try {
            String line = buffered.readLine();
            while (line != null) {
                contents.add(line);
                line = buffered.readLine();
            }
        } finally {
            buffered.close();
        }
        return contents;
    }

    public void writeFile(String fileName, String content) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(path + fileName)));
            writer.write(content);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void appendToFile(String fileName, String content) {
        try(FileWriter fw = new FileWriter(path+fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(content);
        }
        catch (IOException e)
        {
            //exception handling left as an exercise for the reader
        }
    }
}
