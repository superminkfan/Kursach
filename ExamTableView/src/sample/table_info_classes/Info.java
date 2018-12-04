package sample.table_info_classes;

public class Info {
    private int pas_seria;
    private int pas_nomer;
    private int check_num;
    private String pas_s;
    private String pas_n;
    private String pas_och;
    private int block;
    private double sum;
    private int curr;
    private int id;

    public Info(int pas_seria, int pas_nomer, String pas_s, String pas_n, String pas_och, int id) {
        this.pas_seria = pas_seria;
        this.pas_nomer = pas_nomer;
        this.pas_s = pas_s;
        this.pas_n = pas_n;
        this.pas_och = pas_och;
        this.id = id;
    }

    public Info(int pas_seria, int pas_nomer, String pas_s, String pas_n , String pas_och , int check_sum, int block , double sum , int curr , int id) {

        this.check_num=check_sum;
        this.pas_n=pas_n;
        this.pas_nomer=pas_nomer;
        this.pas_och=pas_och;
        this.pas_s=pas_s;
        this.pas_seria=pas_seria;
        this.block=block;
        this.sum=sum;
        this.id = id;
        this.curr = curr;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
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

    public int getCheck_num() {
        return check_num;
    }

    public void setCheck_num(int check_num) {
        this.check_num = check_num;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
