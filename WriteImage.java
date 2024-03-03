package packWork;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class WriteImage extends SmoothImage {

    private long writingTime;
    private BufferedImage writtenImage;

    // Constructor utilizând metoda de citire moștenită de la ReadImage
    public WriteImage() {
        this.writtenImage = super.getProcessedImage();
    }

    // Getter care returnează imaginea procesată
    public BufferedImage getWrittenImage() {
        return this.writtenImage;
    }

    // Constructor pentru preluarea și editarea imaginii utilizând metodele de citire și procesare moștenite
    public WriteImage(String fileName) {
        super.readImageFromFile(fileName);
        super.smooth();
        this.writtenImage = super.getProcessedImage();
    }

    // Metoda pentru scrierea imaginii în fișier
    public void writeImageToFile(String fileName) {
        writingTime = System.currentTimeMillis(); // Variabilă folosită pentru a prelua timpul curent

        try (FileOutputStream stream = new FileOutputStream(fileName)) {
            ImageIO.write(this.writtenImage, "BMP", stream);
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Eroare la scriere: " + e.getMessage());
            return;
        }

        writingTime = System.currentTimeMillis() - writingTime; // Calculez timpul de scriere
    }

    // Afisez timpul de scriere
    @Override
    public long writeTime() {
        System.out.println("Scriere imagine: " + writingTime / 1000.0f + "s");
        return writingTime;
    }
}
