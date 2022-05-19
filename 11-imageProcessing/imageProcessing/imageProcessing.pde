String[]names;
Kernel[]kernels;
int currentKernel;

void setup(){
  size(1450,500);
  currentKernel = 0;
  names = new String[]{
    "Identity", "Blur", "Sharpen",
    "Outline", "Left Sobel", "Right Sobel",
    "Top Sobel", "Emboss"
  };
  kernels = new Kernel[] {
    new Kernel( new float[][] {
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    }) ,
    new Kernel( new float[][] {
      {.111, .111, .111},
      {.111, .111, .111},
      {.111, .111, .111}
    }) ,
    new Kernel( new float[][] {
      {0, -1, 0},
      {-1, 5, -1},
      {0, -1, 0}
    }) ,
    new Kernel( new float[][] {
      {-1, -1, -1},
      {-1, 8, -1},
      {-1, -1, -1}
    }) ,
    new Kernel( new float[][] {
      {1, 0, -1},
      {2, 0, -2},
      {1, 0, -1}
    }) ,
    new Kernel( new float[][] {
      {-1, 0, 1},
      {-2, 0, 2},
      {-1, 0, 1}
    }) ,
    new Kernel( new float[][] {
      {1, 2,  1},
      {0, 0, 0},
      {-1, -2, -1}
    }),
    new Kernel( new float[][] {
      {-2, -1,  0},
      {-1, 1, 1},
      {0, 1, 2}
    })
  };
}

void draw(){
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  kernels[currentKernel].apply(car,output);
  image(car,0,0);
  image(output,car.width,0); 
  fill(255);
  rect(0,0,115,20);
  fill(0);
  text ("MODE: " + names[currentKernel] , 05,15);
}

void keyPressed(){
  if (keyCode == 32) {
    currentKernel++;
    if (currentKernel == 8) {
      currentKernel = 0;
    }
    draw(); 
  }
}  


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
    float red = red(img.get(x,y)) * kernel[1][1];
    float blue = blue(img.get(x,y))* kernel[1][1];
    float green = green(img.get(x,y))* kernel[1][1];
    if (x-1 >= 0) {
      red += red(img.get(x-1,y))*kernel[0][1];
      blue += blue(img.get(x-1,y))*kernel[0][1];
      green += green(img.get(x-1,y))*kernel[0][1];
      
    }
    if (x+1 <= width) {
      red += red(img.get(x+1,y))*kernel[2][1];
      blue += blue(img.get(x+1,y))*kernel[2][1];
      green += green(img.get(x+1,y))*kernel[2][1];
    }
    if (y-1 >=0) {
      red += red(img.get(x,y-1))*kernel[1][0];
      blue += blue(img.get(x,y-1))*kernel[1][0];
      green += green(img.get(x,y-1))*kernel[1][0];
    }
    if (y+1 <= height) {
      red += red(img.get(x,y+1))*kernel[1][2];
      blue += blue(img.get(x,y+1))*kernel[1][2];
      green += green(img.get(x,y+1))*kernel[1][2];
    }
    if (x+1 <= width && y+1 <= height) {
      red += red(img.get(x-1,y))*kernel[2][2];
      blue += blue(img.get(x-1,y))*kernel[2][2];
      green += green(img.get(x-1,y))*kernel[2][2];
    }
    if (x-1 >= 0 && y-1 >= 0) {
      red += red(img.get(x-1,y))*kernel[0][0];
      blue += blue(img.get(x-1,y))*kernel[0][0];
      green += green(img.get(x-1,y))*kernel[0][0];
    }
    if (x+1 <= width && y-1 >= 0) {
      red += red(img.get(x-1,y))*kernel[2][0];
      blue += blue(img.get(x-1,y))*kernel[2][0];
      green += green(img.get(x-1,y))*kernel[2][0];
    }
    if (x-1 >= 0 && y+1 <= height) {
      red += red(img.get(x-1,y))*kernel[0][2];
      blue += blue(img.get(x-1,y))*kernel[0][2];
      green += green(img.get(x-1,y))*kernel[0][2];
    }
    if (red > 255) red = 255;
    if (red < 0) red = 0;
    if (green > 255) green = 255;
    if (green < 0) green = 0;
    if (blue > 255) blue = 255;
    if (blue < 0) blue = 0;
    return color(red,green,blue);
  }

  /**You must write this method that applies the kernel to the source,
    *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    color c = 0;
    for (int i = 0; i <= width; i ++) {
      for (int j = 0; j <= height; j++) {
        c = calcNewColor(source,i,j);
        destination.set(i,j,c);
      }
    }
  }
  

}
