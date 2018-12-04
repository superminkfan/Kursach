package sample.cust_to_go;

import java.lang.reflect.Array;
import java.util.*;

public class gen_data {

    public ArrayList<String>  wat  = new ArrayList<>() ;
    public ArrayList<String>  wat1  = new ArrayList<>() ;
    public ArrayList<String> run_cr_check()
    {
        String[] surnames = {"Obi","Абросимов", "Пупа", "За", "Борщь", "Попукатепетль", "Хренова", "Воробей", "Дятел", "Обосралло" , "Кембербеч", "СкайУокер" };
        String[] names = {"van","Пират", "Боливар", "Кристо", "Майк", "Джек", "Тонни", "Люци", "Грин", "Люк" ,"Гадя" , "Dimon" , "Bobik" , "Huk", "Ram" , "Бенедикт"};
        String[] och = {"Kenobi","Афанасьевич", "Акакъевич", "Артёмович", "Михалыч", "Петрович", "Никитович", "Ростиславовна", "Грин","Люканович" ,  };
        String[] curr = {"RUB" , "USD" , "EUR"};
        //---------------------------------------------------------
        int n = (int) (Math.random()*16);
        int s = (int) (Math.random()*12);
        int o = (int) (Math.random()*10);
        int c = (int) (Math.random()*3);
        //---------------------------------------------------------

        System.out.println("Фамилия: " + surnames[s]);
        System.out.println("Имя: " + names[n]);
        System.out.println("Отчество: " + och[o]);
        System.out.println("Валюта: " + curr[c]);

        //---------------------------------------------------------

        int a = 1000; // Начальное значение диапазона - "от"
        int b = 9999; // Конечное значение диапазона - "до"

        Integer pas_s = a + (int) (Math.random() * b); // Генерация 1-го числа
        System.out.println("Серия " + pas_s);

        Integer pas_n = a + (int) (Math.random() * b); // Генерация 2-го числа
        System.out.println("Номер " + pas_n);
        wat.add(pas_s.toString());
        wat.add(pas_n.toString());
        wat.add(surnames[s]);
        wat.add(names[n]);
        wat.add(och[o]);
        wat.add(curr[c]);

        return wat;


    }

    public ArrayList<String> run_cr_credit()
    {
        wat1 = run_cr_check();
        Integer s = 1000 + (int) (Math.random() * 50000);
        Integer n = 1 + (int) (Math.random() * 5);
        Integer avr_cash = 13500 + (int) (Math.random() * 60000);
        //--------------------------------------

        System.out.println("Сумма крелита " + s);
        System.out.println("Количество лет " + n);
        System.out.println("Средняя зарплата " + avr_cash);

        //--------------------------------------
        wat1.add(s.toString());
        wat1.add(n.toString());
        wat1.add(avr_cash.toString());


        return wat1;

    }

}
