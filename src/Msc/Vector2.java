package Msc;

public class Vector2 {

    private float x,y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String toString()
    {
        return ("x:{"+x+"} y:{"+y+"}");
    }

    public Vector2 multiply(float multiple) {
        return new Vector2(x*multiple,y*multiple);
    }
    public Vector2 multiply(Vector2 vector2) {
        return new Vector2(x*vector2.x,y*vector2.y);
    }

    public Vector2 getNegative(){
        return new Vector2(y,x);
    }

    public Vector2 devide(float a){
        return new Vector2(x/a,y/a);
    }

    public Vector2 add(Vector2 vector2) {
        return new Vector2(x+ vector2.x,y+ vector2.y);
    }

    public Vector2 getDirection(double angle) {
        int a;
        int b=1;
        float x = (float) Math.cos(Math.toRadians(angle));
        float y = (float) Math.sin(Math.toRadians(angle));
        //a = (int) Math.tan(90-angle);
        System.out.println(Math.cos(angle));
        return new Vector2(-x,-y);
    }

    public Vector2 getNormelized()
    {
        return devide(getHighest());
    }

    private float getHighest() {
        return Math.max(Math.abs(x), Math.abs(y));
    }

}
