import java.io.IOException;

public abstract class Shape {
    private String type;
    private final int Point;

    public int getPoint() {
        return Point;
    }

    public Shape(String type, int Point) throws IOException {
        this.type=type;
        this.Point=Point;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
