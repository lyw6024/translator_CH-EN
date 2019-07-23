package com.company;

import java.io.*;


public class Main {

    public static void main(String args[])  {
        try {
            BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

            String toLookUpWord=bf.readLine();
            Solver s=new Solver(toLookUpWord);

            s.translate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


