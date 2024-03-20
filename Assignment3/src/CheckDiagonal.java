import java.util.Arrays;

public class CheckDiagonal implements ICheck {
    private String [] symbols;
    private String type;







    public CheckDiagonal(Player p, int x, int y, Shape[][] J, String type) {
        this.type=type;
        if(J[x][y].getType().equals("/")){
            Check3(p,x,y,J,Mathsymbols);

        }
        else if(J[x][y].getType().equals("\\")){
            Check3(p,x,y,J,Mathsymbols);
        }
        else {
            symbols= new String[]{type, "W"};

            Check1(p,x,y,J,symbols);

        }

    }


    public void Check1(Player p,int x, int y, Shape[][] J,String[] symbols) {
        p.setValid(false);


        try {
            if(Arrays.asList(symbols).contains(J[x - 1][y - 1].getType())){
                if(Arrays.asList(symbols).contains(J[x - 2][y - 2].getType())){
                    p.setValid(true);
                    J[x][y].setType("0");
                    J[x - 1][y - 1].setType("0");
                    J[x - 2][y - 2].setType("0");
                    p.setPoint(J[x][y].getPoint()+J[x-1][y-1].getPoint()+J[x-2][y-2].getPoint());




                }
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
        if (!p.isValid()){
            Check2(p,x, y, J,symbols);
        }
    }

    @Override
    public void Check2(Player p,int x, int y, Shape[][] J,String [] symbols) {
        p.setValid(false);
        try {
            if(Arrays.asList(symbols).contains(J[x + 1][y + 1].getType())){
                if(Arrays.asList(symbols).contains(J[x + 2][y + 2].getType())) {
                    p.setValid(true);
                    J[x][y].setType("0");
                    J[x + 1][y + 1].setType("0");
                    J[x + 2][y + 2].setType("0");
                    p.setPoint(J[x][y].getPoint()+J[x+1][y+1].getPoint()+J[x+2][y+2].getPoint());

                }
            }

        }
        catch (IndexOutOfBoundsException ignored){

        }
        if(!p.isValid()|!type.equals("\\")){
            Check3(p,x, y, J,symbols);
        }
    }

    public void Check3(Player p, int x, int y, Shape[][] J, String[] symbols) {


        p.setValid(false);
        try {
            if(Arrays.asList(symbols).contains(J[x - 1][y + 1].getType())) {

                if (Arrays.asList(symbols).contains(J[x - 2][y + 2].getType())) {
                    p.setValid(true);
                    J[x][y].setType("0");
                    J[x - 1][y + 1].setType("0");
                    J[x - 2][y + 2].setType("0");
                    p.setPoint(J[x][y].getPoint()+J[x-1][y+1].getPoint()+J[x-2][y+2].getPoint());
                }
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        if(!p.isValid()){
            Check4(p,x, y, J,symbols);

        }
    }

    public void Check4(Player p,int x, int y, Shape[][] J,String[] symbols) {
        p.setValid(false);
        try {
            if(Arrays.asList(symbols).contains(J[x + 1][y - 1].getType())) {
                if (Arrays.asList(symbols).contains(J[x + 2][y - 2].getType())) {
                    p.setValid(true);
                    J[x][y].setType("0");
                    J[x + 1][y + 1].setType("0");
                    J[x + 2][y + 2].setType("0");
                    p.setPoint(J[x][y].getPoint()+J[x+1][y+1].getPoint()+J[x+2][y+2].getPoint());

                }
            }
        } catch (IndexOutOfBoundsException ignored) {

        }


    }
}
