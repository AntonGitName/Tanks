package tanks.model;

public class Projectile extends MovableObject {
    
    public static final int size = 1;
    
    public Projectile(int id, Vector2D p, Vector2D s, char c) {
        super(id, p, size, size, c, s);
    }
    
}
