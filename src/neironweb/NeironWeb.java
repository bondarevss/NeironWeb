
package neironweb;

import java.util.ArrayList;
import java.util.Arrays;


public class NeironWeb {
    ArrayList<ArrayList<Neiron>> web = new ArrayList<ArrayList<Neiron>>();
  
    public static void main(String[] args) {
        
        MailReader mail = new MailReader();
   mail.GetMail();

/* Пока что это мешает
   String s = mail.readInformation("parameters");
   String smas[] = mail.StringToMasKaretka(s);
   
//   //mail.analizator(null);   
        
         double [] data = {0.1,0.7,0.3,0.9};
// //       double [] result = {0.1,0.9};
        
        int [] neironinlayer = {3,2};
     
   MatrixWeight matrixweight1 = new MatrixWeight(4,neironinlayer[0]);
   MatrixWeight matrixweight2 = new MatrixWeight(neironinlayer[0],neironinlayer[1]);
   
   
   
   Web w = new Web(data, 2, neironinlayer,matrixweight1,matrixweight2);
    
        for (int i = 0; i < smas.length; i++) {
         
            double [] masmas = {};
            String [] masSt = smas[i].split("|");
            for(int j = 0; j < 5; j++)
                   masmas[j] =  Double.parseDouble(masSt[j]) ;
         
         double []first = Arrays.copyOfRange(masmas, 0, 3);
         double []second = Arrays.copyOfRange(masmas, 4, 4);
         
         w.education(first, second);   
        }
   
 */ 
        

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
