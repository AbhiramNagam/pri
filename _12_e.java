package _12_e;

import java.util.Objects;

class _2{
    volatile Boolean runFirstFunc = true;
    volatile Boolean runSecondFunc = true;
    synchronized void first(){
        System.out.println("FIRST");runFirstFunc = false;
        notifyAll();
    }

    synchronized void second(){
        try{
            while(runFirstFunc)
                wait ();
        }
        catch(Exception e){}
        System.out.println("SECOND");
        runSecondFunc=false;
        notifyAll();
    }

    synchronized void third(){
        try{
            while(runSecondFunc) wait ();
        }
        catch(Exception e){}
        System.out.println("THIRD");
        notifyAll();
    }
}
class ut implements Runnable{
    String func_call;
    _2 var;
    Thread t;
    ut (_2 p,String s){
        t = new Thread (this);
        this.var = p;
        func_call = s;
        t.start();
    }
    public void run(){
        if(Objects.equals(func_call, "first_func")){
            var.first();
            var.runFirstFunc=false;
        }
        else if(Objects.equals(func_call, "second_func")) {
            var.second();
            var.runSecondFunc=false;
        }
        else if (Objects.equals(func_call, "third_func")){
            var.third();
        }
    }
}
class Main{
    public static void main(String[] args){
        _2 p = new _2();

        ut t3 = new
                ut (p,"third_func");        //3
        ut t1 = new
                ut (p,"first_func");        //1
        ut t2 = new
                ut (p,"second_func");       //2
    }
}
