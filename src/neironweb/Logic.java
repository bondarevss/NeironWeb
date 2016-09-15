
package neironweb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static neironweb.MatrixWeight.path;


public class Logic {
MatrixWeight matrixweight1;
MatrixWeight matrixweight2;
Layer [] layermas;
double [] inputdata;
FileWriter out;
FileReader fr;
BufferedReader br;
String temp;
String s;

   public  double [] start(Layer [] layermas, double [] inputdata,MatrixWeight matrixweight1, MatrixWeight matrixweight2){
       this.matrixweight1 = matrixweight1;
       this.matrixweight2 = matrixweight2;
       this.layermas = layermas;
       this.inputdata = inputdata;
       
       MatrixWeight [] matrixWeightArray = {matrixweight1, matrixweight2};
       
       for (int i = 0; i < layermas.length; i++) {
           Layer layer = layermas[i];
           double [] templ = new double [(layermas[i]).size];
           for (int j = 0; j < (layermas[i]).size; j++) {
             
             templ[j] = layer.l[j].calculation(inputdata,matrixWeightArray[i],j);
             
            // System.out.println("layer " + i + " "+ " Neoron " + j + " " +layer.l[j].calculation(inputdata));
           }
           layer.layeroutput = templ;
           
           //for( double d : templ)
             //  System.out.println("output " + d);
           
           inputdata = templ;
       }
    //for(double a:inputdata)
      //  System.out.println(a);
    return inputdata;
   }
   
  public void savematrix(MatrixWeight matrixweight) {
    matrixweight.saveMatrix(matrixweight.mastostring());
}
    public void savematrix(MatrixWeight matrix1, MatrixWeight matrix2 ) {
    matrixweight1.saveMatrix(matrix1.mastostring() + "---2 \n" + matrix2.mastostring() );
}
   }
   
   