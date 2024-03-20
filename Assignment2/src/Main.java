import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String turn;
        int roll;
        String [] komut;
        PropertyJsonReader proprty=new PropertyJsonReader();
        // oyunculari olusturup commands.txt yi okudum.
        Read cmnds=new Read(args[0]);
        Player player1=new Player("Player 1");
        Player player2=new Player("Player 2");
        for(String a: cmnds.getCommands()){
            komut=a.split(";");
            // eger oyuncu iflas etmisse diger komutlari okumadan oyunu bitiriyor.
            if((player1.isBankrupt()==true) ||(player2.isBankrupt()==true)){
                break;
            }
            // eger komutun uzunlugu 1 ise(Show) show komutu icin yazdigim kodu cagiriyor.
            if(komut.length==1){
                Write.show(player1,player2);
            }
            else{
                turn=komut[0];
                roll=Integer.parseInt(komut[1]);
                Game.dice=Integer.parseInt(komut[1]);
                if(turn.equals("Player 1")){
                    if(player1.getCeza()==0){
                        player1.setLocation(Game.dice);
                        Game.Playing(player1,player2);
                        Write.add(player1,player2);

                    }
                    else{
                        player1.setCeza(-1);
                        Game.process= player1.getName()+" in jail (count=" + (3 - player1.getCeza()) + ")";
                        Write.add(player1,player2);

                    }



                }
                else{
                    if (player2.getCeza()==0){
                        player2.setLocation(roll);
                        Game.Playing(player2,player1);
                        Write.add(player2,player1);

                    }
                    else {
                        player2.setCeza(-1);
                        Game.process= player2.getName()+" in jail (count=" + (3 - player2.getCeza()) + ")";
                        Write.add(player2,player1);
                    }


                }

            }
        }
        Write.show(player1,player2);


        Write.yaz();
    }

}
