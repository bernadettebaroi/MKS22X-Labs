public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    kernel = new float[3][3];
    for (int i =0 ; i <= 2; i ++) {
      for (int j = 0; j <= 2; j++) {
        kernel[i][j] = init[i][j];
      }
    }
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    color c = img.get(x,y);
    c *= kernel[1][1];
    if (x-1 >= 0) {
      c += img.get(x-1,y)*kernel[0][1];
    }
    if (x+1 <= width) {
      c += img.get(x+1,y)*kernel[2][1];
    }
    if (y-1 >=0) {
      c += img.get(x,y-1)*kernel[1][0];
    }
    if (y+1 <= height) {
      c += img.get(x,y+1)*kernel[1][2];
    }
    if (x+1 <= width && y+1 <= height) {
      c += img.get(x-1,y)*kernel[2][2];
    }
    if (x-1 >= 0 && y-1 >= 0) {
      c += img.get(x-1,y)*kernel[0][0];
    }
    if (x+1 <= width && y-1 >= 0) {
      c += img.get(x-1,y)*kernel[2][0];
    }
    if (x-1 >= 0 && y+1 <= height) {
      c += img.get(x-1,y)*kernel[0][2];
    }
    return c;
  }

  /**You must write this method that applies the kernel to the source,
    *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    color c = 0;
    for (int i = 1; i <= width; i ++) {
      for (int j = 1; j <= height; j++) {
        c = calcNewColor(source,i,j);
        destination.set(i,j,c);
      }
    }
  }
  

}
