
package neironweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;


public class NeironWeb {

    ArrayList<ArrayList<Neiron>> web = new ArrayList<ArrayList<Neiron>>();

    public static void main(String[] args) throws InterruptedException {

        //reading mail     
        MailReader mail = new MailReader();
        //mail.GetMail();

        //reading parameters
        String s = mail.readInformation("parameters");
        String paramArray[] = mail.StringToMasKaretka(s);

        int[] neironinlayer = {4, 3, 2};
        Web w = new Web(neironinlayer);

        //educating process
        for (int i = 0; i < paramArray.length; i++) {

            String[] paramString = paramArray[i].split("_");
            double[] paramsFinal = new double[paramString.length];

            for (int v = 0; v < paramString.length; v++) {
                System.out.println("paramString = " + paramString[v]);
            }

            for (int j = 0; j < paramString.length; j++) {
                paramsFinal[j] = Double.parseDouble(paramString[j]);
            }

            double[] params4 = Arrays.copyOfRange(paramsFinal, 0, 4);
            double[] result = Arrays.copyOfRange(paramsFinal, 4, 6);

       //    w.start(params4);
            w.education(params4, result);
        }
//   
//
        //    mail.saveInformation(matrixweight1.mastostring(), "matrixweight1"); 
        //    mail.saveInformation(matrixweight2.mastostring(), "matrixweight2");

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
