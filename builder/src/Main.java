public class Main {

    public static void main(String[] args) {
        Student s = new Student.StudentBuilder("현우")
                .major("컴공")
                .midScore(100)
                .finalScore(90)
                .hwScore(80)
                .build();

        s.printStudent();
    }
}
