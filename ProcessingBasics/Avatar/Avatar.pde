void avatar(int x, int y){
  //your code here
  fill(200);
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
  line(400, 400, 400, 450);
  //whiskers
  line(200, 410, 325, 450);
  line(200, 460, 325, 450);
  line(210, 520, 325, 450);
  line(475, 450, 600, 370);
  line(475, 450, 600, 450);
  line(475, 450, 600, 490);
  
//replace the rectangle with something better


}
int xp,yp;
void setup(){
  size(800,800);
  xp = 200;
  yp = 200;
}
void draw(){
  background(160, 140, 30);
  //avatar(xp,yp);
  //xp++;
  //yp++;
  avatar(xp,yp);
  //avatar(600,300);
}
