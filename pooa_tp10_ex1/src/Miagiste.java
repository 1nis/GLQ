public class Miagiste implements Runnable {

    private String nom;
    private Micro leMicro;

    public Miagiste(String nom, Micro leMicro) {
        this.nom = nom;
        this.leMicro = leMicro;
    }

    @Override
    public void run() {
        synchronized (leMicro) {
            for (int i = 1; i < 6; i++) {
                leMicro.parler(this.nom, i, "Phrase");
            }
        }
    }
}
