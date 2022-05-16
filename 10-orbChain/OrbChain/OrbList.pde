public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
  *complete this method
  */
  void add(OrbNode orb){
    last.prev.next = orb;
    orb.prev = last.prev;
    orb.next = last;
    last.prev = orb;
    
    //orb.prev = last.prev;
    //orb.prev.next = orb;
    //orb.next = last;
    //last.prev = orb;
    
    //insert orb at the end of the list before the last node.
  }

  /**
  *complete this method
  *process all nodes by running move.
  */
  void processAll() {
    OrbNode current = first;
    while (current != null) {
      current.move();
      current = current.next;
    }
    //advance current to next until it is null, move() each of the nodes
  }
  /**
  *complete this method
  *Display all nodes by running their display().
  */
  void display() {
    OrbNode current = first;
    while (current != null) {
      current.display();
      current = current.next;
    }
    //advance current to next until it is null, display() each of the nodes
  }
  void add(int xcor, OrbNode orb) {
    OrbNode current = first.next;
    while (current.x < xcor && current.next != null ) {
      current = current.next;
    }
     orb.prev = current.prev;
     orb.prev.next = orb;
     orb.next = current;
     current.prev = orb;
  }
  
  void delete(OrbNode target) {
   target.prev.next = target.next;
   target.next.prev = target.prev;
  }
  
  OrbNode getNodeAt(int x, int y) {
    OrbNode current = first.next;
    while (current.next != null && current.next.x < x) {
      current = current.next;
    }
    float distance = dist(x,y,current.x,current.y);
    if (current.radius >= distance) {
      return current;
    }  else {
      return null;
    }
  }
  
}
