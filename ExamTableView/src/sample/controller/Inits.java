package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.table_info_classes.Credit_Info;
import sample.table_info_classes.Sell_buy;
import sample.table_info_classes.Info;


public abstract class Inits {
    @FXML
    protected TextField pas_seria_inp;

    @FXML
    protected TextField pas_nomer_inp;

    @FXML
    protected TextField pas_s_inp;

    @FXML
    protected TextField pas_n_inp;

    @FXML
    protected TextField pas_och_inp;

    @FXML
    protected Button enter_bt1;

    @FXML
    protected TextArea wat_happen;

    @FXML
    protected ComboBox<String> curr_ent;



    @FXML
    protected TextField pas_seria_inp2;

    @FXML
    protected TextField pas_nomer_inp2;

    @FXML
    protected TextField pas_s_inp2;

    @FXML
    protected TextField pas_n_inp2;

    @FXML
    protected TextField pas_och_inp2;

    @FXML
    protected TextField check_num_inp2;

    @FXML
    protected TextField sum_inp2;

    @FXML
    protected TextArea wat_happen_2;

    @FXML
    protected Button upt_bt;

    @FXML
    protected ComboBox<String> curr_upt;





    @FXML
    protected TableView<Info> pas_table;

    @FXML
    protected TableColumn<Info, Integer> pas_seria;

    @FXML
    protected TableColumn<Info, Integer> pas_nomer;

    @FXML
    protected TableColumn<Info, String> pas_s;

    @FXML
    protected TableColumn<Info, String> pas_n;

    @FXML
    protected TableColumn<Info, String> pas_och;

    @FXML
    protected TableColumn<Info, Integer> check_num;

    @FXML
    protected TableColumn<Info , Integer> block;

    @FXML
    protected TableColumn<Info , Integer> sum;

    @FXML
    protected TableColumn<Info , String> curr;




    @FXML
    protected TableView<Sell_buy> kurs_table;

    @FXML
    protected TableColumn<Sell_buy, String> date_column;

    @FXML
    protected TableColumn<Sell_buy, Integer> curr_column;

    @FXML
    protected TableColumn<Sell_buy, Double> buy_column;

    @FXML
    protected TableColumn<Sell_buy, Double> sell_column;




    @FXML
    protected TextField avr_mnth_cash_inp3;

    @FXML
    protected TextField pas_seria_inp3;

    @FXML
    protected TextField pas_nomer_inp3;

    @FXML
    protected TextField pas_s_inp3;

    @FXML
    protected TextField pas_n_inp3;

    @FXML
    protected TextField pas_och_inp3;

    @FXML
    protected TextField s_inp3;

    @FXML
    protected TextField n_inp3;

    @FXML
    protected TextArea wat_happen_3;

    @FXML
    protected Button credit_bt;




    @FXML
    protected TableView<Credit_Info> credit_table;

    @FXML
    protected TableColumn<Credit_Info, Integer> pas_seria2;

    @FXML
    protected TableColumn<Credit_Info, Integer> pas_nomer2;

    @FXML
    protected TableColumn<Credit_Info, String> pas_s2;

    @FXML
    protected TableColumn<Credit_Info, String> pas_n2;

    @FXML
    protected TableColumn<Credit_Info, String> pas_och2;

    @FXML
    protected TableColumn<Credit_Info, Integer> s;

    @FXML
    protected TableColumn<Credit_Info, Integer> n;

    @FXML
    protected TableColumn<Credit_Info, Double> cash_per_month;

    @FXML
    protected TableColumn<Credit_Info , Integer> credit_id;




    @FXML
    protected TextField pas_seria_hi;

    @FXML
    protected TextField pas_nomer_hi;

    @FXML
    protected TextField pas_s_hi;

    @FXML
    protected TextField pas_n_hi;

    @FXML
    protected TextField pas_och_hi;

    @FXML
    protected TextField check_num_hi;

    @FXML
    protected TextField sum_hi;



    @FXML
    protected TextField s_hi;

    @FXML
    protected TextField n_hi;

    @FXML
    protected TextField curr_hi;

    @FXML
    protected TextField avr_mnth_cash_hi;


    @FXML
    protected Tab tab_credit;

    @FXML
    protected Tab tab_work_check;

    @FXML
    protected Tab tab_create_check;





    @FXML
    protected TextArea wat_do_u_want;

    @FXML
    protected Button add_bt;

    @FXML
    protected Button next_bt;







    @FXML
    protected Button wat_bt;

    @FXML
    protected Label wat;

}
