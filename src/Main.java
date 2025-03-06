import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentManagement myClass = new StudentManagement();
		Scanner input = new Scanner(System.in);
		String userChoice;

		do {
			System.out.println("-".repeat(25) + " Student Managing System " + "-".repeat(25));
			System.out.println("0. Exit the Program ");
			System.out.println("1. Add Student ");
			System.out.println("2. Edit Student ");
			System.out.println("3. Delete Student ");
			System.out.println("4. Sort Student ");
			System.out.println("5. Search Student ");
			System.out.println("6. Show Students ");
			userChoice = input.nextLine();

			switch (userChoice) {
				case "0", "exit":
					System.out.println("Goodbye!");
					input.close();
					break;
				case "1":
					myClass.addStudent();
					break;
				case "2":
					myClass.editStudent();
					break;
				case "3":
					myClass.deleteStudentInfo();
					break;
				case "4":
					myClass.sortStudent();
					break;
				case "5":
					myClass.searchForStudent();
					break;
				case "6":
					myClass.showStudentInfo();
					break;
				default:
					System.out.println("Please choose from 0 - 6");
			}
		} while (!userChoice.equals("0") && !userChoice.equals("exit"));
	}
}