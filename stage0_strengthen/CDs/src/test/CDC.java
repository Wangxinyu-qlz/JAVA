package test;


public class CDC extends Items{
    private String artist;
    private int numofTracks;

    public CDC(String title, String artist, int numofTracks, int playingTime, String comment){
        super(artist, playingTime, false, comment);
        this.artist = artist;
        this.numofTracks = numofTracks;
    }

    public void print(){
        System.out.print("artist:" + artist);
        super.print();
        System.out.print("numofTracks:" + numofTracks);
    }

    public static void main(String[] args){
        CDC cd = new CDC("ai", "小虎队", 1, 1, "经典");
        cd.print();
    } 
}
