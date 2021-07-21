package PingPong;

public class Player1 implements Runnable{
    SyncQueue q;

    public Player1(SyncQueue q){
        this.q = q;
        new Thread(this, "Player1").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            q.put(i++);
        }
    }
}
