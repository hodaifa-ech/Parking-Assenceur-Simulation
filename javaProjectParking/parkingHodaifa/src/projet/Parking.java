/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.*;
import java.util.concurrent.Semaphore;
import javax.swing.*;

/**
 *
 * @author hodaifa
 */
public class Parking extends JPanel {

     ImageIcon image;
     ImageIcon Car;
     static boolean[] blocEtat ={false,false,false,false}; //true=full & false=empty
     static Semaphore semaphoreEntree ;
     static Semaphore semaphoreSortie ;

     public Parking(){

         semaphoreEntree =new Semaphore(1,true);
         semaphoreSortie =new Semaphore(1,false);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

          image =new ImageIcon("src/img/road.png");
          image.paintIcon(this, g, WIDTH,WIDTH);


         
         
    }

    

}
