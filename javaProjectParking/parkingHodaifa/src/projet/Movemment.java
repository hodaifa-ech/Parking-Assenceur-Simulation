/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hodaifa
 */
public class Movemment {

   static boolean notExit=false ;

    public static void moveIN(Voiture c , int xMax)
    {

               while(c.x<=xMax)
            {

                 if(c.x==290) notExit=true  ;
                 if(c.x==430) notExit=true  ;
                 if(c.x==560) notExit=true  ;
                 if(c.x==700) notExit=true  ;

                for(int i =0 ; i<4 ; i++){
                  if(Voiture.state[i]==true &&  c.x<= Voiture.postionExitCar[i]) // car is moving out from bloc
                {
                    try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                }
              }


               }

                 c.x+=10;
                 c.setLocation(c.x, c.y);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                }

             }

            notExit=false;

    }

    public static void parking(Voiture c)
    {
             while(c.y>=30)
            {
            c.setImageParking(c.id);
            c.y-=10;
            c.setLocation(c.x, c.y);
             try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

             notExit=false;


    }

    public static void exitParking(Voiture c  )
    {


        while(notExit)
        {
            ;
        }

        while(c.y<=140)
           {
               c.y+=10;
              c.setLocation(c.x, c.y);
             try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                }

           }



    }

     public static void moveOut(Voiture c)
    {
               while(c.x<=1080)
            {
                 c.setIconExitParking(c.id);
                 c.x+=10;
                 c.setLocation(c.x, c.y);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                }

             }
               notExit=false;

              c.x=-200;
              c.y=160;

    }
    
    
    
}

