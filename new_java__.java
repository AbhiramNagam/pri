class printNum{
    synchronized void first(){
        try{
            System.out.println("First");
        }
        catch (Exception ignored){}
    }
    synchronized void second() {
        System.out.println("Second");
    }

    synchronized void third(){
        System.out.println("Third");
    }

    synchronized void fourth(){
        try{
            System.out.println("");
        }
        catch (Exception ignored)
        {
            
        }
    }
}
class NT implements Runnable{
    public void run(){}
    Thread t;
    printNum p;
    NT(){}
}

public class Main{
    public static void main(String[] args){

    }
}
