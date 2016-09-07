
package neironweb;

import java.util.ArrayList;


public class NeironWeb {
    ArrayList<ArrayList<Neiron>> web = new ArrayList<ArrayList<Neiron>>();
  
    public static void main(String[] args) {
        
        
        
        double [] data = {0.1,0.7,0.3,0.9};
        double [] result = {0.1,0.9};
        
        int [] neironinlayer = {3,2};
   
   MatrixWeight matrixweight1 = new MatrixWeight(data.length,neironinlayer[0]);
   MatrixWeight matrixweight2 = new MatrixWeight(neironinlayer[0],neironinlayer[1]);
   Web w = new Web(data, 2,neironinlayer,matrixweight1,matrixweight2);
   w.start();
   
//   for()
//      w.education(data[], result[]);
        
    }
    
}
