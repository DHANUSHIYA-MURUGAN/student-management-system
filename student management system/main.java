import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    service.addStudent(new Student(id, name, age, dept));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student s = service.searchStudent(searchId);
                    if (s != null)
                        System.out.println("Found: " + s);
                    else
                        System.out.println("Student not found!");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Department: ");
                    String newDept = sc.nextLine();

                    if (service.updateStudent(updateId, newName, newAge, newDept))
                        System.out.println("Updated successfully!");
                    else
                        System.out.println("Student not found!");
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    if (service.deleteStudent(deleteId))
                        System.out.println("Deleted successfully!");
                    else
                        System.out.println("Student not found!");
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
