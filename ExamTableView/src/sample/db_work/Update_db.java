package sample.db_work;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Update_db {
    public static int run(double w_sum , int check_num) throws SQLException
    {

try {
    ResultSet resSet = Conn.statmt.executeQuery(
            "SELECT sum FROM Info_sum WHERE check_num = " + check_num + ";");

    if (resSet.isClosed()) {
        System.out.println("Нет такой записи!");
        System.out.println("Очень плохая ошибка!");
        return 1;
    }
    int sum_w = resSet.getInt("sum");

    if (w_sum<0) {

        if (sum_w + w_sum < 0) {
            System.out.println("Большая сумма!");
            return 2;
        }
    }

    Conn.statmt.execute("UPDATE 'Info_sum' SET sum = " + (w_sum + sum_w) + " WHERE check_num = " + check_num + ";");
}
catch (SQLException e)
{
    System.out.println("Ошибка SQL!" + e.getLocalizedMessage());
}


return 0;
    }

}
