import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Write extends Game{
    public static ArrayList<String > proccessing=new ArrayList<>();
    //"Game" classi sayesinde oyunu oynarken "Write" classiyla oyunu kayit ediyorum.
    //Burada "Game" classindan aldigim "process" ozel mesajlarini "proccessing" arraylistine oyuncunun adini,parasini vs ekliyorum.
    public static void add(Player p1,Player p2){
        if(p1.getName().equals("Player 1")) {
            if(p1.getCeza()==3){
                proccessing.add(p1.getName() + "\t" + dice + "\t" + p1.getLocation() + "\t" + p1.getMoney() + "\t" +
                        p2.getMoney() +"\t"+p1.getName()+ " went to jail");
            }
            else if (p1.getCeza() != 0) {
                proccessing.add(p1.getName() + "\t" + dice + "\t" + p1.getLocation() + "\t" + p1.getMoney() + "\t" +
                        p2.getMoney() + "\t" + process);
            }

            else {
                proccessing.add(p1.getName() + "\t" + dice + "\t" + p1.getLocation() + "\t" + p1.getMoney() + "\t" +
                        p2.getMoney() + "\t" + process);
            }

        }
        else{
            //Eger oyuncu jaildeyse ona ozel mesaj yaziyorum.
            if(p1.getCeza()==3){
                proccessing.add(p1.getName() + "\t" + dice + "\t" + p1.getLocation() + "\t" + p2.getMoney() + "\t" +
                        p1.getMoney() +"\t"+p1.getName()+" went to jail");

            }
            else if(p1.getCeza()!=0){
                proccessing.add(p1.getName() + "\t" + dice + "\t" + p1.getLocation() + "\t" + p2.getMoney() + "\t" +
                        p1.getMoney() + "\t" +process);
            }
            else{
                proccessing.add(p1.getName() + "\t" + dice + "\t" + p1.getLocation() + "\t" + p2.getMoney() + "\t" +
                        p1.getMoney() + "\t" + process);
            }

        }
        proccessing.add("\n");

    }
    //"Show" komutu icin ayri bir method yazdim.
    public static void show(Player p1,Player p2){
        proccessing.add("-----------------------------------------------------------------------------------------------------------\n");
        proccessing.add(p1.getName()+"\t"+p1.getMoney()+"\thave: "+p1.getProp().toString().replace("[","").replace("]","")+"\n");
        proccessing.add(p2.getName()+"\t"+p2.getMoney()+"\thave: "+p2.getProp().toString().replace("[","").replace("]","")+"\n");
        proccessing.add("Banker\t"+(130000-(p1.getMoney()+p2.getMoney()))+"\n");
        if(p1.getMoney()>p2.getMoney()) {
            proccessing.add("Winner " + p1.getName()+"\n");
            proccessing.add("-----------------------------------------------------------------------------------------------------------\n");

        }
        else {
            proccessing.add("Winner "+p2.getName()+"\n");
            proccessing.add("-----------------------------------------------------------------------------------------------------------\n");
        }



    }
    //"proccessing" arraylistine butun mesajlari ekledikten sonra output.txt dosyasina yaziyorum
    public static void yaz() throws IOException {
        BufferedWriter bw =new BufferedWriter(new FileWriter("monitoring.txt"));
        for(String s:proccessing){
            bw.write(s);
        }
        bw.close();
    }

}
