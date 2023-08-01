import java.util.Objects;

// CD 成为 Item 的一个子类
public class CD extends Item {
    private String artist;
    private int numofTracks;

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", numofTracks=" + numofTracks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CD cd)) return false;
        return numofTracks == cd.numofTracks && Objects.equals(artist, cd.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, numofTracks);
    }

    //构造函数
    public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
        super(title, playingTime, false, comment);
        this.artist = artist;
        this.numofTracks = numofTracks;
    }

//    覆盖override
//    子类和父类中存在名称和参数表完全一致的函数--print()，这对函数构成覆盖关系
//    通过父类的变量调用override函数时，会调用变量当时管理的对象所属的类的函数（CD::print()）
    @Override
    public void print() {
        System.out.println("CD:");
        // 调用父类中的print一定要加上super
        super.print();
        System.out.print("artist:"+artist+";"+"numofTracks:"+numofTracks);
    }

    public static void main(String[] args)
    {
        CD cd = new CD("吻别", "张学友", 1, 3, "经典");
        CD cd1 = new CD("吻别", "张学友", 1, 3, "经典");
        cd.print();
        System.out.println();
//      不添加toString:CD@30dae81
//      添加toString:CD{artist='张学友', numofTracks=1}
        System.out.println(cd);
//      不添加equals:false
//      添加equals:true
        System.out.println(cd.equals(cd1));
    }
}
