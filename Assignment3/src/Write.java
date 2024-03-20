import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Write {
    SlideDown sd=new SlideDown();
    public void AddBoard(ArrayList<String> arr,Shape [][] j){
        sd.slide(j);
        for (Shape[] jewels : j) {
            arr.add("\n");
            for (int k = 0; k < j.length; k++) {
                if (jewels[k].getType().equals("0"))
                    arr.add("  ");
                else {
                    arr.add(jewels[k].getType() + " ");
                }
            }

        }

        arr.add("\n");

    }
    public void WriteLeaderboard(Player p) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter("leaderboard.txt",true));
        bw.write("\n"+p.getName()+" "+p.getPoint());
        bw.close();
        }


  public void WriteMonitoring(ArrayList<String> p) throws IOException {
      BufferedWriter bw=new BufferedWriter(new FileWriter("monitoring.txt"));
      for(String line:p){
          bw.write(line);
      }
      bw.close();
  }





}
