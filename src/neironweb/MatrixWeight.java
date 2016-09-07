/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neironweb;


public class MatrixWeight {
double [] [] weight;
    public MatrixWeight(int data, int neironinlayer) {
    weight = new double [data][neironinlayer];
    for (int i = 0; i < data; i++) {
        for (int j = 0; j < neironinlayer; j++) {
         weight[i][j] = Math.random()/2;   
            System.out.print(weight[i][j]);
        }
        System.out.println("");       
    }
    }
  
    
}
