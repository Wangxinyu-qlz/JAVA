public class PloyArray {
    public static void main(String[] args) {
//        应用实例：现有一个集成结构如下，要求创建1个Person对象
//        2个Student对象和2个Teacher对象，统一放在数组中，并调用每个对象的say方法
        Person[] persons = new Person[5];
        persons[0] = new Person("Bob", 23);
        persons[1] = new Student("张三", 22, 100);
        persons[2] = new Student("李四", 22, 98);
        persons[3] = new Teacher("qwer", 38, 25000);
        persons[4] = new Teacher("qawr", 34, 52000);
//        Student students1 = (Student) persons[1];
//        Student students2 = (Student) persons[2];
//        Teacher teacher1 = (Teacher) persons[3];
//        Teacher teacher2 = (Teacher) persons[4];
//        students1.study();
//        teacher2.teach();
        for (int i = 0; i < persons.length; i++) {
//            persons[i]编译类型是Person，运行类型根据实际情况由JVW判断
            System.out.println(persons[i].say());//动态绑定机制
//            类型判断
            if(persons[i] instanceof Student) {
                ((Student) persons[i]).study();
            } else if(persons[i] instanceof Teacher) {
                ((Teacher) persons[i]).teach();
            } else if (persons[i] instanceof Person) {
            } else {
                System.out.println("人");
            }

        }
    }
}
