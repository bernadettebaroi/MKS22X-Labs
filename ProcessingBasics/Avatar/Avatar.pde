  int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 3;
           x = width/2;
           y = height/2;
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       value = (int)(Math.random() * width/2);
       return value ;
     case 2:
       int z = (int)(Math.random() * 3)-1 ;
       value += z;
       return value;
     case 3:
       value += 1; 
       if (value > width) {
         value -= width;
       }
       return value;
     default:
       return width/2;
    }
  }

void avatar(int x, int y){
  fill(200);
  circle(x,y,150);
  /*
  triangle(x, y, 2*x, 3*y, 3*x, y);
  fill(130);
  circle(x, y, (x+y)/2);
  fill(130);
  circle(3*x, y, (x+y)/2);
  fill(30);
  triangle(1.75*x, 2.5*y, 2*x, 3*y, 2.25*x, 2.5*y);
  //eyes
  circle(1.7*x,1.7*y,(x+y)/5);
  circle(2.25*x,1.7*y,(x+y)/5);
  //nose
  //line(400, 400, 400, 450);
  //whiskers
  /*
  line(200, 410, 325, 450);
  line(200, 460, 325, 450);
  line(210, 520, 325, 450);
  line(475, 450, 600, 370);
  line(475, 450, 600, 450);
  line(475, 450, 600, 490);
  */
  
}
