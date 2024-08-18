package run;

public class Main {
    public static void main(String[] args) {
        Thread gui = new Thread(new GUI());
        gui.start();

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }

        gui.stop();
    }
}
