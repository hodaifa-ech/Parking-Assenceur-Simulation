/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author hodaifa
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) {


        JFrame frame = new JFrame("Parking ");
        Parking panel = new Parking();
        frame.setContentPane(panel);
        panel.setLayout(null);
        frame.setSize(1090, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Voiture> Voitures=new ArrayList<Voiture>();



      for(int i=1 ; i<=4 ; i++)
      {
          Voiture c = new Voiture(i);
          Voitures.add(c);
          panel.add(c);
       }

      for(Voiture c : Voitures)
      {
          Thread t=new Thread(c);
          t.start();
      }
      frame.setVisible(true);

    }

}
