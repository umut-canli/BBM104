
public class Checkinterface  {
    private  ICheck iCheck;

    public Checkinterface() {
    }

    public Checkinterface(ICheck iCheck) {
        this.iCheck = iCheck;
    }


    public void setiCheck(ICheck iCheck) {
        this.iCheck = iCheck;
    }
}
