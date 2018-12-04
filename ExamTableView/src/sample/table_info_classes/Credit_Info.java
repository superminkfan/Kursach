package sample.table_info_classes;

public class Credit_Info {

    private int pas_seria;
    private int pas_nomer;
    private String pas_s;
    private String pas_n;
    private String pas_och;
    private int s;
    private int n;
    private int avr_mnt_cash;
    private int id;
    private int credit_id;
    private double cash_per_month;

    public Credit_Info(int s, int n, int avr_mnt_cash, int id, int credit_id , double cash_per_month) {
        this.s = s;
        this.n = n;
        this.avr_mnt_cash = avr_mnt_cash;
        this.id = id;
        this.credit_id = credit_id;
        this.cash_per_month = cash_per_month;
    }

    public Credit_Info(int pas_seria, int pas_nomer, String pas_s, String pas_n, String pas_och, int s, int n, int avr_mnt_cash, int id, int credit_id , double cash_per_month) {
        this.pas_seria = pas_seria;
        this.pas_nomer = pas_nomer;
        this.pas_s = pas_s;
        this.pas_n = pas_n;
        this.pas_och = pas_och;
        this.s = s;
        this.n = n;
        this.avr_mnt_cash = avr_mnt_cash;
        this.id = id;
        this.credit_id = credit_id;
        this.cash_per_month = cash_per_month;
    }

    public double getCash_per_month() {
        return cash_per_month;
    }

    public void setCash_per_month(double cash_per_month) {
        this.cash_per_month = cash_per_month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(int credit_id) {
        this.credit_id = credit_id;
    }


    public int getPas_seria() {
        return pas_seria;
    }

    public void setPas_seria(int pas_seria) {
        this.pas_seria = pas_seria;
    }

    public int getPas_nomer() {
        return pas_nomer;
    }

    public void setPas_nomer(int pas_nomer) {
        this.pas_nomer = pas_nomer;
    }

    public String getPas_s() {
        return pas_s;
    }

    public void setPas_s(String pas_s) {
        this.pas_s = pas_s;
    }

    public String getPas_n() {
        return pas_n;
    }

    public void setPas_n(String pas_n) {
        this.pas_n = pas_n;
    }

    public String getPas_och() {
        return pas_och;
    }

    public void setPas_och(String pas_och) {
        this.pas_och = pas_och;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getAvr_mnt_cash() {
        return avr_mnt_cash;
    }

    public void setAvr_mnt_cash(int avr_mnt_cash) {
        this.avr_mnt_cash = avr_mnt_cash;
    }
}
