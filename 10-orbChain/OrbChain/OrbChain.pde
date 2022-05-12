static int ADD_MODE = 0;
static int INSERT_MODE = 1;
static int DELETE_MODE = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
static int MODE = ADD_MODE;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}

void mouseClicked() {
  if (MODE == ADD_MODE) {
    orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
  } else if (MODE == INSERT_MODE) {
    orbs.add(mouseX, new OrbNode(mouseX,mouseY,0,0,30));
  } else if (MODE == DELETE_MODE) {
    if (orbs.getNodeAt(mouseX, mouseY) != null) {
      orbs.delete(orbs.getNodeAt(mouseX, mouseY));
    }
  }
}

void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  fill(255);
  rect(0,0,160,80);
  fill(0);
  text ("SPRING_CONSTANT: " + SPRING_CONSTANT, 05,15);
  text ("SPRING_DAMPEN: " + SPRING_DAMPEN, 05,30);
  text ("SPRING_LENGTH: " + SPRING_LENGTH, 05,45);
  text ("GRAVITY: " + GRAVITY, 05,60);
  text ("MODE: " + MODE, 05,75);
}

void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT *= 1.005;
  } else if (key == '2') {
    SPRING_CONSTANT *= 0.995;
  } else if (key == '3') {
    if (SPRING_DAMPEN >= 1) {
      SPRING_DAMPEN = 1;
    } else {
      SPRING_DAMPEN *= 1.005;
    }
  } else if (key == '4') {
    SPRING_DAMPEN *= 0.995;
  } else if (key == '5') {
    SPRING_LENGTH *= 1.00005;
  } else if (key == '6') {
    SPRING_LENGTH *= 0.99995;
  } else if (key == '7') {
    GRAVITY *= 1.005;
  } else if (key == '8') {
    GRAVITY *= 0.995;
  }
  
  if (keyCode == 32) {
   if (MODE == ADD_MODE) {
     MODE = INSERT_MODE;
    } else if (MODE == INSERT_MODE) {
      MODE = DELETE_MODE;
    } else {
      MODE = ADD_MODE;
    }
  } 
}
