public class Item {

    // protected：自己、同一个包内的其他类、子类可访问
    // 父类中的成员变量做成protected是一种妥协方案，有其他方法的话尽量不这么做
    // protected String title;
    
    // 父类中定义为private的所有变量在子类中not visible
    // 父类中的变量应该在父类中进行初始化及构造，再由子类继承
    // 定义初始化
    private String title;
    private int playingTime = 0;
    private boolean gotIt = false;
    private String comment;

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", playingTime=" + playingTime +
                ", gotIt=" + gotIt +
                ", comment='" + comment + '\'' +
                '}';
    }

    // 构造器
    public Item(String title, int playingTime, boolean gotIt, String comment) {
        super();
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void print() {
        System.out.print("title:"+title+";"+"playingTime:"+playingTime+";"+"comment:"+comment);
    }
    
}
