package com.rodrigo;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Services {

    public List GET_CSV(BufferedReader args) throws IOException{
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try(CSVReader csvReader = new CSVReaderBuilder(args).
        withCSVParser(csvParser).withSkipLines(1).build()){
        return csvReader.readAll();
        }
    }

    public BufferedReader Get_Url (String args) throws IOException{
        URL stockURL = new URL(args);
        URLConnection yc = stockURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        return in;
    }

    public BufferedReader Get_Archive (String args) throws FileNotFoundException{
        BufferedReader a = new BufferedReader(new FileReader("C:/Users/Estev/Documents/Desenvolvimento/Arquivo.csv"));
        return(a);
    }
}
