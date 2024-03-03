This project aims to blur an image in .bmp format and generate the resulting image automatically. The entire process was implemented in Java using the Eclipse IDE development environment. Image processing was achieved using convolution masks.

Image smoothing or blurring is achieved using convolution matrices or kernels. In image processing, a kernel, convolution matrix, or mask is a small matrix of dimensions like 3x3, 5x5, etc., which can be used to perform operations such as filtering. The general expression for convolution involves the processed image, the original image, and the kernel. For this project, the "Low Pass filtering" method was chosen, also known as a smoothing filter, which removes high-frequency content from the image. The convolution process involves adding each element of the image to its local neighbors, weighted by the kernel.

Application Description:
The application follows these steps to achieve the desired result:

1) Takes the path to the image to be processed from the user.
2) Takes the path where the resulting image will be written and displayed.
3) Both images must be in BMP format. If everything is correct, the program starts running.
4) Reads the image processing time.
5) Processes the desired image.
6) Calculates the processing time.
7) Writes the image.
8) Calculates the writing time.
9) Displays the processing times.


Structural-Architectural Description of the Application

The application is divided into two packages (packWork and packTest), each containing the following classes and an interface:

1) packTest:
Main
2) packWork:
ReadImage
SmoothImage
TimeInterface (interface)
WriteImage

Class Main:
This class manages input and output from the keyboard and performs read, processing, and write operations of the image from the source file. It does so by creating an instance of the WriteImage class and calling its writeImageToFile method.

Class ReadImage:
This abstract class is responsible for reading images from the specified file via keyboard input. It also implements the TimeInterface interface to use time calculation functions available in the respective interface.

Class SmoothImage:
This abstract class processes the read image and inherits functionalities from the ReadImage class. It utilizes essential Java classes for image data manipulation. Methods of this class include reading the image, processing it using convolution operations, and calculating processing time.

Class WriteImage:
This class manages the writing process of the processed image. It extends the SmoothImage class to benefit from its functionalities. Methods include reading the processed image, writing it to a specified file, and calculating writing time.

Interface TimeInterface:
The interface contains 3 abstract methods implemented by the ReadImage class and inherited by the SmoothImage and WriteImage classes. It establishes a connection between the implementing classes and their users.
