/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hello;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author RGAMBOAH
 */
public class Cliente_WS
{
    public static void main(String[] args) 
    {
       long lngQuienSoy;
       long sumDeltaT, sumDeltaT2, dtMin = 0,dtMax = 0;
       long lngCuantosMilisFaltan;
       
       String host = (args.length < 1) ? null : args[0];
       long i,n,t0,t1,dt,t0_elapsed, t1_elapsed, deltaT_elapsed;
       String response;
       
       n = args.length > 1 ? Integer.valueOf(args[1]):500;
       
       try 
        {
             Registry registry = LocateRegistry.getRegistry(host);
             IServDisparo servDisparo = (IServDisparo) registry.lookup("ServidorDeDisparo");
             lngQuienSoy = servDisparo.quienSoy();
             lngCuantosMilisFaltan = servDisparo.deltaTEnMilis();
             System.out.println("Cliente " + lngQuienSoy + " faltan " + lngCuantosMilisFaltan  + " milisegundos");
             sumDeltaT  = 0;
             sumDeltaT2 = 0;
             Hello stub = (Hello) registry.lookup("Hello");
             
             int a,b,c;
             
             proxyWS.MiServicioWeb_Service service = new proxyWS.MiServicioWeb_Service();
             proxyWS.MiServicioWeb port = service.getMiServicioWebPort();
             System.out.println("Cliente " + lngQuienSoy + " Proxy WS creado");
             Thread.currentThread().sleep(lngCuantosMilisFaltan);
             
             t0_elapsed = System.currentTimeMillis();
             
             for(i= 1; i <= n; i++ )
             {
                 
               a = (int)( 1000.0 * ( 1.0 + 2.0 * Math.random()));
               b = (int)( 1000.0 * ( 1.0 + 2.0 * Math.random()));
   
               t0 = System.currentTimeMillis();  
               //response = stub.sayHello();
               c = port.suma(a,b);
               t1 = System.currentTimeMillis();
               dt = t1 - t0;
               sumDeltaT  += dt;
               sumDeltaT2 += dt * dt;
               if( i == 0 )
               {
                   dtMin = dt;
                   dtMax = dt;
               }
               else
               {
                   if( dt < dtMin ) dtMin = dt;
                   if( dt > dtMax ) dtMax = dt;
               }
               if(i % 200 == 0)
               {
                   t1_elapsed = System.currentTimeMillis();
                   deltaT_elapsed = t1_elapsed - t0_elapsed;
                   System.out.println("Clte " + lngQuienSoy + ", van " + i + " solicitudes, a los " + deltaT_elapsed + " (miliseg)" );
               }
             }
             servDisparo.acumula(sumDeltaT, sumDeltaT2, n, dtMax, dtMin);
          } 
          catch (Exception e)
          {
              System.err.println("Client exception: " + e.toString());
               e.printStackTrace();
           }
    }

    private static int suma(int a, int b) {
        proxyWS.MiServicioWeb_Service service = new proxyWS.MiServicioWeb_Service();
        proxyWS.MiServicioWeb port = service.getMiServicioWebPort();
        return port.suma(a, b);
    }

    
    
}
