import java.io.IOException;

public class CheckJoker implements ICheck {
    public CheckJoker(Player p, int x, int y, Shape[][] J) throws IOException {
        CheckVertical ct=new CheckVertical(p,x, y, J,"W");
        if(!p.isValid()){

            CheckHorizontal cs=new CheckHorizontal(p,x,y,J,"W");
            if(!p.isValid()){
                CheckDiagonal cd=new CheckDiagonal(p,x,y,J,"W");
            }


        }

    }


    @Override
    public void Check1(Player p,int x, int y, Shape[][] J, String[] symbols) {

    }

    @Override
    public void Check2(Player p,int x, int y, Shape[][] J, String[] symbols) {

    }
}
