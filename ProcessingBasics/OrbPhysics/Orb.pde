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
    ellipse(x,y,2*radius, 2*radius);
    line(x,y,x+5*xSpeed,y+5*ySpeed);
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
  }

  void move(){
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    x += xSpeed;
    y += ySpeed;

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
    
  }
  
  void bounce () {
    if (x >= width || x <= 0) {
      xSpeed *= -1;
    }
    x = xSpeed+x;
    if (y >= height || y <= 0) {
      ySpeed *= -1;
    }
  }
  
  void attract(Orb other) {
    float distance = dist(x,y,other.x,other.y);
    other.xSpeed += 20*((x-other.x)/(distance*distance));
    other.ySpeed += 20*((y-other.y)/(distance*distance));
  }
  
  void attractSpring(Orb other) {
    float distance = dist(x,y,other.x,other.y);
    float force = (distance - SPRING_LENGTH) * SPRING_CONSTANT;
    other.xSpeed += force * ((x-other.x) / distance);
    other.xSpeed *= SPRING_DAMPEN;
    
    other.ySpeed += force * ((y-other.y) / distance);
    other.ySpeed *= SPRING_DAMPEN;
  }
  
  void gravity() {
    ySpeed += 0.15;
  }
  
  void gravityOff() {
    ySpeed -= 0.15;
  }

  
}
