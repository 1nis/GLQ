public class Micro extends Thread {

    public void parler(String interlocuteur, int phrase, String message) {
        System.out.println("[" + phrase + "] " + interlocuteur + " : " + message + ".");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
