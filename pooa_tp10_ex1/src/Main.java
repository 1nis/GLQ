public class Main {

    public static void main(String[] args) {

        Micro leMicro = Micro.getInstance();
        Thread Anis = new Thread(new Miagiste("Anis", leMicro));
        Thread Yasser = new Thread(new Miagiste("Yasser", leMicro));
        Thread Djamila = new Thread(new Miagiste("Djamila", leMicro));
        Thread Brahim = new Thread(new Miagiste("Brahim", leMicro));
        Thread Ines = new Thread(new Miagiste("Ines", leMicro));

        Anis.start();
        Yasser.start();
        Djamila.start();
        Brahim.start();
        Ines.start();

    }
}