public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this(0, 0 ); // gan x = 0, y = 0
    }

    public Vector2D(double X, double Y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void substract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate) {
        this.x *= rate;
        this.y *= rate;
    }
    public Vector2D clone() {
        return new Vector2D(x, y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }
    public void setLength(double length) {
        double oldlength = this.getLength();
        if(oldlength != 0) {
            x = x * length / oldlength;
            y = y * length / oldlength;
        }
    }
    public double getAngle() {
        return Math.atan(y / x);
    }
    public void setAngle(double angle){
        double length = this.getLength();
        if(length != 0) {
            x = Math.cos(angle) * length;
            y = Math.sin(angle) * length;
        }
    }
    public static void main(String[] args) {
//        Math.sqrt();
//        Math.pow();
//        Math.sin(Math.PI / 4); ~ m
//        Math.asin(m); ~ Math.PI / 4
        Vector2D v1 = new Vector2D(3, 3);
        System.out.println(v1.getLength() + " " + Math.sqrt(18)); // ~4,2
        System.out.println(v1.getAngle() + " " + (Math.PI / 4));// Math.PI / 4

        v1.setLength(10);
        System.out.println(v1.getLength() + " " + 10);// 10
        v1.setAngle(Math.PI / 6);
        System.out.println(v1.getAngle() + " " + (Math.PI / 6)); //Math.PI/6




    }
}
