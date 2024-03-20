public class Land extends Properties{
    private  String belongs="none";
    private String name,type="Land";
    private int cost;

    public int getRent() {
        if(cost<2000){
            return cost*40/100;
        }
        else if(cost>2000 & cost<3000){
            return cost*30/100;
        }
        else {
            return cost*35/100;
        }
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getBelongs() {
        return belongs;
    }

    @Override
    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public Land(String name, int cost) {
        this.name = name;
        this.cost=cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }


    @Override
    public int getCost() {
        return cost;
    }

}
