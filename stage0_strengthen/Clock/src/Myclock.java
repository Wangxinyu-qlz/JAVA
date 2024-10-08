package Clock.src;

public class Myclock{
    Mydisplay hour = new Mydisplay(24);
    Mydisplay minute = new Mydisplay(60);

    public void start()
    {
        while(true)
        {
            minute.increase();
            if(minute.getValue() == 0)
            {
                hour.increase();
            }
            System.out.printf("%02d:%02d\n", hour.getValue(), minute.getValue());
	        try {
		        Thread.sleep(1000);
	        } catch (InterruptedException e) {
		        throw new RuntimeException(e);
	        }
        }
    }

    public static void main(String[] args)
    {
        Myclock clock = new Myclock();
        clock.start();
        
    }
}