package PingPong;

public class Player2 implements Runnable{
    SyncQueue q;

    public Player2(SyncQueue q){
        this.q = q;
        new Thread(this, "Player2").start();
    }
    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}
