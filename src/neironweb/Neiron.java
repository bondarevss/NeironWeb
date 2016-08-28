
package neironweb;


public class Neiron {
    double w;
Neiron(){
w = Math.random();
} 

public double calculation(int [] mas){
    double result = 0;
    for (int i = 0; i < mas.length; i++) {
       result+=mas[i]*w; 
    }
    return result;
 
}
}
