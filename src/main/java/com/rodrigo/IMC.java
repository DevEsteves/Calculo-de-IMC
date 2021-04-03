package com.rodrigo;

import java.io.*;
import java.net.*;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.text.Normalizer;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

/**
 * Hello world!
 * 
 *
 */

public class IMC implements Constantes
{
    public static BufferedReader br;
    public static float peso = 0;
    public static float altura =0;
    public static String str = "";
    public static void main(String[] args) throws Exception {
        br = Get_Url(URL_CSV);
        Imprime(Arquivotxt(removerAcentos(Csv_toString(Csv_toFloat(GET_CSV(br))))));
        
        }

        public static List GET_CSV(BufferedReader args) throws IOException{
            CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
            try(CSVReader csvReader = new CSVReaderBuilder(args).
            withCSVParser(csvParser).withSkipLines(1).build()){
            return csvReader.readAll();
            }
        }

        public static ArrayList Csv_toFloat(List<String[]> args){
            ArrayList<String> e = new ArrayList<String>();
            for (String[] pessoa : args){    
            if(!pessoa[2].isEmpty() && !pessoa[3].isEmpty()){                    
                peso = Float.parseFloat(pessoa[2].replace(",", "."));
                altura = Float.parseFloat(pessoa[3].replace(",", "."));                
                }else{
                    peso = 0;
                    altura = 0;
                }
                str = StringUtils.normalizeSpace(pessoa[0].toUpperCase()) +
                " " + StringUtils.normalizeSpace(pessoa[1].toUpperCase()) +
                " " + String.format("%.2f",(peso / (altura*altura)));
                e.add(str);             
            }
            return e;
        }

        public static String Csv_toString(ArrayList<String> args){
            StringBuilder sb = new StringBuilder(); 
            for (String s : args){
                sb.append(s);
                sb.append("\n");
            } return sb.toString();
        }        
        
        public static BufferedReader Get_Url (String args) throws IOException{
            URL stockURL = new URL(args);
            URLConnection yc = stockURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            return in;
        }

        public static String removerAcentos(String args) {
            return Normalizer.normalize(args, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        }

        public static String Arquivotxt(String args) throws IOException{
            FileWriter fw = new FileWriter(new File("RodrigoEstevesDaCruz.txt"));
            fw.write(args);
            fw.close();
            return args;
        }

        public static void Imprime(String args){
            System.out.println(args);
        }
}