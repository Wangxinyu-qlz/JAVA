package test1;

public class Item1 {
    private String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    public Item1(String title, int playingTime, boolean gotIt, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void print(){
        System.out.print("title:" + title + ";playingTime:" + playingTime + ";comment:" + comment);
    }
}
