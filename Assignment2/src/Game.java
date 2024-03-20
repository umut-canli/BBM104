import java.util.HashMap;

public   class Game {
    public static int Comcount, chanceCount,dice;
    public static Properties square;
    public static HashMap<Integer,Properties> prprty=PropertyJsonReader.lnd;
    public static String process;
//Burasi aslinda monopoly oyunun beyni butun komutlari burada işliyorum.
    public static void Playing(Player p1, Player p2) {
    //ilk basta mainde Playing methodunu çagirdiktan sonra oyuncunun hangi karede olduguna göre işlemleri yapiyorum.
        int location=p1.getLocation();
        // kolaylik olmasi icin "square"ye oyuncunun konumundaki  propery.json classindan aldigim propertyleri atadım
        // Ayrica burada bazi durumlar harici player classinda olusturdugum ozel methodlari cagirdim(Go,pay tax vs.)
        square =prprty.get(p1.getLocation());
        if(p1.getCeza()==0){
            if(location==1){
                //her bir olasiliktan sonra "process" ile o olasiligin ozel mesajini kayit aliyorum.Daha sonra da Write classiyla yaziyorum
                process=p1.getName()+" is in GO square";
            }
            else if(location==3 || location==18 || location==34){
                if(Comcount==0){
                    p1.advancetogo();
                }
                else if(Comcount==1 ){
                    p1.bankerror();


                }
                else if(Comcount==2){
                    p1.doctorfee();
                }
                //Burada dikkat ettigim sey , oyuncunun yeterli parasinin olup olmadigina bakmakti.
                //"buyandrent" classini kullanarak oyuncunun parasini sorguluyorum.Egere yeterli parasi yoksa iflas ediyor
                else if(Comcount==3){
                    Buyandrent.check(p1,p2,10);
                    process= p1.getName()+" draw Community Chest -It is your birthday";

                }
                else if(Comcount==4){
                    Buyandrent.check(p2,p1,50);
                    process=p1.getName()+" draw Community Chest -Grand Opera Night";

                }
                else if(Comcount==5){
                    p1.refund();

                }
                else if(Comcount==6){
                    p1.life();

                }
                else if(Comcount==7){
                    p1.hospfee();
                }
                else if(Comcount==8){
                    p1.schfee();

                }
                else if(Comcount==9){
                    p1.inherit();


                }
                else if(Comcount==10){
                    p1.salestock();

                }
                //Community chest count
                Comcount++;
            }
            else if(location==31){
                p1.jail();
            }
            else if(location==5){
                p1.tax();

            }
            else if(location==8 ||location==23 ||location==37){
                if(chanceCount==0){
                    p1.advancetogo2();
                }
                //Leicester square icin 3 durum vardi.Leicester square kimsenin degil,benim veya karsi oyuncunun.
                //Bu 3 duruma gore kodumu yazdim
                else if(chanceCount==1){
                    p1.Go(27);
                    square =prprty.get(p1.getLocation());

                    if (square.getBelongs().equals(p2.getName())){
                        Buyandrent.Leicester(p2,p1, square);
                    }
                    else if(square.getBelongs().equals(p1.getName())){
                        process=p1.getName()+" draw Advance to Leicester Square "+p1.getName()+" has Leicester Square ";

                    }
                    else{
                        process=p1.getName()+" draw Advance to Leicester Square ";
                        if(p1.getMoney()> square.getCost()){
                            process=process.concat(p1.getName()+" bought Leicester Square");
                            square.setBelongs("Player 1");
                            p1.setProp(square.getName());
                            p1.setMoney(-square.getCost());
                        }
                    }
                }
                //Ayni sekilde go back 3 spaces icin de 3 durum var.
                //Bunlari teker teker sorguladim.
                else if(chanceCount==2){
                    p1.setLocation(-3);
                    square =prprty.get(p1.getLocation());
                    if(square.getBelongs().equals(p2.getName())){
                        process=p1.getName()+" draw Go back 3 spaces" +p1.getName()+" paid rent for "+ square.getName();
                        Buyandrent.RentProp(p2,p1, square);
                    }
                    else if(square.getBelongs().equals(p1.getName())){
                        process=p1.getName()+" draw Go back 3 spaces "+p1.getName()+" has "+ square.getName();

                    }
                    else{
                        process=p1.getName()+" draw Go back 3 spaces";
                        if(p1.getMoney()>= square.getCost()){
                            Buyandrent.BuyProp(p1, square);
                        }
                    }

                }
                else if(chanceCount==3){
                    p1.poortax();

                }
                else if(chanceCount==4){
                    p1.buildl();


                }
                else if(chanceCount==5){
                    p1.crossword();

                }
                chanceCount++;

            }
            else if(location==21){
                process=p1.getName() +" is in Free Parking ";
            }
            else if(location==39){
                p1.tax();

            }
            else if(location==11){
                p1.jail();
            }
            //Bu kisimda oyuncunun geldigi karedeki propertyi sorguluyor
            //Eger oyuncunun yeterli parasi varsa ve property kimseye ait degilse satın aliyor.
            else {
                if(square.getBelongs().equals("none") & p1.getMoney()>= square.getCost()){
                    process=p1.getName()+" bought "+ square.getName();
                    Buyandrent.BuyProp(p1, square);

                }
                // oyuncunun geldigi kare eger o oyuncuya aitse .
                else if(square.getBelongs().equals(p1.getName())){
                    process=p1.getName()+" has "+ square.getName();

                }
                //yine buyandrent classini kullanarak yeterli parasi olup olmadigini kontrol ediyorum.Eger yeterli parasi varsa islem yapiliyor.
                else{
                    Buyandrent.RentProp(p2,p1, square);

                }
            }
        }


    }
}