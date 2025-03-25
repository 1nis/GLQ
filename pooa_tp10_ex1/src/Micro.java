public class Micro extends Thread {
    private static Micro instance = null;

    private Micro() {}

    public static Micro getInstance() {
        if (instance == null) {
            instance = new Micro();
        }
        return instance;
    }

    public void parler(String interlocuteur, int phrase, String message) {
        System.out.println("[" + phrase + "] " + interlocuteur + " : " + message + ".");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
