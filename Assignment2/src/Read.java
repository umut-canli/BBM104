import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//komut dosyasini okumak icin bu kodu yazdim.
public class Read  {
    private String name="";
    private   ArrayList<String> commands=new ArrayList<String>();
    //bu kısım commands arraylistini geri cagirmak icin.
    public ArrayList<String> getCommands() {
        return commands;
    }
    //commands.txt bu kısımda okunuyor ve arrayliste kayıt ediliyor
    public Read(String name) throws FileNotFoundException {
        this.name = name;
        FileReader fr=new FileReader(name);
        Scanner scan=new Scanner(fr);
        while(scan.hasNextLine()) {
            commands.add(scan.nextLine());
        }
    }





}
