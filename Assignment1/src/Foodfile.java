public class Foodfile {
    private String name;
    private int calorie,ID;
    public Foodfile(int ID, String name, int calorie){
        this.ID=ID;
        this.calorie=calorie;
        this.name=name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getCalorie() {
        return calorie;
    }


}
