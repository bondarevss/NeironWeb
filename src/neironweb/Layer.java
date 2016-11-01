
package neironweb;


public class Layer {
Neiron [] l;
int size;
double [] Error;
double [] layeroutput;

    public Layer(Neiron [] n) {
    l = n;
    size = l.length;
    Error = new double[size];
    layeroutput = new double[size];    
    }
    
}
