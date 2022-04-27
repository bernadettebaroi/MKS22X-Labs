public class Orb{
  float x,y;
  float xSpeed,ySpeed;
  float radius;
  color c;

  public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255),random(255),random(255));
  }
  
  
  void display(){
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    fill(c);
    ellipse(x,y,radius, radius);
    //line(x/2,y/2,5*xSpeed,5*ySpeed);
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
  }

  void move(){
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (x >= width || x <= 0) {
      xSpeed *= -1;
    }
    x = xSpeed+x;
    if (y >= height || y <= 0) {
      ySpeed *= -1;
    }
    y = ySpeed+y;

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    ySpeed += .15;
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
    
  }
  
  void attract(Orb other) {float distance = dist(x,y,other.x,other.y);
    other.xSpeed += 0.003*((x-other.x)/distance*distance);
    other.ySpeed += 0.003*((y-other.y)/distance*distance);
  }
}
