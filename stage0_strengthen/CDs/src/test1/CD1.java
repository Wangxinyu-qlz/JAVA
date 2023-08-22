package test1;

public class CD1 extends Item1{
    private String artist;
    private int numofTracks;

    public CD1(String title, int playingTime, boolean gotIt, String comment, String artist, int numofTracks) {
    super(title, playingTime, gotIt, comment);
    this.artist = artist;
    this.numofTracks = numofTracks;
    }

    @Override
    public void print() {
        super.print();
        System.out.print("artist:" + artist + ";numofTracks:" + numofTracks);
    }

    public static void main(String[] args){
        CD1 cd1 = new CD1("夜曲", 3 ,false, "amazing!", "jaychou", 4);
        cd1.print();
    }
}