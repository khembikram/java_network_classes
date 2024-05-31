import java.util.Scanner;

public class revision2_java {
    public class student {
        public String name;
        public int age;
        public double[] marks = new double[5];


        public student (String name, int age , double[] marks){
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        public int calculateTotal() {
            int total = 0;
            for(double mark : marks) {
                total += mark;
            }
            return total;
        }

        public void displayinfo(){
            System.out.println("Student Name:" + name);
            System.out.println("Student Age:" + age);
            System.out.println("Marks:");
            for(double mark : marks){
                System.out.print(mark + " ");
            }
            System.out.println();
            System.out.println("Total marks :" + calculateTotal());
        }


    }
    public static void main(String[] args){
        System.out.println("Enter name of the student");

    }    
}
