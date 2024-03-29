final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;

final float SPRING_LENGTH = 150; 
final float SPRING_DAMPEN = 0.995;
final float SPRING_CONSTANT = 0.005;

int MODE;
boolean backgroundMODE;
boolean gravityMODE;

ArrayList<Orb>orbList;
Orb center;

void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2,height/2,0,0,20);
  MODE = 0;
  backgroundMODE = true;
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
  
}
void draw() {
  if (backgroundMODE) {
    background(255);
  }
  center.display();
  for (Orb o : orbList) {
    if (gravityMODE) {
      o.gravity();
    }
    if (MODE == GRAVITY) {
      o.move();
      o.bounce();
      o.display();
    } else if (MODE == ORBIT ) {
      o.move();
      center.attract(o);
      o.display();
    } else if (MODE == SPRING ) {
      o.move();
      center.attractSpring(o);
      o.display();
    } 
  }
  fill(255);
  rect(0,0,110,90);
  fill(0);
  text(frameRate,20,20);
  text("# of ORBS: " + orbList.size(),20,40);
  text ("MODE: ", 20,60);
  if (MODE == 0) {
    text("GRAVITY",60,60);
  } else if (MODE == 1) {
    text("ORBIT",60,60);
  } else if (MODE == 2) {
    text("SPRING",60,60);
  }
  if (gravityMODE) {
    text("Gravity ON", 20,80);
  } else {
    text("Gravity OFF", 20,80);
  }
}

void keyPressed() {
  if (keyCode == 32) {
    if (MODE == SPRING) {
      MODE = GRAVITY;
    } else {
      MODE++;
    }
  } else if (key == BACKSPACE || key == DELETE) {
    orbList.clear();
  } else if (keyCode == 66) {
    backgroundMODE = !backgroundMODE;
  } else if (keyCode == 71) {
    gravityMODE = !gravityMODE;
  }
}
