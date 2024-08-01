package Clock.src.Clock;
import Clock.src.Display.Display;

/**
 * class Clock
 * 包含Hour和Minute
 * Hour和Minute可以进行交互，通过Clock进行沟通，传递信息
 * Hour和Minute都应该是Display的对象，两者之间没有直接联系
 */

public class Clock
{
    private Display hour = new Display(24);
    private Display minute = new Display(60);

    public void start()
    {
        while ( true )
        {        
            minute.increase();
            if ( minute.getValue() == 0 )
            {
                hour.increase();
            }

            System.out.printf("%02d:%02d\n", hour.getValue(), minute.getValue());
        }
    }
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        clock.start();
    }    
}
