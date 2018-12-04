package sample.Check_table;

import sample.db_work.Conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Check_Info  {

    private int pas_seria;
    private int pas_nomer;
    private int check_num;
    private String pas_s;
    private String pas_n;
    private String pas_och;
    private int curr;

    public Check_Info(int pas_seria, int pas_nomer, String pas_s, String pas_n, String pas_och,int check_num, int curr) {
        this.pas_seria = pas_seria;
        this.pas_nomer = pas_nomer;
        this.check_num = check_num;
        this.pas_s = pas_s;
        this.pas_n = pas_n;
        this.pas_och = pas_och;
        this.curr = curr;
    }

    public Check_Info (int pas_seria, int pas_nomer)
    {

        this.pas_nomer=pas_nomer;
        this.pas_seria=pas_seria;

    }

    public int find_Info() throws SQLException {

        // АЛАРМ!!!
        // ТУТ КОСТЫЛЬ!!
        /*
        Метод находит запись в бд, а так же заблокированна ли она
         */

           ResultSet resSet = Conn.statmt.executeQuery(
                   "SELECT * FROM Info_pas NATURAL JOIN Info_id WHERE  (pas_seria = " + this.pas_seria + ") AND (pas_nomer = " + this.pas_nomer +
                           ")AND (check_num =" + this.check_num + ");");

        if (resSet.isClosed())
        {
            System.out.println("Нет такой записи!");
            return 1;
        }
        else
            {
            ResultSet resSet2 = Conn.statmt.executeQuery("SELECT block FROM Info_block WHERE check_num = "+this.check_num+ ";");

            int block_check = resSet2.getInt("block");
            if (block_check == 1)
                 {
                     System.out.println("Запись заблокирована!");
                     return 2;
                 }

            }

        System.out.println("Есть запись!");
        return 0;

    }

    public int find_this_id() throws SQLException
    {
        /*
        метод нахолит id клиента в бд
         */
        int id = 0;
        System.out.println("---сообщение из find_this_id---");
        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT id FROM Info_pas WHERE (pas_seria = " + this.pas_seria + ") AND (pas_nomer = " + this.pas_nomer + ");");
        if (resSet.isClosed())
        {
            System.out.println("Ты первый раз в банке?!");
            System.out.println("---конец сообщения---");
            return id;
        }

        id = resSet.getInt("id");
        System.out.println(id);
        System.out.println("---конец сообщения---");
        return id;
    }

    public int find_curr() throws SQLException
    {
        /*
        метод определяет валюту счёта
         */
        int curr = 0 ;

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT curr FROM Info_sum WHERE check_num =" + this.check_num +  ";");
        curr = resSet.getInt("curr");
        System.out.println("---Cообщение из find_curr---");
        System.out.println(curr);
        System.out.println("---конец сообщения---");


        return curr;
    }

    public int find_last_id() throws SQLException
    {
        /*
        метод находит последний id в бд
        нужен только в одном месте
         */
        int id = 0;

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT id FROM Info_pas ;");
        if (resSet.isClosed())
        {
            System.out.println("Очень плохо?!");
            return id;
        }
        while(resSet.next()) {
            id = resSet.getInt("id");
            System.out.println(id);
        }
        return id;
    }

    public int find_last_check_num() throws SQLException
    {
        /*
        метод жизненно необхадим, если работает приём клиентов
         */
        int last_check = 0;

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT check_num FROM Info_id ;");
        if (resSet.isClosed())
        {
            System.out.println("Очень плохо?!");
            return last_check;
        }
        while(resSet.next()) {
            last_check = resSet.getInt("check_num");
            System.out.println(last_check);
        }
        return last_check;
    }

    public int find_last_credit_id() throws SQLException
    {
        int credit_id = 0;

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT credit_id FROM Info_credit ;");
        if (resSet.isClosed())
        {
            System.out.println("Очень плохо?!");
            return credit_id;
        }
        while(resSet.next()) {
            credit_id = resSet.getInt("credit_id");
        }
        return credit_id;
    }

    public void find_last_date() throws SQLException
    {
        ResultSet resSet = Conn.statmt.executeQuery(
                "  SELECT w_date FROM Kurs;" );
        if (resSet.isClosed())
        {
            System.out.println("АЛАРМ  -  СЕРЬЁЗНАЯ ОШИБКА?!");
            return ;
        }
        String current_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String w_date = new String("0");

        while(resSet.next()) {
             w_date = resSet.getString("w_date");

        }
        System.out.println("to chto v bd " + w_date);
        System.out.println("to chto sejchas " + current_date);

        System.out.println(equals(w_date == current_date));

        //if (w_date == current_date)
       if( equals(w_date == current_date))
        {
            System.out.println("uspex");
        }


    }

    public double find_sell() throws SQLException
    {

        double sell_price = 0;
        ResultSet resSet = Conn.statmt.executeQuery(
                "  SELECT sell FROM Kurs WHERE curr ="+ this.curr +";" );
        if (resSet.isClosed())
        {
            System.out.println("АЛАРМ  -  СЕРЬЁЗНАЯ ОШИБКА?!");
            return sell_price ;
        }

        while(resSet.next()) {
            sell_price = resSet.getDouble("sell");

        }

        return sell_price;

    }

    public double find_buy() throws SQLException
    {

        double buy_price = 0;
        ResultSet resSet = Conn.statmt.executeQuery(
                "  SELECT buy FROM Kurs WHERE curr ="+ this.curr +";" );
        if (resSet.isClosed())
        {
            System.out.println("АЛАРМ  -  СЕРЬЁЗНАЯ ОШИБКА?!");
            return buy_price ;
        }

        while(resSet.next()) {
            buy_price = resSet.getDouble("buy");

        }

        return buy_price;

    }

    public double find_all_cash_per_month(int id) throws SQLException
    {
        double all_cash = 0;

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT cash_per_month FROM Info_credit WHERE id = " + id + ';');

        if (resSet.isClosed())
        {
            System.out.println("АЛАРМ  -  СЕРЬЁЗНАЯ ОШИБКА?!");
            return all_cash ;
        }

        while(resSet.next()) {
            all_cash += resSet.getDouble("cash_per_month");

        }

        return all_cash;
    }
}
