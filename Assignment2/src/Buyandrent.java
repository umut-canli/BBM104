//Bu kodu  oyuncularin yeterli parasi olup olmadigini incelemek icin yazdim.
//Eger oyuncunun yeterli parasi yoksa iflas ediyor.
//Eger yeterli parasi varsa islem yapiliyor.
public class Buyandrent extends Game{

    //Burasi emlak satin alimi icin.
    //Oyuncunun yeterli parasi varsa orayi aliyor.
    public static void BuyProp(Player p1,Properties prop) {
        p1.setMoney(-prop.getCost());
        prop.setBelongs(p1.getName());
        p1.setProp(prop.getName());
        // Daha sonra kira fiyatini belirlemek icin ne kadar Land i oldugunu kayit ediyorum.
        if (prop.getType().equals("Land")) {
            p1.setRailcount(1);
        }
    }

    //Burası kira icin.
    //Land-Company-Railroad ' a göre kira fiyatlarini belirlemek icin ayri ayri durumlar belirledim.
    //Eger parasi yeterli degilse iflas ediyo ayrica
    public static void Leicester(Player owner,Player hirer,Properties prop){
        if(hirer.getMoney()> prop.getRent()){
            owner.setMoney(prop.getRent());
            hirer.setMoney(-prop.getRent());
            process=hirer.getName()+" draw Advance to Leicester Square "+hirer.getName() +" paid rent for Leicester Square";

        }
        else{
            hirer.bankrupt();
            process=hirer.getName()+" goes bankrupt ";
        }
    }
    public static void RentProp(Player owner,Player hirer,Properties prop){
        if(prop.getType().equals("Land")){
            if(hirer.getMoney()>= prop.getRent()){
                owner.setMoney(prop.getRent());
                hirer.setMoney(-prop.getRent());
                process=hirer.getName()+" paid rent for "+ square.getName();

            }
            else{
                hirer.bankrupt();
                process=hirer.getName()+" goes bankrupt ";
            }


        }
        else if(prop.getType().equals("Company")){
            if(hirer.getMoney()>=4*dice){
                hirer.setMoney(-4*dice);
                owner.setMoney(4*dice);
                process=hirer.getName()+" paid rent for "+ square.getName();

            }
            else{
                hirer.bankrupt();
                process=hirer.getName()+" goes bankrupt ";

            }

        }
        else if(prop.getType().equals("Railroad")){
            if(hirer.getMoney()>=25*hirer.getRailcount()){
                owner.setMoney(25*hirer.getRailcount());
                hirer.setMoney(-25*hirer.getRailcount());
                process=hirer.getName()+" paid rent forx "+ square.getName();


            }
            else{
                hirer.bankrupt();
                process=hirer.getName()+" goes bankrupt ";

            }

        }


    }

    //Burasi da bir oyuncunun diger oyuncuya para vermesi gerektiginde(birthday vs.) parasinin yeterli olup olmadigini kontrol etmek icin.
    public static void check(Player owner,Player hirer,int amount){
        if(hirer.getMoney()>=amount){
            owner.setMoney(amount);
            hirer.setMoney(-amount);
        }
        else {
            hirer.bankrupt();
            process= hirer.getName()+" goes bankrupt";
        }

    }
}
