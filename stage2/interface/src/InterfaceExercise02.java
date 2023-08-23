public class InterfaceExercise02 {
    public static void main(String[] args) {
        new CQ().pX();
    }
}

interface AQ {
    int x = 0;
}
class BQ {
    int x = 1;
}
class CQ extends BQ implements AQ {
    public void pX() {
//        //Error:Reference to 'x' is ambiguous, both 'BQ.x' and 'AQ.x' match
//        System.out.println(x);
//        TODO 调用方式
        System.out.println(AQ.x + "  " + super.x);//0  1
    }
}
