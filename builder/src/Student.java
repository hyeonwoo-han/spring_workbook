public class Student {
    private String name;
    private String major;
    private double midScore;
    private double finalScore;
    private double hwScore;

    public void printStudent(){
        System.out.println(name + " " + major + " " + midScore + " " + finalScore + " " + hwScore);
    }
    // Studnet 생성자 대신 StudentBuilder 생성
    public static class StudentBuilder{
        private String name;
        private String major;
        private double midScore;
        private double finalScore;
        private double hwScore;

        public StudentBuilder(String name){ // 필수 멤버는 생성자에
            this.name = name;
        }

        public StudentBuilder major(String major){
            this.major = major;
            return this;    // 클래스 객체 반환
        }

        public StudentBuilder midScore(double midScore){
            this.midScore = midScore;
            return this;
        }

        public StudentBuilder finalScore(double finalScore){
            this.finalScore = finalScore;
            return this;
        }

        public StudentBuilder hwScore(double hwScore){
            this.hwScore = hwScore;
            return this;
        }

        public Student build(){
            Student s = new Student();
            s.name = this.name;
            s.major = this.major;
            s.midScore = this.midScore;
            s.finalScore = this.finalScore;
            s.hwScore = this.hwScore;
            return s;
        }
    }
}
