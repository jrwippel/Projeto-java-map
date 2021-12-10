package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter File full path:");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            Map<String,Integer> eleicoes = new LinkedHashMap<>();

            String line = br.readLine();
            while (line != null){

                String[] fields = line.split(",");
                String name = fields[0];
                Integer votos = Integer.parseInt(fields[1]);

                if (eleicoes.containsKey(name)){
                    int sumvoto = eleicoes.get(name);
                    eleicoes.put(name, votos + sumvoto);
                }else{
                    eleicoes.put(name, votos);
                }
                line = br.readLine();
            }

            System.out.println("Canditatos:");

            for (String key: eleicoes.keySet()){
            System.out.println(key + " : "+ eleicoes.get(key));
            }
        } catch (IOException e){
            System.out.print("Error: "+ e.getMessage());
        }

        sc.close();

    }
}
