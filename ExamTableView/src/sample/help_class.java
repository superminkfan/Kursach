package sample;

public class help_class {
    private int temp_curr_int;
    private String temp_curr_str;

    public help_class(int temp_curr)
    {
        this.temp_curr_int=temp_curr;
    }
    public help_class(String temp_curr)
    {
        this.temp_curr_str=temp_curr;
    }

    public String to_string()
    {
        String curr;
        if(this.temp_curr_int == 1)
            curr = "RUB";
        else if (this.temp_curr_int == 2)
            curr = "USD";
        else if (this.temp_curr_int == 3)
            curr = "EUR";
        else
            curr = "RUB";
        return curr;
    }

    public int to_int()
    {
        int curr;
        if(this.temp_curr_str == "RUB")
            curr = 1;
        else if (this.temp_curr_str == "USD")
            curr = 2;
        else if (this.temp_curr_str == "EUR")
            curr = 3;
        else
            curr = 1;
        return curr;
    }



}
