import java.util.Arrays;

public class CheckVertical implements ICheck {

    private String [] symbols;
    public CheckVertical(Player p, int x, int y, Shape[][] J, String type) {
        if(type.equals("W")){
            Check1(p, x, y, J, allsymbols);
        }else if(type.equals("+")|type.equals("|")){
            Check1(p, x, y, J, Mathsymbols);
        }else {
            symbols = new String[]{type, "W"};
            Check1(p, x, y, J, symbols);
        }


    }



    @Override
    public void Check1(Player p,int x, int y, Shape[][] J,String[] symbols) {
        p.setValid(false);
        try {
            if(Arrays.asList(symbols).contains(J[x - 1][y].getType())){
                if(Arrays.asList(symbols).contains(J[x - 2][y].getType())){
                    p.setValid(true);
                    p.setPoint(J[x][y].getPoint()+J[x-1][y].getPoint()+J[x-2][y].getPoint());
                    J[x][y].setType("0");
                    J[x - 1][y ].setType("0");
                    J[x - 2][y ].setType("0");



                }
            }

        } catch (IndexOutOfBoundsException ignored) {
        }
        if(!p.isValid()){
            Check2(p,x, y, J,symbols);
        }


    }


    @Override
    public void Check2(Player p,int x, int y, Shape[][] J,String[] symbols) {
        p.setValid(false);

        try {
            if(Arrays.asList(symbols).contains(J[x + 1][y].getType())){
                if(Arrays.asList(symbols).contains(J[x + 2][y].getType())){
                    p.setValid(true);
                    J[x][y].setType("0");
                    J[x +1][y ].setType("0");
                    J[x + 2][y ].setType("0");
                    p.setPoint(J[x][y].getPoint()+J[x+1][y].getPoint()+J[x+2][y].getPoint());
                }
            }
        } catch (IndexOutOfBoundsException ignored) {

        }


    }
}
