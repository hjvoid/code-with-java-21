package chapter2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

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

            try {
                BufferedReader reader = new BufferedReader(new FileReader("gamesCatalog.txt"));
                String gameLine = reader.readLine();
                boolean headerRead = false;

                while (gameLine != null) {
                    if (headerRead) {
                        String[] gameColumns = gameLine.split(",");
                        int year = Integer.parseInt(gameColumns[2].trim());

                        if (year == 1981) {
                            System.out.println(gameLine);
                        }
                    } else {
                        headerRead = true;
                    }

                    //read the next line
                    gameLine = reader.readLine();
                }
            } catch (IOException readerEx) {
                System.out.println("Error occurred while writing:");
                readerEx.printStackTrace();
            }

        } catch (IOException writerEx) {

            System.out.println("Error occurred while writing:");

            writerEx.printStackTrace();

        }
    }
}
