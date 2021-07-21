package PingPong1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(true);
        new Thread(()-> new Ping(flag).game()).start();
        new Thread(()-> new Pong(flag).game()).start();

    }

    static class Ping{
        private final AtomicBoolean flag;

        Ping(AtomicBoolean flag) {
            this.flag = flag;
        }

        public synchronized void game(){
            while (!Thread.currentThread().isInterrupted()){
                while (!flag.get()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        return;
                    }
                }
                System.out.println("Ping");
                flag.set(false);
            }
        }
    }

    static class Pong{
        private final AtomicBoolean flag;

        Pong(AtomicBoolean flag) {
            this.flag = flag;
        }

        public synchronized void game(){
            while (!Thread.currentThread().isInterrupted()){
                while (flag.get()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        return;
                    }
                }
                System.out.println("Pong");
                flag.set(true);
            }
        }
    }
}
