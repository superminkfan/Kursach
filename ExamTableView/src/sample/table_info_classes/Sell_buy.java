package sample.table_info_classes;

import java.util.Date;

public class Sell_buy {

    private String date;
    private int Curr;
    private double buy;
    private double sell;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCurr() {
        return Curr;
    }

    public void setCurr(int curr) {
        Curr = curr;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public Sell_buy (String date , int Curr , double buy , double sell)
    {
        this.buy=buy;
        this.Curr=Curr;
        this.date = date;
        this.sell = sell;
    }
}
