public class Sportfile {

    private int ID,calorie;
    private String name;

    public Sportfile(int ID, String name, int calorie){
        this.ID=ID;
        this.calorie=calorie;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getCalorie() {
        return calorie;
    }

    public int getID() {
        return ID;
    }
}
