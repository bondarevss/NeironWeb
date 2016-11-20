/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neironweb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MatrixWeight {
    double [] [] weight;
    FileWriter out;
    FileReader fr;
    BufferedReader br;
    String temp;
    String s;
    int data;
    int neironinlayer;
    public String stringmas = "";
static String path = "C:\\Users\\BS\\Desktop\\MatrixWeight.txt";

    public MatrixWeight(int data, int neironinlayer) {
        this.data=data;
        this.neironinlayer=neironinlayer;
    weight = new double [data][neironinlayer];
    for (int i = 0; i < data; i++) {
        for (int j = 0; j < neironinlayer; j++) {
         weight[i][j] = Math.random()/2;   
            System.out.print(weight[i][j]);
        }
        System.out.println("");  
        
    }
    // mastostring();
        
    }
    
    public String  mastostring (){
        for (int i = 0; i < data; i++) {
            for (int j = 0; j < neironinlayer; j++) {
               stringmas=stringmas + weight[i][j] + '_'; 
            }
            stringmas=stringmas + '\n';
        }
        return stringmas;
       // System.out.println("entmas[0].length = " + entmas[0].length);
       // System.out.println("entmas[1].length = " + entmas[1].length);
    }
 
    public void saveMatrix (String stp){
       
    try {
        out = new FileWriter(path);
    } catch (IOException ex) {
        Logger.getLogger(MatrixWeight.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        out.write(stp);
    } catch (IOException ex) {
        Logger.getLogger(MatrixWeight.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        out.close();
    } catch (IOException ex) {
        Logger.getLogger(MatrixWeight.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void readMatrix(String fileName){
        
        String temp = "";
        String s = "";
        //path = path + filename+".txt";
        try {
            fr = new FileReader(path + fileName + ".txt");
            br = new BufferedReader(fr);
            s = br.readLine();

            while (s != null) {
                temp += s + "\n";
                s = br.readLine();
            }
        //System.out.println("Прочитали : " + temp); 

        } catch (FileNotFoundException ex) {
            //  Logger.getLogger(MatrixWeight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //  Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       s = temp;
       String paramArray[] = s.split("\n");
        for (int i = 0; i < paramArray.length; i++) {
         String [] paramString = paramArray[i].split("_");   
            for (int j = 0; j < paramString.length; j++) {
                weight[i][j]=Double.parseDouble(paramString[j]);
            }
         
        }
       
    }
    
}
