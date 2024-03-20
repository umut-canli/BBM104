import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    public Game(String txt)throws IOException {
        Read r=new Read(txt);
        ArrayList<String > output=new ArrayList<>();
        Write w=new Write();
        Shape[][] board=r.getBoard();
        ArrayList<String> commands=r.getCommmands();
        List<String> leaderboard=r.getLeaderboard();
        String name=commands.get(commands.size()-1);
        Player p1=new Player(name,0);
        r.setPlayers(p1);
        Checkinterface ch=new Checkinterface();



        output.add("Game grid:\n");w.AddBoard(output,board);


        for (String command : commands) {
            String[] line = command.split(" ");

            if (line.length == 2) {
                int first = Integer.parseInt(line[0]);
                int second = Integer.parseInt(line[1]);
                String type=board[first][second].getType();
                output.add("\nSelect coordinate or enter E to end the game :" + first + " " + second + "\n");

                if(type.equals("D")|type.equals("/")|type.equals("\\")){
                    ch.setiCheck(new CheckDiagonal(p1,first,second,board,type));
                    w.AddBoard(output, board);
                    output.add("\nScore : "+p1.pointsperround()+" points\n");

                }else if(type.equals("T")|type.equals("|")){
                    ch.setiCheck(new CheckVertical(p1,first, second, board, type));
                    w.AddBoard(output, board);
                    output.add("\nScore : "+p1.pointsperround()+" points\n");


                }else if(type.equals("S")|type.equals("-")|type.equals("+")){
                    ch.setiCheck(new CheckHorizontal(p1,first, second, board, type));
                    w.AddBoard(output, board);
                    output.add("\nScore : "+p1.pointsperround()+" points\n");

                }else if(type.equals("W")){
                    ch.setiCheck(new CheckJoker(p1,first, second, board));
                    w.AddBoard(output, board);
                    output.add("\nScore: "+p1.pointsperround()+" points\n");

                }



                else {
                    output.add("\nPlease enter a valid coordinate\n");
                }





            } else {
                if (line[0].equals("E")) {
                    output.add("\nSelect coordinate or enter E to end the game: E\n\nTotal score: "+p1.getPoint()+" points\n\nEnter name: " + name+"\n");
                }

            }


        }
        Collections.sort(r.getPlayers());
        if(r.getPlayers().indexOf(p1)==0){
            output.add("\nYour rank is 1/"+r.getPlayers().size()+", your score is "+(p1.getPoint()-r.getPlayers().get(1).getPoint())+" points higher than "+r.getPlayers().get(1).getName());
        }
        else  if(r.getPlayers().get(r.getPlayers().size()-1).getName().equals(p1.getName()) ){
            output.add("\nYour rank is "+ r.getPlayers().size()+"/"+r.getPlayers().size()+", your score is "+r.getPlayers().get(r.getPlayers().size()-2).getPoint()+" points lower than "+r.getPlayers().get(r.getPlayers().size()-2).getName());


        }
        else{
            output.add("\nYour rank is "+ (r.getPlayers().indexOf(p1)+1)+"/"+r.getPlayers().size()+", your score is "+(r.getPlayers().get(r.getPlayers().indexOf(p1)-1).getPoint()-p1.getPoint())+" points lower than "+r.getPlayers().get(r.getPlayers().indexOf(p1)-1).getName()
                    +" and "+(p1.getPoint()-r.getPlayers().get(r.getPlayers().indexOf(p1)+1).getPoint())+" points higher than "+(r.getPlayers().get(r.getPlayers().indexOf(p1)+1).getName()));
        }
        output.add("\n" + "\nGood bye!");
        w.WriteLeaderboard(p1);
        w.WriteMonitoring(output);


    }





}
