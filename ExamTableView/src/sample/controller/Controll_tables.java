package sample.controller;

import sample.table_info_classes.*;

import sample.db_work.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Controll_tables extends Inits {


    public static void initKurs() throws SQLException, ClassNotFoundException, ParseException {
        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT * FROM Kurs ;");

        while(resSet.next())
        {
            String w_date = resSet.getString("w_date");
            int curr = resSet.getInt("curr");
            double buy = resSet.getDouble("buy");
            double sell = resSet.getDouble("sell");

            Controller.kurs_Data.add(new Sell_buy(w_date , curr , buy , sell));
        }

        String new_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        try{
            System.out.println("Сегодня - " + new_date);
            Write_db.run_add_new_date(new_date);

        }
        catch (SQLException e)
        {
            System.out.println("Такая дата есть в бд! " );
            System.out.println("И это хорошо! " );
            return;
        }

    }



    public static void intiCredit() throws SQLException, ClassNotFoundException
    {
        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT * FROM Info_credit NATURAL JOIN Info_pas;");
        while(resSet.next())
        {
            int pas_seria = resSet.getInt("pas_seria");
            int pas_nomer = resSet.getInt("pas_nomer");
            String pas_s = resSet.getString("pas_s");
            String pas_n = resSet.getString("pas_n");
            String pas_och = resSet.getString("pas_och");
            int id = resSet.getInt("id");
            int credit_id = resSet.getInt("credit_id");
            int s = resSet.getInt("s");
            int n = resSet.getInt("n");
            int avr_mnth_cash = resSet.getInt("avr_mnt_cash");
            double cash_per_month = resSet.getDouble("cash_per_month");

            Controller.credit_Data.add(new Credit_Info(pas_seria,pas_nomer, pas_s , pas_n , pas_och , s , n , avr_mnth_cash , id , credit_id , cash_per_month));

        }
    }




    public static void initData()  throws SQLException, ClassNotFoundException{
        Conn.Conn();

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT * FROM Info_pas NATURAL JOIN Info_id NATURAL JOIN Info_block NATURAL JOIN Info_sum ;");

        while(resSet.next())
        {
            int pas_seria = resSet.getInt("pas_seria");
            int pas_nomer = resSet.getInt("pas_nomer");
            String pas_s = resSet.getString("pas_s");
            String pas_n = resSet.getString("pas_n");
            String pas_och = resSet.getString("pas_och");
            int id = resSet.getInt("id");
            int check_num = resSet.getInt("check_num");
            int block = resSet.getInt("block");
            double sum = resSet.getDouble("sum");
            int curr = resSet.getInt("curr");


            if (check_num>Controller.last_check_num)
                Controller.last_check_num=check_num;
            if (id>Controller.last_id)
                Controller.last_id = id;

            Controller.pas_Data.add(new Info(pas_seria,pas_nomer, pas_s , pas_n , pas_och , check_num , block , sum , curr ,id));
        }

    }
}
