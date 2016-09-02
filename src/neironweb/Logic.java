
package neironweb;


public class Logic {

   public  void start(Layer [] layermas, double [] inputdata){
       for (int i = 0; i < layermas.length; i++) {
           Layer layer = layermas[i];
           double [] templ = new double [(layermas[i]).size];
           for (int j = 0; j < (layermas[i]).size; j++) {
             
             templ[j] = layer.l[j].calculation(inputdata);
             
             
            // System.out.println("layer " + i + " "+ " Neoron " + j + " " +layer.l[j].calculation(inputdata));
           }
           inputdata = templ;
       }
    for(double a:inputdata)
        System.out.println(a);
   }
}
