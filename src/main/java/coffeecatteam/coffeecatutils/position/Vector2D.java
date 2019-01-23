package coffeecatteam.coffeecatutils.position;

/**
 * @author CoffeeCatRailway
 * Created: 29/11/2018
 */
public class Vector2D {

    public double x, y;

    public Vector2D() {
        this(0.0d, 0.0d);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    @Override
    public String toString() {
        return "Vector2D(" + x + ", " + y + ")";
    }

    /**
     * @return The magnitude of vector
     */
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * @param mag New magnitude
     * @return The magnitude of vector
     */
    public Vector2D setMagnitude(double mag) {
        return this.normalize().mult(mag);
    }

    public double magnitudeSqrt() {
        return x * x + y * y;
    }

    /**
     * @param in Target vector to add to in
     * @return Sum of both vectors
     */
    public Vector2D add(Vector2D in) {
        this.x += in.x;
        this.y += in.y;
        return this;
    }

    public Vector2D add(double amt) {
        return add(new Vector2D(amt, amt));
    }

    public Vector2D add(double x, double y) {
        return add(new Vector2D(x, y));
    }

    /**
     * @param in Target vector to sub to in
     * @return Subtract of both vectors
     */
    public Vector2D sub(Vector2D in) {
        this.x -= in.x;
        this.y -= in.y;
        return this;
    }

    public Vector2D sub(double amt) {
        return sub(new Vector2D(amt, amt));
    }

    public Vector2D sub(double x, double y) {
        return sub(new Vector2D(x, y));
    }

    /**
     * @param in Target vector to multiply to in
     * @return Multiply of both vectors
     */
    public Vector2D mult(Vector2D in) {
        this.x *= in.x;
        this.y *= in.y;
        return this;
    }

    public Vector2D mult(double amt) {
        return mult(new Vector2D(amt, amt));
    }

    public Vector2D mult(double x, double y) {
        return mult(new Vector2D(x, y));
    }

    /**
     * @param in Target vector to divide to in
     * @return Divide of both vectors
     */
    public Vector2D div(Vector2D in) {
        this.x /= in.x;
        this.y /= in.y;
        return this;
    }

    public Vector2D div(double amt) {
        return div(new Vector2D(amt, amt));
    }

    public Vector2D div(double x, double y) {
        return div(new Vector2D(x, y));
    }

    /**
     * @return Normalized vector
     */
    public Vector2D normalize() {
        double length = Math.sqrt(this.x * this.x + this.y * this.y);
        if (length != 0) {
            this.x /= length;
            this.y /= length;
        }

        return this;
    }

    /**
     * @param in Target vector to get dot product
     * @return Dot product of vector and in
     */
    public double dotProduct(Vector2D in) {
        return this.x * in.x + this.y * in.y;
    }

    public Vector2D limit(double a) {
        double b = this.magnitudeSqrt();
        return b > a * a ? this.div(Math.sqrt(b)).mult(a) : this;
    }

    /**
     * @return Copy of vector
     */
    public Vector2D copy() {
        Vector2D vec = new Vector2D(this.x, this.y);
        return vec;
    }

    /**
     * @param in The vector to get the distance from
     * @return The distance from vector to in
     */
    public double getDistanceFrom(Vector2D in) {
        double x = in.x - this.x;
        double y = in.y - this.y;

        double distance = Math.sqrt(x * x + y * y);
        return distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2D) {
            Vector2D vec = (Vector2D) obj;
            return vec.x == this.x && vec.y == this.y;
        } else {
            return false;
        }
    }
}
