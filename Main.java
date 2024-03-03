package packTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import packWork.*;

public class Main {
	
	 static void display(String... values){  
		 for(String s:values){  
			   System.out.println(s);  
		 }  
		 } 

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//citire cale fisier de editat
		display("Calea fisierului de unde se citeste poza","Fisier(BMP):");
		Scanner scanner = new Scanner(System.in);
		String image= scanner.nextLine();
		
		//citire cale fisier pentru scrierea imaginii procesate
		display("Calea fisierului unde se va face scrierea","Fisier(BMP):");
		String file= scanner.nextLine();
		
		//citire + procesare + scriere
		WriteImage write = new WriteImage(image);
		write.writeImageToFile(file);
		scanner.close();
		
		//afișare timpi pentru fiecare actiune 
		write.readTime();
		write.smoothImageTime();
		write.writeTime();
	}

}
