import java.util.ArrayList;

public class Player extends Rules {
    private boolean bankrupt;
    private String name;
    private int money=15000,ceza=0,railcount,location=1,old_location;
    //Oyuncunun property listini kayıt ediyorum.
    private ArrayList<String> prop=new ArrayList<>();


    // setter-getter
    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public void bankrupt(){
        bankrupt=true;
    }
    public Player(String name) {
        this.name = name;
    }

    public int getRailcount() {
        return railcount;
    }

    public void setRailcount(int railcount) {
        this.railcount += railcount;
    }


    public ArrayList<String> getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop.add(prop);
    }

    public int getCeza() {
        return ceza;
    }

    public void setCeza(int ceza) {
        this.ceza += ceza;
    }

    public void Go(int x){
        location=x;
    }
    public int getLocation() {
        return location;
    }
    // Eger oyuncu tur atmissa oyuncuya para verip konumunu duzeltiyorum.
    public void setLocation(int location1) {
        old_location=location;
        if (location1+location>40) {
            location=location1+location-40;
            setMoney(200);
        }
        else if(location1+location<=0){
            location=location1+location+40;
        }

        else{
            location=location1+location;
        }


    }


    public String getName() {
        return name;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    // oyuncunun konumunu bulduktan sonra yapilmasi gerekilen operasyonlari burada yapiyorum(jail advancetogo vs.)
    // ayrica "process"i kullanarak mesajlari daha sonra output.txt'ye yazmak icin kayit ediyorum.
    @Override
    public void advancetogo2() {
        setMoney(200);
        Go(1);
        process=getName()+" draw chanceList-Advance to Go (Collect $200)";
    }

    @Override
    public void jail() {
        Go(11);
        setCeza(3);
        process=getName()+" went to jail";
    }

    @Override
    public void advancetogo() {
        setMoney(200);
        Go(1);
        process=getName()+" draw Community Chest -advance to go(Collect $200)";
    }


    @Override
    public void poortax() {
        setMoney(-10);
        process=getName()+" draw Your building loan matures";

    }

    @Override
    public void buildl() {
        setMoney(150);
        process=getName()+" draw Your building loan matures";

    }

    @Override
    public void crossword() {
        setMoney(100);
        process=getName()+"draw You have won a crossword competition";
    }

    @Override
    public void bankerror() {
        setMoney(75);
        process= getName()+"draw Community Chest - Bank error in your favor ";
    }

    @Override
    public void doctorfee() {
        if(getMoney()>50){
            setMoney(-50);
            process =getName()+" draw Community Chest - Doctor's fees ";
        }
        else{
            setBankrupt(true);
            setMoney(0);
            process=getName()+" goes bankrupt ";
        }

    }

    public void refund() {
        setMoney(100);
        process=getName() +" draw Community Chest -Income Tax refund";

    }

    @Override
    // if the player doesn't have enough money ,the player goes bankrupt.
    public void life() {
        if(getMoney()>100){
            setMoney(100);
            process =getName()+" draw Community Chest -Life Insurance Matures";
        }
        else{
            setBankrupt(true);
            setMoney(0);
            process=getName()+" goes bankrupt ";
        }

    }

    @Override
    public void hospfee() {
        if(getMoney()>50){
            setMoney(-50);
            process =getName()+" draw Community Chest -Pay Hospital Fees";
        }
        else{
            setBankrupt(true);
            setMoney(0);
            process=getName()+" goes bankrupt ";
        }

    }

    @Override
    public void schfee() {
        if(getMoney()>50){
            setMoney(-50);
            process =getName()+" draw Community Chest -Pay Hospital Fees";
        }
        else{
            setBankrupt(true);
            setMoney(0);
            process=getName()+" goes bankrupt ";
        }

    }

    @Override
    public void inherit() {
        setMoney(100);
        process=getName()+" draw Community Chest -You inherit $100";
    }

    @Override
    public void salestock() {
        setMoney(50);
        process=getName()+" draw Community Chest -From sale of stock you get $50";

    }

    @Override
    public void tax() {
        if(getMoney()>10){
            setMoney(-100);
            process=getName()+" paid tax";        }
        else{
            setBankrupt(true);
            setMoney(0);
            process=getName()+" goes bankrupt ";
        }

    }
}
