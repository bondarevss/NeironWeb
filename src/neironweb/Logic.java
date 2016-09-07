
package neironweb;


public class Logic {

   public  void start(Layer [] layermas, double [] inputdata,MatrixWeight matrixweight1, MatrixWeight matrixweight2){
       
       MatrixWeight [] matrixWeightArray = {matrixweight1, matrixweight2};
       
       for (int i = 0; i < layermas.length; i++) {
           Layer layer = layermas[i];
           double [] templ = new double [(layermas[i]).size];
           for (int j = 0; j < (layermas[i]).size; j++) {
             
             templ[j] = layer.l[j].calculation(inputdata,matrixWeightArray[i],j);
             
             
            // System.out.println("layer " + i + " "+ " Neoron " + j + " " +layer.l[j].calculation(inputdata));
           }
           for( double d : templ)
               System.out.println("output " + d);
           
           inputdata = templ;
       }
    for(double a:inputdata)
        System.out.println(a);
   }
}
