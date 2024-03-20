public class Company extends Properties{
    private String name,type="Company",belongs="none";
    private int cost;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }





    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getBelongs() {
        return belongs;
    }

    @Override
    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public Company(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
