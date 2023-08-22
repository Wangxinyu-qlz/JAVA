public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor("王新宇", 35, "教授", 20000);
        professor.introduce();
        AssociateProfessor associateProfessor = new AssociateProfessor("王新宇", 29, "教授", 15000);
        associateProfessor.introduce();
    }
}