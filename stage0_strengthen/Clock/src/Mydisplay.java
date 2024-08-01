package Clock.src;

public class Mydisplay
{
    private int limit = 0;
    private int value = 0;

    public Mydisplay(int limit)
    {
        this.limit = limit;
    }

    public void increase()
    {
        value ++;
        if ( value == limit )
        {
            value = 0;
        }
    }

    public void showValue()
    {
        System.out.println(value);
    }

    public int getValue()
    {
        return value;
    }

    public static void main(String[] args)
    {
        Mydisplay test = new Mydisplay(24);
        while(true)
        {
            test.increase();
            test.showValue();
        }

    }
}