package sample.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.util.Duration;
import sample.Check_table.Check_Info;
import sample.cust_to_go.gen_data;
import sample.table_info_classes.Credit_Info;
import sample.table_info_classes.Info;
import sample.table_info_classes.Sell_buy;
import sample.db_work.*;
import sample.help_class;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller extends Inits{
    /*
    + данный класс отвечет за логику ввода информации пользователем
    + инициализация данных таблиц
    + проверка введённых данных
     */

    public static int last_check_num=0;
    public static int last_id=0;
    public static ArrayList<String> last_cust_list;

    public static int KOSTYL =1;
    public static int desteny=0;
    public static int KOSTYL_ver2 = 0;

    public static ObservableList<Info> pas_Data = FXCollections.observableArrayList();
    public static ObservableList<Sell_buy> kurs_Data = FXCollections.observableArrayList();
    public static ObservableList<Credit_Info> credit_Data = FXCollections.observableArrayList();


    @FXML
    private void initialize() throws SQLException, ClassNotFoundException, ParseException {

        Controll_tables.initData();
        pas_seria.setCellValueFactory(new PropertyValueFactory<Info, Integer>("pas_seria"));
        pas_nomer.setCellValueFactory(new PropertyValueFactory<Info, Integer>("pas_nomer"));
        pas_s.setCellValueFactory(new PropertyValueFactory<Info, String>("pas_s"));
        pas_n.setCellValueFactory(new PropertyValueFactory<Info, String>("pas_n"));
        pas_och.setCellValueFactory(new PropertyValueFactory<Info, String>("pas_och"));
        check_num.setCellValueFactory(new PropertyValueFactory<Info, Integer>("check_num"));
        block.setCellValueFactory(new PropertyValueFactory<Info, Integer>("block"));
        sum.setCellValueFactory(new PropertyValueFactory<Info, Integer>("sum"));
        curr.setCellValueFactory(new PropertyValueFactory<Info, String>("curr"));
        pas_table.setItems(pas_Data);


        Controll_tables.initKurs();
        date_column.setCellValueFactory(new PropertyValueFactory<Sell_buy , String>("date"));
        curr_column.setCellValueFactory(new PropertyValueFactory<Sell_buy , Integer>("curr"));
        buy_column.setCellValueFactory(new PropertyValueFactory<Sell_buy , Double>("buy"));
        sell_column.setCellValueFactory(new PropertyValueFactory<Sell_buy , Double>("sell"));
        kurs_table.setItems(kurs_Data);


        Controll_tables.intiCredit();
        pas_seria2.setCellValueFactory(new PropertyValueFactory<Credit_Info , Integer>("pas_seria"));
        pas_nomer2.setCellValueFactory(new PropertyValueFactory<Credit_Info , Integer>("pas_nomer"));
        pas_s2.setCellValueFactory(new PropertyValueFactory<Credit_Info , String>("pas_s"));
        pas_n2.setCellValueFactory(new PropertyValueFactory<Credit_Info , String>("pas_n"));
        pas_och2.setCellValueFactory(new PropertyValueFactory<Credit_Info , String>("pas_och"));
        s.setCellValueFactory(new PropertyValueFactory<Credit_Info , Integer>("s"));
        n.setCellValueFactory(new PropertyValueFactory<Credit_Info , Integer>("n"));
        cash_per_month.setCellValueFactory(new PropertyValueFactory<Credit_Info , Double>("cash_per_month"));
        credit_id.setCellValueFactory(new PropertyValueFactory<Credit_Info , Integer>("credit_id"));
        credit_table.setItems(credit_Data);


        curr_ent.getItems().addAll("RUB", "USD" , "EUR");
        curr_upt.getItems().addAll("RUB", "USD" , "EUR");


    }

    @FXML
    public void onClick_ent() throws SQLException, ClassNotFoundException{

        try {

            int pas_seria = Integer.parseInt(new String(pas_seria_inp.getText()));
            int pas_nomer = Integer.parseInt(new String(pas_nomer_inp.getText()));
            String pas_s = new String(pas_s_inp.getText());
            String pas_n = new String(pas_n_inp.getText());
            String pas_och = new String(pas_och_inp.getText());
            String temp_curr = curr_ent.getValue();

            int curr=43;//уйдёт в ошибку если что
            help_class help = new help_class(temp_curr);
            curr = help.to_int();

            int check_num = last_check_num+1;
            int block = 0;
            int sum = 0;

            Check_Info wat = new Check_Info(pas_seria,pas_nomer);
            int id = wat.find_this_id();

            if (id != 0)//не новый клиент, уже есть в бд
            {
                System.out.println("Вот эти ребята --- страрый клиент!");

                Info cust = new Info(pas_seria, pas_nomer, pas_s, pas_n, pas_och, check_num, block, sum, curr, id);
                Write_db.run_add_check(cust);
                wat_happen.appendText("Клиент уже есть в бд!\n");
                pas_Data.clear();
                Controll_tables.initData();
            }
            else {//новый клиент
                System.out.println("Вот эти ребята --- новый клиент!");
                Info cust_new = new Info(pas_seria, pas_nomer, pas_s, pas_n, pas_och, check_num, block, sum, curr, last_id+15);
                Write_db.run_new_check(cust_new);
                wat_happen.appendText("Новый клиент!!\n");
                pas_Data.clear();
                Controll_tables.initData();
            }

       }
        catch (NumberFormatException e)
        {
            wat_happen.appendText("Неправильный ввод! \n" + e.getLocalizedMessage()+ "\n");
            return;
        }

        catch (SQLException e)
        {
            wat_happen.appendText("Ошибка SQL! \n" + e.getSQLState() + "\n" + e.getLocalizedMessage());
            return;
        }

        pas_seria_inp.clear();
        pas_nomer_inp.clear();
        pas_s_inp.clear();
        pas_n_inp.clear();
        pas_och_inp.clear();

        wat_happen.appendText("Счёт создан! \n");

    }

    @FXML
    public void onClick_upt() throws SQLException, ClassNotFoundException {
        try {

            int pas_seria = Integer.parseInt(new String(pas_seria_inp2.getText()));
            int pas_nomer = Integer.parseInt(new String(pas_nomer_inp2.getText()));
            String pas_s = new String(pas_s_inp2.getText());
            String pas_n = new String(pas_n_inp2.getText());
            String pas_och = new String(pas_och_inp2.getText());
            int check_num = Integer.parseInt(new String(check_num_inp2.getText()));
            String temp_curr = curr_upt.getValue();

            int curr;
            help_class help = new help_class(temp_curr);
            curr = help.to_int();

            Check_Info wat = new Check_Info(pas_seria, pas_nomer, pas_s, pas_n, pas_och, check_num , curr);
            int k = wat.find_Info();

            if (k == 1) {
                wat_happen_2.appendText("Нет такой записи!\n");
                return;
            } else if (k == 2) {
                wat_happen_2.appendText("Запись заблокирована!\n");
                return;
            } else if (k == 3) {
                wat_happen_2.appendText("Ошибка в проверке!\n");
                return;
            }

            double sum = Double.parseDouble(new String(sum_inp2.getText()));

            int curr_of_check = wat.find_curr();//нахлжу номер счёта
            help_class help1 = new help_class(curr_of_check);

            wat_happen_2.appendText( help1.to_string() + " - валюта счета\n");
            wat_happen_2.appendText(temp_curr + " - валюта ввода/вывода\n");

                if (curr != curr_of_check) {
                    if (sum<0)
                    {

                        wat_happen_2.appendText("Вывод средств!\n");
                        wat_happen_2.appendText("Вывод в другой валюте поэтому комиссия 3%!\n");
                        //ТУТ ЕЩЁ КОМИССИЯ БАНКА!
                        double buy = wat.find_buy();
                        sum = sum*buy*0.97;
                        //комиссия нигде не считается

                    }

                    else
                    {
                        wat_happen_2.appendText("Ввод средств!\n");
                        double sell =  wat.find_sell();
                        sum = sum*sell;
                    }

                }

            Update_db.run(sum, check_num);
            pas_Data.clear();
            Controll_tables.initData();

        }
        catch (NumberFormatException e)
        {
            wat_happen_2.appendText("Неправильный ввод! \n" + e.getLocalizedMessage()+ "\n");
            return;
        }

        catch (SQLException e)
        {
            wat_happen_2.appendText("Ошибка SQL! \n" + e.getSQLState() + "\n" + e.getLocalizedMessage() + "gjfkdls");
            return;
        }

        pas_seria_inp2.clear();
        pas_nomer_inp2.clear();
        pas_s_inp2.clear();
        pas_n_inp2.clear();
        pas_och_inp2.clear();
        check_num_inp2.clear();
        sum_inp2.clear();

        wat_happen_2.appendText("Успех! \n");

    }

    @FXML
    public void onClick_credit () throws SQLException, ClassNotFoundException
    {
        try {
            int pas_seria = Integer.parseInt(new String(pas_seria_inp3.getText()));
            int pas_nomer = Integer.parseInt(new String(pas_nomer_inp3.getText()));
            String pas_s = new String(pas_s_inp3.getText());
            String pas_n = new String(pas_n_inp3.getText());
            String pas_och = new String(pas_och_inp3.getText());
            int s = Integer.parseInt(new String(s_inp3.getText()));
            int n = Integer.parseInt(new String(n_inp3.getText()));
            int avr_mnt_cash = Integer.parseInt(new String(avr_mnth_cash_inp3.getText()));

            Check_Info wat = new Check_Info(pas_seria,pas_nomer);
            int id = wat.find_this_id();
            if(id==0)
            {
                id = wat.find_last_id()+1;
                Info cust = new Info(pas_seria,pas_nomer,pas_s,pas_n,pas_och,id);
                Write_db.run_new_client(cust);

            }
            int credit_id = wat.find_last_credit_id()+1;
            System.out.println(credit_id);

            double cash_per_month = (s + n*s*0.15)/12*n;
            wat_happen_3.appendText("Месячный платёж " + cash_per_month + "\n");

            /*
            а тут все месячные платежи и сравнить с 13500
             */

            double all_cash = wat.find_all_cash_per_month(id);
            System.out.println(all_cash);
            wat_happen_3.appendText("Сумма всех месячных платежей " + (all_cash + avr_mnt_cash)  + "\n");
            if (avr_mnt_cash - all_cash + cash_per_month>13500)
            {
                wat_happen_3.appendText("Меньше чем прожиточный минимум!\n");
                return;
            }


            Credit_Info cust = new Credit_Info(s,n,avr_mnt_cash,id, credit_id , cash_per_month);
            Write_db.run_add_credit(cust);

            credit_Data.clear();
            Controll_tables.intiCredit();


        }
        catch (SQLException e)
        {
            wat_happen_3.appendText("Ошибка SQL! \n" + e.getSQLState() + "\n" + e.getLocalizedMessage());
            return;
        }
        catch (NumberFormatException e)
        {
            wat_happen_3.appendText("Неправильный ввод! \n" + e.getLocalizedMessage()+ "\n");
            return;
        }


        pas_seria_inp3.clear();
        pas_nomer_inp3.clear();
        pas_s_inp3.clear();
        pas_n_inp3.clear();
        pas_och_inp3.clear();
        s_inp3.clear();
        n_inp3.clear();
        avr_mnth_cash_inp3.clear();

        wat_happen_3.appendText("Успех! \n");
    }




//----------------------------------------------------------------------------------
  /*
  Дальше идут методы отвечающие за кнопки ВНЕСТИ и СЛЕДУЮЩИЙ

  !АЛЕРТ!
  !ТЕРРИТОРИЯ КОСТЫЛЕЙ!

   */


public void add_click() throws SQLException {
    if (desteny == 0)
    {
        wat_do_u_want.appendText("Сначала нажмите на кнопку Следующий!!!\n");
        return;
    }
    wat_do_u_want.setText("Добавить!!!");
    if (desteny == 1)
    {
        //создание счета
        pas_seria_inp.setText(last_cust_list.get(0));
        pas_nomer_inp.setText(last_cust_list.get(1));
        pas_s_inp.setText(last_cust_list.get(2));
        pas_n_inp.setText(last_cust_list.get(3));
        pas_och_inp.setText(last_cust_list.get(4));
        curr_ent.setValue(last_cust_list.get(5));

        KOSTYL_ver2 += 1;

    }
    else if (desteny == 2)
    {
        //создание крелита
        pas_seria_inp3.setText(pas_seria_hi.getText());
        pas_nomer_inp3.setText(pas_nomer_hi.getText());
        pas_s_inp3.setText(pas_s_hi.getText());
        pas_n_inp3.setText(pas_n_hi.getText());
        pas_och_inp3.setText(pas_och_hi.getText());
        s_inp3.setText(s_hi.getText());
        n_inp3.setText(n_hi.getText());
        avr_mnth_cash_inp3.setText(avr_mnth_cash_hi.getText());


    }
    else if (desteny == 3)
    {
        //ввод вывыд срелств
        pas_seria_inp2.setText(last_cust_list.get(0));
        pas_nomer_inp2.setText(last_cust_list.get(1));
        pas_s_inp2.setText(last_cust_list.get(2));
        pas_n_inp2.setText(last_cust_list.get(3));
        pas_och_inp2.setText(last_cust_list.get(4));
        curr_upt.setValue(curr_hi.getText());
        sum_inp2.setText(sum_hi.getText());
        check_num_inp2.setText(check_num_hi.getText());

    }



}


public void next_click() throws SQLException {
    wat_do_u_want.setText("Следующий!\n");

    pas_seria_hi.clear();
    pas_nomer_hi.clear();
    pas_s_hi.clear();
    pas_n_hi.clear();
    pas_och_hi.clear();
    sum_hi.clear();
    check_num_hi.clear();
    curr_hi.clear();
    s_hi.clear();
    n_hi.clear();
    avr_mnth_cash_hi.clear();




    gen_data cust_to_go = new gen_data();
    desteny = 1 + (int) (Math.random() * 3);
    if (desteny == 1)
    {
        KOSTYL += 1;
        wat_do_u_want.appendText("Создание счёта!\n");
        last_cust_list = cust_to_go.run_cr_check();
        pas_seria_hi.setText(last_cust_list.get(0));
        pas_nomer_hi.setText(last_cust_list.get(1));
        pas_s_hi.setText(last_cust_list.get(2));
        pas_n_hi.setText(last_cust_list.get(3));
        pas_och_hi.setText(last_cust_list.get(4));
        curr_hi.setText(last_cust_list.get(5));

    }
    else if (desteny == 2)
    {
        KOSTYL += 1;
        wat_do_u_want.appendText("Создание кредита!\n");
        ArrayList<String> wat = cust_to_go.run_cr_credit();
        pas_seria_hi.setText(wat.get(0));
        pas_nomer_hi.setText(wat.get(1));
        pas_s_hi.setText(wat.get(2));
        pas_n_hi.setText(wat.get(3));
        pas_och_hi.setText(wat.get(4));
        s_hi.setText(wat.get(6));
        n_hi.setText(wat.get(7));
        avr_mnth_cash_hi.setText(wat.get(8));

    }
    else if (desteny == 3)
    {
        if (KOSTYL == 1)
        {
            wat_do_u_want.appendText("Ошибочка, жмякти ещё раз\n");
            return;
        }
        wat_do_u_want.appendText("Ввод вывод средств!!\n");

        if (KOSTYL_ver2 == 0)
        {
            wat_do_u_want.appendText("Попробуйте ещё раз, пажойста\n");
            return;
        }
        pas_seria_hi.setText(last_cust_list.get(0));
        pas_nomer_hi.setText(last_cust_list.get(1));
        pas_s_hi.setText(last_cust_list.get(2));
        pas_n_hi.setText(last_cust_list.get(3));
        pas_och_hi.setText(last_cust_list.get(4));

        Check_Info help = new Check_Info(Integer.parseInt(pas_seria_hi.getText()) , Integer.parseInt(pas_nomer_hi.getText()));
        Integer id = help.find_this_id();
        System.out.println("Найденное АЙДИ " + id);
        System.out.println("в то время как last_id " + last_id);

        Integer check_num = help.find_last_check_num();
        System.out.println("Найденный номер счёта последний по порядку?" + check_num);
//а как я найду номер счёта если их у меня несколько на человека
        //ответ --- просто возьму последний введённый
        check_num_hi.setText(check_num.toString());

        String[] curr = {"RUB" , "USD" , "EUR"};
        int c = (int) (Math.random()*3);
        curr_hi.setText(curr[c]);

        Integer sum = -1000 +(int) (Math.random()*5000);
        sum_hi.setText(sum.toString());


    }

}

}