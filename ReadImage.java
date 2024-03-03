package packWork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class ReadImage implements TimeInterface {

    private BufferedImage image;
    private long time;

    // Constructor
    public BufferedImage getImage() {
        return this.image;
    }

    // Citeste imaginea de la calea specificata si o returneaza, calculand timpul
    public void readImageFromFile(String fileName) {
        File file = new File(fileName);
        time = System.currentTimeMillis(); // Variabila folosita pentru a prelua timpul curent

        // Trateaza exceptiile
        try {
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Nu s-a gasit fisierul");
        }

        time = System.currentTimeMillis() - time; // Calculeaza timpul de citire
    }

    // Afiseaza timpul de citire
    @Override
    public long readTime() {
        System.out.println("Timp citire: " + time / 1000.0f + "s");
        return time;
    }

    // Metoda neimplementata
    @Override
    public abstract long smoothImageTime();

    // Metoda neimplementata
    @Override
    public abstract long writeTime();
}
