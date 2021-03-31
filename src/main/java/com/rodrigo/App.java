package com.rodrigo;

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

/**
 * Hello world!
 * 
 *
 */

public class App 
{
    public static void main(String[] args) throws Exception {
        URL stockURL = new URL("https://xtr-tinto.consiste.com.br/xtr/xtrAPI.nsf/api.xsp/fileView/md/3E391C29EE1739FD03258609006C7EAA/0/dataset.CSV");
        URLConnection yc = stockURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        
        
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        
        try(CSVReader csvReader = new CSVReaderBuilder(in).withCSVParser(csvParser).withSkipLines(1).build()){
            String teste = "";
            String teste1 = "";
            String teste2 = "";
            String teste3 = "";
            FileWriter fw = new FileWriter(new File("Rodrigo_Esteves_Da_Cruz.txt"));
            List<String[]> a = csvReader.readAll();
            for (String[] pessoa : a){
                if(!pessoa[2].isEmpty()){
                    teste = pessoa[0];
                    teste1 = pessoa[1];
                    teste2 = pessoa[2].replace(",",".");
                    teste3 = pessoa[3].replace(",",".");
                    float abc = Float.parseFloat(teste2);
                    float cde = Float.parseFloat(teste3);
                    
                    String testando = StringUtils.normalizeSpace(teste.toUpperCase()) + " " + StringUtils.normalizeSpace(teste1.toUpperCase()) + " " + String.format("%.2f",(abc / (cde*cde)));
                    System.out.println(testando);
		            fw.write(testando);
                }
                }
                fw.close();
            }
        }
    }
