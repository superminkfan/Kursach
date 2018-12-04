package sample.db_work;

import java.sql.SQLException;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.table_info_classes.Info;

public class Read_db {

    private ObservableList<Info> pas_Data = FXCollections.observableArrayList();

    public static void run() throws SQLException, ClassNotFoundException {
        Conn.Conn();

        ResultSet resSet = Conn.statmt.executeQuery(
                "SELECT * FROM Info_pas NATURAL JOIN Info_block NATURAL JOIN Info_sum");

        while(resSet.next()) {
            int pas_seria = resSet.getInt("pas_seria");
            int pas_nomer = resSet.getInt("pas_nomer");
            String pas_s = resSet.getString("pas_s");
            String pas_n = resSet.getString("pas_n");
            String pas_och = resSet.getString("pas_och");
            int check_num = resSet.getInt("check_num");
            int block = resSet.getInt("block");
            int sum = resSet.getInt("sum");

           //pas_Data.add(new Info(pas_seria,pas_nomer, pas_s , pas_n , pas_och , check_num , block , sum));

        }

    }

}
