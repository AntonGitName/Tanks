package tanks.model;

public class Tank extends MovableObject {
        
    public Tank(int id, Vector2D p, int w, int h, char c, Vector2D s) {
        super(id, p, w, h, c, s);
    }
    
    public Projectile fire(int freeID) {
        Vector2D pos = new Vector2D(position.getX(), position.getY());
        //pos.setX(pos.getX() + width / 2 + speed.getX());
        //pos.setY(pos.getY() + width / 2 + speed.getY());
        return new Projectile(freeID, pos, speed.mul(2), '*');
    }    
    
    public void setPosition(Vector2D p) {
        super.setPosition(p);
        setSpeed(new Vector2D(0, 0));
    }
    
}
