package PingPong;

public class SyncQueue {
    int n;
    boolean flag = false;
    synchronized int get(){
        while (!flag){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Ping");
        flag = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while (flag){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.n = n;
        System.out.println("Pong");
        flag = true;
        notify();
    }
}
