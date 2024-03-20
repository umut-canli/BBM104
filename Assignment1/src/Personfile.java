public class Personfile {
    private String name,gender;
    private int ID,weight,height,birth,get_calorie,give_calorie;
    public Personfile(int ID, String name, String gender, int weight, int height, int birth){
        this.ID=ID;
        this.name=name;
        this.gender=gender;
        this.weight=weight;
        this.height=height;
        this.birth=birth;

    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getBirth() {
        return birth;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGet_calorie(int get_calorie) {
        this.get_calorie += get_calorie;
    }

    public void setGive_calorie(int give_calorie) {
        this.give_calorie += give_calorie;
    }

    public int getGet_calorie() {
        return get_calorie;
    }

    public int getGive_calorie() {
        return give_calorie;
    }
    public long dailycalorie(){
        if(gender.equals("male")){
            return Math.round(66+((13.75)*getWeight())+5*(getHeight())-6.8*(2022-getBirth()));
        }
        else{
            return Math.round((665+(9.6*getWeight())+(1.7*getHeight())-4.7*(2022-getBirth())));
        }
    }

    public int Needcal() {
        return (int)(getGet_calorie()-getGive_calorie()-dailycalorie());
    }
}
