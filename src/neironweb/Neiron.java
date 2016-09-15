
package neironweb;


public class Neiron {
  
    
Neiron(){


} 

public double calculation(double [] mas, MatrixWeight matrixWeight,int a){
    double result = 0;
    for (int i = 0; i < mas.length; i++) {
       // System.out.println("val " + matrixWeight.weight[i][a]);
       result += mas[i] * matrixWeight.weight[i][a]; 
       //System.out.println("result " + result + " " + mas[i] + " "+ matrixWeight.weight[i][a]);
       
    }
   // System.out.println("result " + result);
    return 1/(1+ Math.pow((Math.E),-result)) ;
 
}
}
