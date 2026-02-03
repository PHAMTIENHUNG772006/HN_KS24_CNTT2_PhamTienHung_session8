import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int index = 0;
        int choice;

        do {

            System.out.println("\n=============== Quản lý điểm sinh viên============");
            System.out.println("1. Nhập danh sách sinh viên ");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo Học lực ");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát ");

            System.out.println("===============================================");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    int n;
                    System.out.print("Mời nhập số lượng sinh viên : ");
                    n = Integer.parseInt(sc.nextLine());

                    boolean valid = true; // cờ kiểm tra dữ liệu hợp lệ

                    for (int i = 0; i < n; i++) {
                        System.out.printf("Mời nhập mã sinh viên(SV000) thứ %d: ", i + 1);
                        String student_id = sc.nextLine();
                        if (!student_id.matches("^SV\\d{3}$")) {
                            System.out.println("Mã sinh viên không theo định dạng");
                            valid = false;
                            break;
                        }

                        System.out.printf("Mời nhập tên sinh viên thứ %d: ", i + 1);
                        String student_name = sc.nextLine();
                        if (student_name.trim().isEmpty()) {
                            System.out.println("Tên Sinh viên không được để trống");
                            valid = false;
                            break;
                        }

                        System.out.printf("Mời nhập điểm sinh viên thứ %d: ", i + 1);
                        double score = Double.parseDouble(sc.nextLine());
                        if (score < 0 || score > 10) {
                            System.out.println("Điểm nhập vào không hợp lệ");
                            valid = false;
                            break;
                        }

                        Student newStudent = new Student(student_id, student_name, score);
                        students[index] = newStudent;
                        index++;
                        System.out.println("Thêm sinh viên thành công");
                    }

                    if (!valid) {
                        break;
                    }

                    break;
                }
                case 2: {
                    System.out.println("Danh sách sinh viên: ");
                    for (Student student : students) {
                       if (student != null){
                           System.out.println(student.toString());
                       }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Mời nhập học lực muốn tìm kiếm");
                    String findStudentbyRank = sc.nextLine();

                    if (findStudentbyRank.trim().isEmpty()) {
                        System.out.println("Chuỗi nhập rỗng");
                    }

                    for (int i = 0; i < index; i++) {
                        if (students[i].getRank().equalsIgnoreCase(findStudentbyRank)) {
                            System.out.println(students[i].toString());
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Danh sách sinh viên trước khi sắp xếp : ");
                    for (Student student : students) {
                        System.out.println(student.toString());
                    }

                    for (int i = 0; i < index - 1; i++) {
                        for (int j = 0; j < index - i - 1; j++) {
                            if (students[j].getScore() < students[j + 1].getScore()) {
                                Student temp = students[j];
                                students[j] = students[j + 1];
                                students[j + 1] = temp;
                            }
                        }
                    }

                    System.out.println("Danh sách sinh viên sau khi sắp xếp : ");
                    for (Student student : students) {
                        System.out.println(student.toString());
                    }


                    break;
                }
                case 5:
                    System.out.println("Đã thoát chương trình");
                    break;
                default:
                    System.out.println("Lỗi lựa chọn không hợp lệ");
            }
        } while (choice != 5);
    }
}