import java.util.Scanner;

public class Student {
    public String name;
    public int age;
    public double[] marks = new double[5];

    public  Student(String name, int age, double[] marks) {
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

    public int calculateTotal() {
        int total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculatePercentage() {
        int totalMarks = calculateTotal();
        return (double) totalMarks / marks.length;
    }

    public void displayinfo() {
        System.out.println("Student Name:" + name);
        System.out.println("Student Age:" + age);
        System.out.println("Marks:");
        for (double mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println("Total marks :" + calculateTotal());
        System.out.println("The percentage you secured is :" + calculatePercentage());
    }

}

public class Student2 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Enter name of the student");
        String name = Scanner.nextLine();

        System.out.println("Enter student's age");
        int age = Scanner.nextInt();

        double[] marks = new double[5];
        System.out.println("Enter the marks of 5 subjects: ");
        for (int i = 0; i < 5; i++) {
            marks[i] = Scanner.nextDouble();
        }

        Student student = new Student(name, age, marks);

        student.displayinfo();

        Scanner.close();

    }
}
