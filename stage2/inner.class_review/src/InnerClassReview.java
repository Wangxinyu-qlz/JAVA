public class InnerClassReview {
    public static void main(String[] args) {
//        软编码
        f1(new IA() {
               @Override
               public void show() {
                   System.out.println("这是一个茶壶");
               }
           }
        );
    }

//    TODO static方法 形参为接口类型
    public static void f1(IA ia) {ia.show();}

}

interface IA {
    public void show();
}