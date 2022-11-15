//package _12d;

import java.util.concurrent.TransferQueue;

class code extends Thread{
    static int isGlassFull=0;
    synchronized void drink(){
        System.out.println("Going to drink!");

        if(isGlassFull==0){
            System.out.println("No drink in the glass,waiting for drink!");
            try{
                wait();
            }
            catch (Exception e){}
        } else if (isGlassFull==1) {
            isGlassFull=0;
            System.out.println("Drinking completed");
        }
    }

    synchronized void pour(){
        System.out.println("Going to pour..");
        isGlassFull=1;
        System.out.println("Pouring completed..");
        notify();
    }
}

class useIt extends Thread{
    static int max;
    public void setMax(int n){
        max=n;
    }


    public void run(){
        for (int i=1;i<=max;i++){
            try{
                code var=new code();
                try {
                    Thread.sleep(1000);
                }
                catch (Exception ignored){

                }
                    Thread t1=new Thread(){
                    public void run(){var.drink();}
                };
                t1.start();

                Thread t2=new Thread(){
                    public void run(){var.pour();}
                };
                t2.start();
                var.join();
            }
            catch (InterruptedException e){}
        }

    }
//    void displayDrinksConsumed(){
//        System.out.println("Total number of drinks consumed : "+max);
//    }
}

public class _12d_modified {

    public static void main(String[] args) throws  InterruptedException{
        int maxDrinks=10;
        useIt ut=new useIt();
        ut.setMax(maxDrinks);
        ut.start();
//        ut.displayDrinksConsumed();
        ut.join();
        Thread.sleep(1000);
        System.out.println("Total number of drinks consumed : "+maxDrinks);
    }
}
