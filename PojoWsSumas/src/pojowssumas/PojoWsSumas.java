/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojowssumas;

/**
 *
 * @author sdist
 */
public class PojoWsSumas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a, b, c;
        a = (int) (1000.0 * (-1.0 + 2.0 * Math.random() ) );
        b = (int) (1000.0 * (-1.0 + 2.0 * Math.random() ) );
        
        c = suma(a, b);
        
        System.out.println("La suma de " + a + " y " + b + " es " + c);
    }

    private static int suma(int a, int b) {
        wssumas.WSsumas_Service service = new wssumas.WSsumas_Service();
        wssumas.WSsumas port = service.getWSsumasPort();
        return port.suma(a, b);
    }
    
}
