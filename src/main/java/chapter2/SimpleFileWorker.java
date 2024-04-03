package chapter2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class SimpleFileWorker {

    public static void main (String[] args){

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("gamesCatalog.txt"));

            //data
            writer.write("name, company, year\n");
            writer.write("Pitfall!, Activision, 1982\n");
            writer.write("Crackpots, Activision, 1983\n");
            writer.write("Yars' Revenge, Atari, 1981\n");
            writer.write("Warlords, Atari, 1981\n");
            writer.write("Defender, Atari, 1981\n");
            writer.write("Adventure, Atari, 1980\n");
            writer.close();
            System.out.println("Writing completed!");

        } catch (IOException writerEx) {

            System.out.println("Error occurred while writing:");

            writerEx.printStackTrace();

        }
    }
}
