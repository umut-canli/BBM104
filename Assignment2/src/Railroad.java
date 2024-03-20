public class Railroad extends Properties {
    private String belongs="none";
    private String name,type="Railroad";
    private int cost;

    public Railroad( String name, int cost) {
        this.name = name;
        this.cost=cost;
    }

    @Override
    public String getBelongs() {
        return belongs;
    }

    @Override
    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
