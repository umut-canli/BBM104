import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("monitoring.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        String [] pl,fl,sl,cl;
        String Name,Gender;
        int Weight,Height,Birth,ID,ID2,count = 0,Calorie,all_c;
        double porsion;
        Personfile IDp;
        Foodfile IDf;
        Sportfile IDs;
        ArrayList<Personfile> p_list=new ArrayList<>();
        ArrayList<Foodfile> f_list= new ArrayList<>();
        ArrayList<Sportfile> s_list=new ArrayList<>();
        ArrayList<Personfile> print_list=new ArrayList<>();

        FileReader fr=new FileReader("people.txt");
        Scanner scan=new Scanner(fr);
        while(scan.hasNextLine()){
            pl=scan.nextLine().split("\t");
            ID=Integer.parseInt(pl[0]);
            Name=pl[1];
            Gender=pl[2];
            Weight=Integer.parseInt(pl[3]);
            Height=Integer.parseInt(pl[4]);
            Birth=Integer.parseInt(pl[5]);
            IDp = new Personfile(ID,Name,Gender,Weight,Height,Birth);
            p_list.add(IDp);
        }
        FileReader readf=new FileReader("food.txt");
        Scanner scanf=new Scanner(readf);
        while(scanf.hasNextLine()) {
            fl=scanf.nextLine().split("\t");
            ID=Integer.parseInt(fl[0]);
            Name=fl[1];
            Calorie=Integer.parseInt(fl[2]);
            IDf=new Foodfile(ID,Name,Calorie);
            f_list.add(IDf);
        }
        FileReader reads=new FileReader("sport.txt");
        Scanner scans=new Scanner(reads);
        while(scans.hasNextInt()) {
            sl=scans.nextLine().split("\t");
            ID=Integer.parseInt(sl[0]);
            Name=sl[1];
            Calorie=Integer.parseInt(sl[2]);
            IDs=new Sportfile(ID,Name,Calorie);
            s_list.add(IDs);
        }
        FileReader readc=new FileReader(args[0]);
        Scanner scanc=new Scanner(readc);
        while(scanc.hasNextLine()) {

            cl = scanc.nextLine().split("\t");
            if((cl[0].endsWith(")"))){
                ID=Integer.parseInt(cl[0].substring(6,11));
                for(Personfile p:p_list){
                    if(p.getID()==ID){
                        System.out.println();
                        bw.write(p.getName()+"\t"+(2022-p.getBirth())+"\t"+
                                p.dailycalorie()+"kcal\t"+p.getGet_calorie()+"kcal\t"+p.getGive_calorie()+"kcal\t"
                                +p.Needcal()+"kcal");
                        bw.newLine();
                    }
                }

            }
            else if(cl[0].endsWith("t")){
                for(Personfile p:print_list){
                    bw.write(p.getName()+"\t"+(2022-p.getBirth())+"\t"+
                            p.dailycalorie()+"kcal\t"+p.getGet_calorie()+"kcal\t"+p.getGive_calorie()+"kcal\t"
                            +String.format("%+d",p.Needcal())+"kcal");
                    bw.newLine();
                }

            }
            else if(cl[0].endsWith("n")){
                for(Personfile p:print_list){
                    if(p.Needcal()>0){
                        bw.write(p.getName()+"\t"+(2022-p.getBirth())+"\t"+
                                p.dailycalorie()+"kcal\t"+p.getGet_calorie()+"kcal\t"+p.getGive_calorie()+"kcal\t"
                                +String.format("%+d",p.Needcal())+"kcal");
                        bw.newLine();
                        count+=1;
                    }

                }
                if(count==0) {
                    bw.write("there\tis\tno\tsuch\tperson");
                    bw.newLine();
                }
            }
            else{
                ID = Integer.parseInt(cl[0]);
                ID2 = Integer.parseInt(cl[1]);
                porsion = Double.parseDouble(cl[2]);

                for(Personfile p:p_list){
                    if(ID==p.getID()){
                        if(!print_list.contains(p)){
                            print_list.add(p);
                        }
                        if(ID2/1000==1){
                            for(Foodfile f:f_list)
                                if (f.getID() == ID2) {
                                    all_c = (int) (f.getCalorie() * porsion);
                                    p.setGet_calorie(all_c);
                                    bw.write(p.getID() + "\thas\ttaken\t" + all_c + "kcal\tfrom\t" + f.getName());
                                }
                        }
                        else if(ID2/1000==2){
                            for(Sportfile s:s_list){
                                if(s.getID()==ID2){
                                    all_c=(int) (s.getCalorie()*(porsion/60));
                                    p.setGive_calorie(all_c);
                                    bw.write(p.getID()+"\thas\tburned\t"+all_c+"kcal\tthanks to\t"+s.getName());
                                }
                            }

                        }
                        bw.newLine();





                    }
                }

            }
            if (scanc.hasNextLine()){
                bw.write("***************");bw.newLine();
            }

        }
        bw.close();



    }

}
