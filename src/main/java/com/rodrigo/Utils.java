package com.rodrigo;

import java.text.Normalizer;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Utils {
    
    public static float peso = 0;
    public static float altura = 0;
    public static String str = "";

    public String removerAcentos(String args) {
        return Normalizer.normalize(args, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public String Arquivotxt(String args) throws IOException{
        FileWriter fw = new FileWriter(new File("RodrigoEstevesDaCruz.txt"));
        fw.write(args);
        fw.close();
        return args;
    }

    public void Imprime(String args){
        System.out.println(args);
    }

    public String Csv_toString(ArrayList<String> args){
        StringBuilder sb = new StringBuilder(); 
        for (String s : args){
            sb.append(s);
            sb.append("\n");
        } return sb.toString();
    }

    public ArrayList Csv_toFloat(List<String[]> args){
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
}