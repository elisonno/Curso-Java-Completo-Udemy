package application;

import entities.LogEntry;

import java.io.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> logEntrySet = new HashSet<>();

            String line = br.readLine();
            while (line != null){

                String[] field = line.split(" ");
                String userName = field[0];
                Date moment = Date.from(Instant.parse(field[1]));
                logEntrySet.add(new LogEntry(userName, moment));

                line = br.readLine();
            }

        System.out.println("Total users: "+ logEntrySet.size());

        }  catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
