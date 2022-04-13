  int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 2;
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
       value = (int)(Math.random() * width);
       return value;
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
  triangle(x, y, 200+x, y, 100+x, 200+y);
  fill(130);
  circle(x, y, 100);
  fill(130);
  circle(200+x, y, 100);
  fill(30);
  triangle(75+x, 150+y, 125+x, 150+y, 100+x, 200+y);
  //eyes
  circle(70+x,55+y,50);
  circle(130+x,55+y,50);
  //nose
  line(100+x, 90+y, 100+x, 125+y);
  //whiskers
  line(25+x, 100+y, 60+x, 120+y);
  line(25+x, 120+y, 60+x, 120+y);
  line(25+x, 140+y, 60+x, 120+y);
  line(137+x, 125+y, 172+x, 145+y);
  line(137+x, 125+y, 172+x, 125+y);
  line(137+x, 125+y, 172+x, 105+y);
}
