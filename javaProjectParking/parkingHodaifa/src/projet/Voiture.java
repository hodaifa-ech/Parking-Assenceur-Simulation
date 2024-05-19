/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Voiture extends JLabel implements Runnable {

    ImageIcon car ;
    int id ;
    int x;
    int y;
    static boolean[]  state ;
    static int[] postionExitCar ;
     public Voiture()
    {
        this.id=1;
        this.x=-200 ;
        this.y=160 ;
        car=new ImageIcon("src/img/"+this.id+".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
        state=new boolean[4];
        postionExitCar=new int[4];
        for(int i=0 ; i<state.length;i++)
        {
            state[i]=false ;
        }
        for(int i=0 ; i<postionExitCar.length;i++)
        {
            postionExitCar[i]=-200 ;
        }




    }
       public Voiture(int id)
    {
        this.id=id;
        this.x=-200 ;
        this.y=160 ;
        car=new ImageIcon("src/img/"+this.id+".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
        state=new boolean[4];
        postionExitCar=new int[4];
        for(int i=0 ; i<state.length;i++)
        {
            state[i]=false ;
        }
        for(int i=0 ; i<postionExitCar.length;i++)
        {
            postionExitCar[i]=-200 ;
        }

    }


   public void setImageParking(int i)
   {
       car=new ImageIcon("src/img/"+i+"_"+i+".png");
       this.setIcon(car);
   }
    public void setIconExitParking(int i)
   {
        car=new ImageIcon("src/img/"+this.id+".png");
        this.setIcon(car);
   }


     public void  entrePark()
    {

        System.out.println("Voiture "+this.id+" is Parking");
        int[] c=new int[4] ;

        for(int i =0 ; i<c.length;i++) // initialise to empty
        {
            c[i]=0;
        }

        for(int i=0 ; i<4 ; i++) // check if blocs is empty
        {
            if(!Parking.blocEtat[i])
            {
               c[i]=1;
            }

        }

        int b=0 ; // le nombre de block vide
         for(int i=0 ; i<4 ; i++)
        {
            if(c[i]==1)
            {
               b++;
            }

        }

        if(b==0) { // le nombre de bloc vide
            for(int i=0 ; i<state.length;i++)
         {
            if(state[i])
                {
                    try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
                }

               }
         }

            System.out.println("Empty blocs : "+b);
            Movemment.moveIN(this,1080);
        }

        if(b==1){
                      if(c[0]==1){
                System.out.println("Empty bloc : 1 ");
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this,  290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(c[1]==1)
            {
                 System.out.println("Empty bloc : 2 ");
                 System.out.println("Target bloc : 2 ");
                 Movemment.moveIN(this, 430);
                 Movemment.parking(this);
                 Parking.blocEtat[1]=true;
            }
            else if(c[2]==1)
            {
                System.out.println("Empty bloc : 3 ");
                 System.out.println("Target bloc : 3 ");
                 Movemment.moveIN(this,560);
                 Movemment.parking(this);
                 Parking.blocEtat[2]=true;
            }
            else if(c[3]==1)
            {
                System.out.println("Empty bloc : 4 ");
                 System.out.println("Target bloc : 4 ");
                 Movemment.moveIN(this,700);
                 Movemment.parking(this);
                 Parking.blocEtat[3]=true;
            }
        }


        if(b==2){
            int x= (int)(Math.random() * 2) + 1 ;
           // System.out.println("x: "+x);
            if(c[0]==1 && c[1]==1){ //1 and 2
               System.out.println("Empty blocs : 1 , 2 ");
                if(x==1)
                {
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this, 290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
                }
                else {
                System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this, 430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
                }
            }
            else if(c[0]==1 && c[2]==1) //1 and 3
            {
                System.out.println("Empty blocs : 1 , 3 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this,290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
                }
                else {
                System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this,560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
                }
            }

            else if(c[0]==1 && c[3]==1) // 1 and 4
            {
                System.out.println("Empty blocs : 1 , 4 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this, 290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
                }
                else {
                System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this, 700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
                }
            }
             else if(c[1]==1 && c[2]==1) // 2 and 3
            {
                System.out.println("Empty blocs : 2 , 3 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this, 430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
                }
                else {
                System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this, 560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
                }
            }
             else if(c[1]==1 && c[3]==1) // 2 and 4
            {
                System.out.println("Empty blocs : 2 , 4 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this,430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
                }
                else {
                System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this,700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
                }
            }
             else if(c[2]==1 && c[3]==1) // 3 and 4
            {
                System.out.println("Empty blocs : 3 , 4 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this,560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
                }
                else {
                System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this, 700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
                }
            }

        }


        if(b==3)
        {

            int x= (int)(Math.random() * 3) + 1 ;
            //System.out.println("x: "+x);

            if(c[0]==1 && c[1]==1 && c[2]==1) // 1 2 3
            {
            System.out.println("Empty blocs : 1 , 2 , 3 ");
            if(x==1)
            {
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this,290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this, 430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==3)
            {
                 System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this, 560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
            }
            }

             if(c[0]==1 && c[1]==1 && c[3]==1) //1 2 4
            {

            System.out.println("Empty blocs : 1 , 2 , 4 ");
            if(x==1)
            {
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this, 290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this, 430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==3)
            {
                 System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this,700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
            }
            }
              if(c[0]==1 && c[2]==1 && c[3]==1) //1 3 4
            {

            System.out.println("Empty blocs : 1 , 3 , 4 ");
            if(x==1)
            {
                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this, 290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this, 560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
            }
            else if(x==3)
            {
                 System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this, 700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
            }
            }
             if(c[1]==1 && c[2]==1 && c[3]==1) //2 3 4
            {

            System.out.println("Empty blocs : 2 , 3 , 4 ");
            if(x==1)
            {
                System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this,430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this,560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
            }
            else if(x==3)
            {
                System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this,700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
            }
            }

        }


        if(b==4)
        {
            int x= (int)(Math.random() * 4) + 1 ;
            //System.out.println("x: "+x);

            System.out.println("Empty blocs : 1 , 2 , 3 , 4 ");
            if(x==1)
            {

                System.out.println("Target bloc : 1 ");
                Movemment.moveIN(this, 290);
                Movemment.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 2 ");
                Movemment.moveIN(this, 430);
                Movemment.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==3)
            {
                System.out.println("Target bloc : 3 ");
                Movemment.moveIN(this,  560);
                Movemment.parking(this);
                Parking.blocEtat[2]=true;
            }
            else if(x==4)
            {
                System.out.println("Target bloc : 4 ");
                Movemment.moveIN(this, 700);
                Movemment.parking(this);
                Parking.blocEtat[3]=true;
            }

        }


    }
     public void sortiPark()
    {
        System.out.println("car "+this.id+" is going out");


           if(this.x<=300) // bloc 1
           {
              state[0]=true ;
              postionExitCar[0]=this.x;
              Movemment.exitParking(this);
              state[0]=false ;
              postionExitCar[0]=-300;
              Parking.blocEtat[0]=false;
              Movemment.moveOut(this);

           }
            if(this.x>=290 && this.x<=450) //bloc 2
           {
              state[1]=true ;
              postionExitCar[1]=this.x;
              Movemment.exitParking(this);
              state[1]=false ;
              postionExitCar[1]=-300;
              Parking.blocEtat[1]=false;
              Movemment.moveOut(this);

           }
            if(x>=450 && x<=700) // bloc 3
           {
              state[2]=true ;
              postionExitCar[2]=this.x;
              Movemment.exitParking(this);
              state[2]=false ;
              postionExitCar[2]=-300;
              Parking.blocEtat[2]=false;
              Movemment.moveOut(this);

           }
             if(x>=700 && x<=1080) // bloc 4
           {
              state[3]=true ;
              postionExitCar[3]=this.x;
              Movemment.exitParking(this);
              state[3]=false ;
              postionExitCar[3]=-300;
              Parking.blocEtat[3]=false;
              Movemment.moveOut(this);

           }



     }

    @Override
     public void run() {

        try {

           // Random random = new Random();
            int x= (int)(Math.random() * 10000) + 6000 ;
            System.out.println("voiture : "+this.id+" Parking Time(s) : "+x/1000);

            Parking.semaphoreEntree.acquire();
            this.entrePark();
            Parking.semaphoreEntree.release();

            Thread.sleep(x);

            Parking.semaphoreSortie.acquire();
            this.sortiPark();
           // Thread.sleep(6000);
            Parking.semaphoreSortie.release();

            // Thread.sleep(6000);

            // if(random.nextBoolean()) Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


}

