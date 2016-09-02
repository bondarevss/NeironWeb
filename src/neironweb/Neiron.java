
package neironweb;


public class Neiron {
    double [] [] weight;
    
Neiron(int m, int l){
    weight = new double [l][m];
    for (int i = 0; i < l; i++) {
        for (int j = 0; j < m; j++) {
         weight[i][j] = Math.random();   
        }
           
    }

} 

public double calculation(double [] mas){
    double result = 0;
    for (int i = 0; i < mas.length; i++) {
       result+=mas[i]*w; 
    }
    return 1/(1+ Math.pow((Math.E),-result)) ;
 
}
}
