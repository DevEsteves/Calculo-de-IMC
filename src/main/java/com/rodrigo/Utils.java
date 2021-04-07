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
            if(Peso_altura_ok(pessoa)){                    
            peso_altura(pessoa);                
            }else{
                peso_altura_null();
            }
            Csv_toString(e, pessoa);             
        }
        return e;
    }

    private boolean Peso_altura_ok(String[] pessoa) {
        return !pessoa[2].isEmpty() && !pessoa[3].isEmpty();
    }

    private void peso_altura_null() {
        peso = 0;
        altura = 0;
    }

    private void peso_altura(String[] pessoa) {
        peso = Float.parseFloat(pessoa[2].replace(",", "."));
        altura = Float.parseFloat(pessoa[3].replace(",", "."));
    }

    private void Csv_toString(ArrayList<String> e, String[] pessoa) {
        e.add(StringUtils.normalizeSpace(pessoa[0].toUpperCase()) +
        " " + StringUtils.normalizeSpace(pessoa[1].toUpperCase()) +
        " " + String.format("%.2f",(peso / (altura*altura))));
    }
}