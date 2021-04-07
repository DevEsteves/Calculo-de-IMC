package com.rodrigo;

import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
/**
 * Hello world!
 * 
 *
 */

public class IMC implements Constantes 
{
    private static BufferedReader br;

    public static void main(String[] args) throws Exception {
        Services get = new Services();
        Utils utils = new Utils();
        
        br = get.Get_Archive(Arquivo);
        List<String[]> string = get.GET_CSV(br);
        ArrayList<String> a = utils.Csv_toFloat(string);
        String ok = utils.Csv_toString(a);
        String b = utils.removerAcentos(ok);
        utils.Imprime(b);
        utils.Arquivotxt(b);
        }
}