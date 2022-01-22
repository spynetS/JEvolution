package Msc;

public class Vector2 {

    private int x,y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString()
    {
        return ("x:{"+x+"} y:{"+y+"}");
    }

    public Vector2 multiply(int multiple) {
        return new Vector2(x*multiple,y*multiple);
    }
    public Vector2 multiply(Vector2 vector2) {
        return new Vector2(x*vector2.x,y*vector2.y);
    }

    public Vector2 getNegative(){
        return new Vector2(y,x);
    }

    public Vector2 add(Vector2 vector2) {
        return new Vector2(x+ vector2.x,y+ vector2.y);
    }

    public Vector2 getDirection(double angle) {
        int a;
        int b=1;

        a = (int) Math.tan(angle);

        return new Vector2(a,b);
    }

}
