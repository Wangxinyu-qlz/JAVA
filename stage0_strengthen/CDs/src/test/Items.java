package test;


public class Items {
    private String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    @Override
    public String toString() {
        return "Items{" +
                "title='" + title + '\'' +
                ", playingTime=" + playingTime +
                ", gotIt=" + gotIt +
                ", comment='" + comment + '\'' +
                '}';
    }
    public Items(String title, int playingTime, boolean gotIt, String comment) {
        super();
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    public void setTile(String title) {
        this.title = title;
    }

    public void print() {
        System.out.print("title:"+title+";"+"playingTime:"+playingTime+";"+"comment:"+comment);
    }

}
