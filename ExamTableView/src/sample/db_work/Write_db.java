package sample.db_work;

import org.jetbrains.annotations.NotNull;
import sample.table_info_classes.Credit_Info;
import sample.table_info_classes.Info;

import java.sql.SQLException;

public class Write_db {

    public static void run_new_check(@NotNull Info cust) throws SQLException
    {
        Conn.statmt.execute("INSERT INTO 'Info_pas' ('pas_seria', 'pas_nomer' , 'pas_s' , 'pas_n' , 'pas_och' , 'id') " +
                "VALUES (" + cust.getPas_seria() + ',' + cust.getPas_nomer() + ',' + "'"  + cust.getPas_s() + "'"  + ',' + "'"  + cust.getPas_n() + "'"  + ',' + "'" +
                cust.getPas_och() + "'"  + ',' + cust.getId()+ ");");

        Conn.statmt.execute("INSERT INTO 'Info_id' ('check_num' , 'id') " +
                "VALUES (" + cust.getCheck_num() + ',' + cust.getId() + ") ; ");

        Conn.statmt.execute("INSERT INTO 'Info_block' ('check_num' , 'block' )" +
                "VALUES (" + cust.getCheck_num() + ',' + cust.getBlock() +  ") ; ");

        Conn.statmt.execute("INSERT INTO 'Info_sum' ('check_num' , 'sum' , 'curr') " +
                "VALUES (" + cust.getCheck_num() + ',' + cust.getSum() + ',' + cust.getCurr() + ") ; ");
    }

    public static void run_add_check(@NotNull Info cust) throws SQLException
    {
        Conn.statmt.execute("INSERT INTO 'Info_id' ('check_num' , 'id') " +
                "VALUES (" + cust.getCheck_num() + ',' + cust.getId() + ") ; ");

        Conn.statmt.execute("INSERT INTO 'Info_block' ('check_num' , 'block' )" +
                "VALUES (" + cust.getCheck_num() + ',' + cust.getBlock() +  ") ; ");

        Conn.statmt.execute("INSERT INTO 'Info_sum' ('check_num' , 'sum' , 'curr') " +
                "VALUES (" + cust.getCheck_num() + ',' + cust.getSum() + ',' + cust.getCurr() + ") ; ");
    }

    public static void run_new_client(@NotNull Info cust) throws SQLException
    {
        Conn.statmt.execute("INSERT INTO 'Info_pas' ('pas_seria', 'pas_nomer' , 'pas_s' , 'pas_n' , 'pas_och' , 'id') " +
                "VALUES (" + cust.getPas_seria() + ',' + cust.getPas_nomer() + ',' + "'"  + cust.getPas_s() + "'"  + ',' + "'"  + cust.getPas_n() + "'"  + ',' + "'" +
                cust.getPas_och() + "'"  + ',' + cust.getId()+ ");");
    }

    public static void run_add_credit(@NotNull Credit_Info cust) throws SQLException
    {
        Conn.statmt.execute("INSERT INTO 'Info_credit' ('credit_id', 'id' , 's' , 'n' , 'avr_mnt_cash' , 'cash_per_month' ) " +
                "VALUES (" + cust.getCredit_id() + ',' + cust.getId() + ','   + cust.getS()   + ','   + cust.getN() + ',' + cust.getAvr_mnt_cash() + ',' + cust.getCash_per_month() + ");");
    }

    public static void run_add_new_date(String new_date) throws SQLException
    {

        // тут тоже костыль
        // каждый раз ввожу новую дату и всю инфу
        // а надо чтобы была проверка на текущюю дату, а она работает косячно
        // так что так
        double a = 40.;
        double b = 50.;
        double sell = a + (double)(Math.random()*b);
        double buy = a + (double)(Math.random()*b);
        Conn.statmt.execute("INSERT INTO 'Kurs' VALUES ( '"  + new_date + "'" + ',' + 2 + ',' + sell + ',' + buy + ");");
        sell = a + (double)(Math.random()*b);
        buy = a + (double)(Math.random()*b);
        Conn.statmt.execute("INSERT INTO 'Kurs' VALUES ( '" + new_date + "'" + ',' + 3 + ',' + sell + ',' + buy + ");");


    }


}
