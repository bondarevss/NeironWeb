
package neironweb;


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
  public void education (){
      
  } 
  
  public void savematrix(MatrixWeight matrixweight) {
    log.savematrix(matrixweight);
}
  public void savematrix (MatrixWeight matrix1, MatrixWeight matrix2) {
     log.savematrix(matrix1,matrix2); 
  }

  
}
