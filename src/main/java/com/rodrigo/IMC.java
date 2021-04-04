package com.rodrigo;

import java.io.*;

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
        br = get.Get_Url(URL_CSV);
        utils.Imprime(utils.Arquivotxt(utils.removerAcentos(utils.Csv_toString(utils.Csv_toFloat(get.GET_CSV(br))))));
        }
}