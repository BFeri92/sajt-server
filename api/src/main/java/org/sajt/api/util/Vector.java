package org.sajt.api.util;

public class Vector {

    private long x;
    private long y;

    public Vector() {
    }

    public Vector(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }
}
