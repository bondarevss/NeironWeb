
package neironweb;


public class Web {
Layer [] layermas;
int [] inputdata;
    Web(int [] mas, int layer, int [] neironcount){
        inputdata = mas;
        layermas  =new Layer[layer];
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
    Logic log = new Logic();
    log.start(layermas,inputdata);
 } 
}
