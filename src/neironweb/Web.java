
package neironweb;

import java.util.Arrays;


public class Web {
Layer [] layermas;
double [] inputdata;
MatrixWeight matrixweight1;
MatrixWeight matrixweight2;
Logic log = new Logic();
    Web(double [] mas, int layer, int [] neironcount, MatrixWeight matrixweight1, MatrixWeight matrixweight2){
        inputdata = mas;
        layermas  =new Layer[layer];
        this.matrixweight1 = matrixweight1;
        this.matrixweight2 = matrixweight2;
        
        for (int i = 0; i < layer; i++) {
            Neiron [] temp = new Neiron[neironcount[i]];
            
            for (int j = 0; j < neironcount[i]; j++) {
             temp[j]=new Neiron();
            }
            
            Layer ltemp = new Layer(temp);
            layermas[i] = ltemp;
       
        }
      
}
     public void start () { 
   // перенёс создание объекта вверх 
    log.start(layermas,inputdata,matrixweight1,matrixweight2);
 } 
     
     
     
  public void education (double data[], double waitingResult[]){
      double [] haveResult;
      boolean flag = true;
      
     while (flag){
         
       flag = false;
         
       haveResult =  log.start(layermas, inputdata, matrixweight1, matrixweight2);
         
       if (Math.abs(waitingResult[0] - haveResult[0]) > 0.05) flag = true;
       if (Math.abs(waitingResult[1] - haveResult[1]) > 0.05) flag = true;

       
       
         if (flag) {

             for (int i = 0; i < matrixweight2.weight[0].length; i++) {

                 double delta = haveResult[i] * (1 - haveResult[i]) * (waitingResult[i] - haveResult[i]);

                 for (int j = 0; j < matrixweight2.weight.length; j++) {

                     matrixweight2.weight[j][i] = matrixweight2.weight[j][i] + 1 * delta * haveResult[i];
                 }
             }

             Layer layerFirst = layermas[0];

             for (int i = 0; i < matrixweight1.weight[i].length; i++) {
                 double delta = layerFirst.layeroutput[i] * (1 - layerFirst.layeroutput[i]);

                 for (int j = 0; j < matrixweight1.weight.length; j++) {
                     matrixweight1.weight[j][i] = matrixweight1.weight[j][i] + 1 * delta * data[j];
                 }

             }
             flag = true;   //флаг, что нужно еще раз запустить сеть

         }
         
         
         System.out.println("we have result : " + haveResult[0] + " " + haveResult[1]);
 
     }
     
     System.out.println("OK. I'm educated now");
     
  } 
  
  public void savematrix(MatrixWeight matrixweight) {
    log.savematrix(matrixweight);
}
  public void savematrix (MatrixWeight matrix1, MatrixWeight matrix2) {
     log.savematrix(matrix1,matrix2); 
  }

  
}
