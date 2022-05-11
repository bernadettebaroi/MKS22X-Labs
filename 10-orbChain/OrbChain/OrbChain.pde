static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  fill(255);
  rect(0,0,160,30);
  fill(0);
  text ("SPRING_CONSTANT: " + SPRING_CONSTANT, 05,15);
}

void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT *= 1.005;
  } else if (key == '2') {
    SPRING_CONSTANT *= 0.995;
  } else if (key == '3') {
    SPRING_DAMPEN *= 1.005;
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
}
