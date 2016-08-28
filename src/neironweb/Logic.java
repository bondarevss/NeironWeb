
package neironweb;


public class Logic {

   public  void start(Layer [] layermas, int [] inputdata){
       for (int i = 0; i < layermas.length; i++) {
           Layer layer = layermas[i];
           for (int j = 0; j < (layermas[i]).size; j++) {
             
             layer.l[j].calculation(inputdata);
             System.out.println(layer.l[j].calculation(inputdata));
           } 
       }
       
   }
}
