import java.io.*;
import java.util.*;

public class Read  {
    private ArrayList<String> commmands=new ArrayList<>();
    private List<String> leaderboard=new ArrayList<>();
    private ArrayList<Player> players=new ArrayList<>();
    private Shape [][] board=new Shape[10][10];


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player player) {
        players.add(player);
    }

    public ArrayList<String> getCommmands() {
        return commmands;
    }


    public Shape[][] getBoard() {
        return board;
    }


    public Read(String txt) throws IOException {
        data(txt);
        data("leaderboard.txt");
        readcommand();
    }

    public void data(String txt) throws IOException {
        Scanner scan=new Scanner((new FileReader(txt)));

        while(scan.hasNextLine()){
            if(txt.equals("leaderboard.txt")){
                leaderboard=Arrays.asList(scan.nextLine().split(" "));
                players.add(new Player(leaderboard.get(0),Integer.parseInt(leaderboard.get(1))));

            }
            else{
                for(int i=0;i<board.length;i++) {
                    String[] line = scan.nextLine().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        String type=line[j];
                        if (type.equals("D")) {
                            board[i][j] = new Diamond("D",30);
                        } else if (type.equals("S")) {
                            board[i][j] = new Square("S",15);
                        } else if (type.equals("T")) {
                            board[i][j] = new Triangle("T",15);
                        } else if (type.equals("W")) {
                            board[i][j] = new Wildcard("W",10);
                        }else  if(type.equals("/")|type.equals("|")|type.equals("-")|type.equals("+")|type.equals("\\")|type.equals("/")) {
                            board[i][j] = new Math(type, 20);
                        }


                        }
                    }
                }
            }
        }

    public void readcommand() throws IOException{
        Scanner scan=new Scanner(new FileReader("command.txt"));
        while (scan.hasNextLine()){
            commmands.add(scan.nextLine());
        }


    }

    public List<String> getLeaderboard() {
        return leaderboard;
    }

}
