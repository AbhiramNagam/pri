package _12d;
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
        this.max=n;
    }
    code var=new code();

    public void run(){
        for (int i=1;i<=max;i++){
            try{
                Thread.sleep(1000);
                new Thread(){
                    public void run(){var.drink();}
                }.start();

                new Thread(){
                    public void run(){var.pour();}
                }.start();

            }
            catch (InterruptedException e){}
        }
    }
}

public class Main {

    public static void main(String[] args) throws  InterruptedException{
        int maxDrinks=5;
        useIt ut=new useIt();
        ut.setMax(maxDrinks);
        ut.start();

        ut.join();
        System.out.println("Total number of drinks consumed : "+maxDrinks);
    }
}
