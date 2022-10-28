package thr;

class impli implements Runnable{
    Thread t;
     impli(String str){
         this.t= new Thread(this,str);
     }
     public void run(){
         try {
             for (int i=0;i<5;i++){
                 Thread.sleep(1000);
                 System.out.println(t.getName() + " : "+i);
             }
         }
         catch (InterruptedException e){

         }
         System.out.println(t.getName() + " thread existing");
     }
}

class Main{
    public static void main(String[] args){
        impli c1 = new impli("child 1 ");
        impli c2 = new impli("child 2 ");

        String s1 = Thread.currentThread().getName();
        try {
            c1.t.start();
            c2.t.start();
        }
        catch (Exception e){

        }
        try {
            for (int i=0;i<5;i++){
                Thread.sleep(500);
                System.out.println(s1 + " : "+i);
            }
        }
        catch (InterruptedException e){

        };
        try{
            System.out.print("Here : ");
            c1.t.join();
            c2.t.join();
        }
        catch (Exception e){

        }
        System.out.println(s1  + "thread existing.");
    }
}
