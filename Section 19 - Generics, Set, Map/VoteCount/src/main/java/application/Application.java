package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> candidates = new TreeMap<>();
            String line = br.readLine();
            while (line != null) {

                String[] field = line.split(",");
                String name = field[0];
                int votes = 0;
                if(candidates.get(name) != null){
                    votes = candidates.get(name);
                }
                votes += Integer.parseInt(field[1]);
                candidates.put(name, votes);

                line = br.readLine();
            }
            for (String key : candidates.keySet()) {
                System.out.println(key + " Total votes: " + candidates.get(key));
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
