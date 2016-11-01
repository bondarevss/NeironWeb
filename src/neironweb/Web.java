
package neironweb;

import java.util.Arrays;


public class Web {
Layer [] layermas;
double [] inputdata;
MatrixWeight matrixweight1;
MatrixWeight matrixweight2;
Logic log = new Logic();
    Web( int layer, int [] neironcount, MatrixWeight matrixweight1, MatrixWeight matrixweight2){
        //inputdata = mas;
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
     public void start (double [] inputdata) { 
    this.inputdata = inputdata;
   // перенёс создание объекта вверх 
    log.start(layermas,inputdata,matrixweight1,matrixweight2);
 } 
     
     
     
  public void education (double data[], double waitingResult[]){
     
       double [] haveResult;
      boolean flag = true;
      double SPEED = 0.2;
      
     while (flag){
         
       flag = false;
         
       haveResult =  log.start(layermas, data, matrixweight1, matrixweight2);
         
       
       for(int i = 0; i < haveResult.length; i++)
       {
             if (Math.abs(waitingResult[i] - haveResult[i]) > 0.1) flag = true;
       }

       
       
         if (flag) {

             Layer layerTwo = layermas[1];

             layerTwo.Error[0] = haveResult[0] * (1 - haveResult[0]) * (waitingResult[0] - haveResult[0]);
             layerTwo.Error[1] = haveResult[1] * (1 - haveResult[1]) * (waitingResult[1] - haveResult[1]);

             Layer layerOne = layermas[0];

             double sum = 0;
             for (int i = 0; i < 2; i++) {
                 sum += matrixweight2.weight[0][i] * layerTwo.Error[i];
             }
             layerOne.Error[0] = sum * layerOne.layeroutput[0] * (1 - layerOne.layeroutput[0]);

             for (int i = 0; i < 2; i++) {
                 sum += matrixweight2.weight[1][i] * layerTwo.Error[i];
             }
             layerOne.Error[1] = sum * layerOne.layeroutput[1] * (1 - layerOne.layeroutput[1]);

             for (int i = 0; i < 2; i++) {
                 sum += matrixweight2.weight[2][i] * layerTwo.Error[i];
             }
             layerOne.Error[2] = sum * layerOne.layeroutput[2] * (1 - layerOne.layeroutput[2]);

             //for second layer change weigth 
             double[] deltaWeighti0 = new double[3];
             for (int i = 0; i < 3; i++) {
                 deltaWeighti0[i] = layerOne.layeroutput[i] * layerTwo.Error[0] * SPEED;
             }

             for (int i = 0; i < 3; i++) {
                 matrixweight2.weight[i][0] += deltaWeighti0[i];
             }

             double[] deltaWeighti1 = new double[3];
             for (int i = 0; i < 3; i++) {
                 deltaWeighti1[i] = layerOne.layeroutput[i] * layerTwo.Error[1] * SPEED;
             }

             for (int i = 0; i < 3; i++) {
                 matrixweight2.weight[i][1] += deltaWeighti1[i];
             }

              //for first layer change weigth                
             // for first neiron 
             double[] L1_deltaWeighti0 = new double[4];
             for (int i = 0; i < 4; i++) {
                 L1_deltaWeighti0[i] = data[i] * layerOne.Error[0] * SPEED;
             }

             for (int i = 0; i < 4; i++) {
                 matrixweight1.weight[i][0] += L1_deltaWeighti0[i];
             }

             // for second neiron 
             double[] L1_deltaWeighti1 = new double[4];
             for (int i = 0; i < 4; i++) {
                 L1_deltaWeighti1[i] = data[i] * layerOne.Error[1] * SPEED;
             }

             for (int i = 0; i < 4; i++) {
                 matrixweight1.weight[i][1] += L1_deltaWeighti1[i];
             }

             // for third neiron 
             double[] L1_deltaWeighti2 = new double[4];
             for (int i = 0; i < 4; i++) {
                 L1_deltaWeighti2[i] = data[i] * layerOne.Error[2] * SPEED;
             }

             for (int i = 0; i < 4; i++) {
                 matrixweight1.weight[i][1] += L1_deltaWeighti2[i];
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
