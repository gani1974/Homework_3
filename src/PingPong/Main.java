package PingPong;

public class Main {
    public static void main(String[] args) {
        SyncQueue q = new SyncQueue();
        new Player1(q);
        new Player2(q);
    }
}
