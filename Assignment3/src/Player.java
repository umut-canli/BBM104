public class Player  implements Comparable<Player> {
    private final String name;
    private int point,oldpoint;
    private boolean valid=true;
    public int pointsperround(){
        if(valid){
            return point-oldpoint;

        }
        else return 0;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }


    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        oldpoint=this.point;
        this.point += point;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getPoint(), this.point);
    }
}
