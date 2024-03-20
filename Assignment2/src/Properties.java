public class Properties {
    private String belongs="none",name,type="none";
    private int cost,rent;

    public int getRent() {
        return rent;
    }

    public String getType() {
        return type;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public String getBelongs() {
        return belongs;
    }

    public void setType(String type) {
        this.type = type;
    }
}
