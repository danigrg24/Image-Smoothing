package packWork;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public abstract class SmoothImage extends ReadImage {

    private long processingTime;
    private BufferedImage processedImage;

    // Constructor care mosteneste metoda de citire din clasa ReadImage
    public SmoothImage() {
        this.processedImage = super.getImage();
    }

    // Etapele in care fac procesarea imaginii
    public void smooth() {
        processingTime = System.currentTimeMillis(); // Variabila folosita pentru a prelua timpul curent
        
        // Creez un kernel prin instantierea clasei Kernel
        Kernel kernel = new Kernel(5, 5, new float[]{
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f
        });
        
        // Creez o matrice de convolutie prin instantierea clasei ConvolveOp
        BufferedImageOp op = new ConvolveOp(kernel);
        
        // Modific imaginea prin realizarea convolutiei dintre matricea de convolutie si BufferedImage
        this.processedImage = op.filter(super.getImage(), null);
        
        processingTime = System.currentTimeMillis() - processingTime; // Calculez timpul de procesare al imaginii
    }

    // Returnez imaginea editata
    public BufferedImage getProcessedImage() {
        return this.processedImage;
    }

    // Afisez timpul de prelucrare a imaginii
    @Override
    public long smoothImageTime() {
        System.out.println("Timp prelucrare: " + processingTime / 1000.0f + "s");
        return processingTime;
    }

    public long writeTime() {
        return 0;
    }
}
