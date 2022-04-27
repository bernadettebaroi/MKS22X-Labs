ArrayList<Orb>orbList;
Orb center;
int MODE;
int b;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2,height/2,0,0,20);
  MODE = 0;
  b = 0;
}
void mouseClicked() {
  orbList.add(new Orb(mouseX, mouseY, random(-3,3), random(-3,3), random(20,70)));
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  
  //orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
  
}
void draw() {
  if (b % 2 == 0) {
    background(255);
  }
  center.display();
  for (Orb o : orbList) {
    if (MODE % 2 == 0) {
      o.move();
      o.display();
    } else if (MODE % 2 == 1) {
      o.move();
      o.display();
      center.attract(o);
    } 
  }
  fill(0);
  text(frameRate,20,20);
  text(orbList.size(),20,40);
}

void keyPressed() {
  if (keyCode == 32) {
    MODE++;
  } else if (key == BACKSPACE || key == DELETE) {
    orbList.clear();
  } else if (keyCode == 66) {
    b++;
  }
}
