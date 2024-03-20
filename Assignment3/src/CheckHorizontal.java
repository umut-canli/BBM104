import java.util.Arrays;

public class CheckHorizontal implements ICheck {

    private String [] symbols;


    public CheckHorizontal(Player p, int x, int y, Shape[][] J, String type)  {
        if(type.equals("")){
            Check1(p, x, y, J, Mathsymbols);
        }
        else if(type.equals("+")){
            Check1(p, x, y, J, Mathsymbols);
            if (!p.isValid()) {
                CheckVertical ct = new CheckVertical(p, x, y, J, "+");
            }
        }
        else if(type.equals("W")) {
            Check1(p, x, y, J, allsymbols);
        }
        else {
            symbols = new String[]{type, "W"};
            Check1(p, x, y, J, symbols);
        }

    }

    @Override
    public void Check1(Player p,int x, int y, Shape[][] J,String[] symbols) {
        p.setValid(false);
        try {
            if(Arrays.asList(symbols).contains(J[x][y - 1].getType())){
                if(Arrays.asList(symbols).contains(J[x][y - 2].getType())){

                    J[x][y].setType("0");
                    J[x ][y - 1].setType("0");
                    J[x ][y - 2].setType("0");
                    p.setValid(true);
                    p.setPoint(J[x][y].getPoint()+J[x][y-1].getPoint()+J[x][y-2].getPoint());


                }
            }

        } catch (IndexOutOfBoundsException ignored) {
        }
        if (!p.isValid()){
            Check2(p,x, y, J,symbols);
        }


    }

    @Override
    public void Check2(Player p,int x, int y, Shape[][] J,String[] symbols) {
        p.setValid(false);

        try {

            if(Arrays.asList(symbols).contains(J[x][y + 1].getType())){
                if(Arrays.asList(symbols).contains(J[x][y + 2].getType())){
                    p.setValid(true);
                    J[x][y].setType("0");
                    J[x ][y + 1].setType("0");
                    J[x ][y + 2].setType("0");
                    p.setPoint(J[x][y].getPoint()+J[x][y+1].getPoint()+J[x][y+2].getPoint());


                }
            }

        } catch (IndexOutOfBoundsException ignored) {

        }
    }
}
