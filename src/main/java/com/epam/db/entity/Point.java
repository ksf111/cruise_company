package com.epam.db.entity;


public class Point {
    String name;

    public Point(String name) {
        this.name = name;
    }

    public Point() {
    }

    public static PointBuilder builder() {
        return new PointBuilder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Point)) return false;
        final Point other = (Point) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Point;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "Point(name=" + this.getName() + ")";
    }

    public static class PointBuilder {
        private String name;

        PointBuilder() {
        }

        public PointBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Point build() {
            return new Point(name);
        }

        public String toString() {
            return "Point.PointBuilder(name=" + this.name + ")";
        }
    }
}
