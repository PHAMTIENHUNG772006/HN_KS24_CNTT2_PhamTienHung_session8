public class Student {
    private String student_id;
    private String student_name;
    private  double score;
    private String rank;

    public Student() {
    }

    public Student(String student_id, String student_name, double score) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.score = score;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (this.score >= 8){
            rank = "Giỏi";
        }else if (this.score < 8 && this.score >= 6.5){
            rank = "Khá";
        }else {
            rank = "Trung bình";
        }
        return rank;
    }






    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", score=" + score +
                ", rank='" + getRank() + '\'' +
                '}';
    }


}
