public class Peoplee {
    public String namee;
    private int agee;
    private double salarye;

    public Peoplee(){}
//    构造器和set组合使用
    public Peoplee(String namee, int agee, double salarye) {
        this.setName(namee);
        this.setAge(agee);
        this.setSalary(salarye);
    }

    public void setName(String namee) {
//        加入对name的校验
        if(namee.length() >= 2 && namee.length() <= 6) {
            this.namee = namee;
        } else {
            System.out.println("姓名无效，已重置：");
            this.namee = "佚名";
        }

    }

    public void setAge(int agee) {
//        加入对年龄的校验
        if( agee >= 1 && agee <=120 ) {
            this.agee = agee;
        } else {
            System.out.println("你输入的年龄不正确，需要在1-120岁之间，已重置为默认年龄：18岁。");
            this.agee = 18;
        }
    }

    public void setSalary(double salarye) {
        this.salarye = salarye;
    }

    public String getName() {
        return namee;
    }

    public int getAge() {
        return agee;
    }

    public double getSalary() {
        return salarye;
    }

    public String info() {
        return "信息为：name=" + namee + ";age=" + agee + ";salary=" + salarye;
    }

    public static void main(String[] args) {
        Peoplee peoplee = new Peoplee();
        peoplee.setName("王1111111111");
        peoplee.setAge(200);
        peoplee.setSalary(30000.0);
        System.out.println(peoplee.info());
        Peoplee xiaowang = new Peoplee("xiaowang", 120000, 300);
        System.out.println(xiaowang.info());
    }
}
