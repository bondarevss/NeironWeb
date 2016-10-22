
package neironweb;

import java.util.ArrayList;
import java.util.Arrays;


public class NeironWeb {
    ArrayList<ArrayList<Neiron>> web = new ArrayList<ArrayList<Neiron>>();
  
    public static void main(String[] args) {
   
   //reading mail     
   MailReader mail = new MailReader();
   mail.GetMail();
   
   //reading parametrs
   String s = mail.readInformation("parameters");
   String paramArray[] = mail.StringToMasKaretka(s);
   
 //mail.analizator(null);         
 //        double [] data = {0.1,0.7,0.3,0.9};
//        double [] result = {0.1,0.9};
//        
        int [] neironinlayer = {3, 2};
//   
//   
//        
   MatrixWeight matrixweight1 = new MatrixWeight(4, neironinlayer[0]);
   MatrixWeight matrixweight2 = new MatrixWeight(neironinlayer[0], neironinlayer[1]);

   
   
   Web w = new Web(2, neironinlayer, matrixweight1, matrixweight2);
    
   
   //educating process
        for (int i = 0; i < paramArray.length; i++) {
         
            
            String [] paramString = paramArray[i].split("_");
            double [] paramsFinal = new double[paramString.length];
            
            for(int v = 0; v < paramString.length; v++)
               System.out.println("paramString = " + paramString[v]);
            
            
            for(int j = 0; j < 5; j++)
                   paramsFinal[j] =  Double.parseDouble(paramString[j]) ;
         
         double [] params4 = Arrays.copyOfRange(paramsFinal, 0, 4);
         double [] result = Arrays.copyOfRange(paramsFinal, 4, 6);
         
         w.education(params4, result);   
        }
   
        
        
    //работа сети
    //   w.start(); 
   
   
   //обучение сети
   
   
   
    //matrixweight1.readMatrix();
//    System.out.println("----------------------- " + matrixweight1.stringmas);
//    System.out.println("----------------------- " + matrixweight2.stringmas);
   // w.savematrix(matrixweight1);
   // w.savematrix(matrixweight2);
   // w.savematrix(matrixweight1,matrixweight2);
//   for()
//      w.education(data[], result[]);
        
    
 
   
    
    }
    
}
