
package neironweb;

import java.util.ArrayList;


public class NeironWeb {
    ArrayList<ArrayList<Neiron>> web = new ArrayList<ArrayList<Neiron>>();
  
    public static void main(String[] args) {
        
        MailReader mail = new MailReader();
   //mail.GetMail();
   mail.analizator(null);   
        
//        double [] data = {0.1,0.7,0.3,0.9};
//        double [] result = {0.1,0.9};
//        
//        int [] neironinlayer = {3,2};
//   
//   
//        
//   MatrixWeight matrixweight1 = new MatrixWeight(data.length,neironinlayer[0]);
//   MatrixWeight matrixweight2 = new MatrixWeight(neironinlayer[0],neironinlayer[1]);
//   
//   
//   
//   Web w = new Web(data, 2,neironinlayer,matrixweight1,matrixweight2);

    //работа сети
    //   w.start(); 
   
   
   //обучение сети
 //  w.education(data, result);
   
   
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
