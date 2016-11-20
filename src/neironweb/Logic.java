
package neironweb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Logic {
MatrixWeight [] matrixweightArray;
Layer [] layermas;
double [] inputdata;
FileWriter out;
FileReader fr;
BufferedReader br;
String temp;
String s;

   public  double [] start(Layer [] layermas, double [] inputdata, MatrixWeight [] matrixweightAr ){
       matrixweightArray = matrixweightAr;
       this.layermas = layermas;
       this.inputdata = inputdata;
      
       for (int i = 0; i < layermas.length; i++) {
           Layer layer = layermas[i];
           double [] templ = new double [(layermas[i]).size];
           for (int j = 0; j < (layermas[i]).size; j++) {             
             templ[j] = layer.l[j].calculation(inputdata, matrixweightArray[i],j);             
            // System.out.println("layer " + i + " "+ " Neoron " + j + " " +layer.l[j].calculation(inputdata));
           }
           layer.layeroutput = templ;
           
           //for( double d : templ)
             //  System.out.println("output " + d);
           
           inputdata = templ;
       }
       System.out.println("==========");
       System.out.println("вероятность, что обычное письмо: " + inputdata[0]);
       System.out.println("вероятность, спам: " + inputdata[1]);
       
//       for(double a:inputdata)
//        System.out.println(a);
    return inputdata;
   }
   
//  public void savematrix(MatrixWeight matrixweight) {
//    matrixweight.saveMatrix(matrixweight.mastostring());
//}
//    public void savematrix(MatrixWeight matrix1, MatrixWeight matrix2 ) {
//    matrixweight1.saveMatrix(matrix1.mastostring() + "---2 \n" + matrix2.mastostring() );
//}
   }
   
   