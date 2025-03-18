import java.util.*;

public class StudentManagement {

	private final List<Student> Students = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	// ------------------------------------------------------
	public void addStudent() {
		Student newStudent = scanForUserInput();
		functionForAddStudent(newStudent);
	}

	public Student scanForUserInput() {
		System.out.println("What is the studentID: ");
		String studentID = input.nextLine();

		System.out.println("What is the studentName: ");
		String studentName = input.nextLine();

		System.out.println("What are the mark of Student: ");
		double studentMark = input.nextDouble();
		input.nextLine();

		return new Student(studentID, studentName, studentMark);
	}

	public void functionForAddStudent(Student student) {
		Students.add(student);
	}

	// -------------------------------------------------------------
	public void editStudent() {
		System.out.println("Enter the student ID you want to change: ");
		String findStudentID = input.nextLine();

		int index = findStudentIndex(findStudentID);

		if (index != -1) {
			setStudent(index);
		} else {
			studentNotFound();
		}
	}

	public int findStudentIndex(String studentID) {
		for (int i = 0; i < Students.size(); i++) {
			if (Students.get(i).getStudentID().equals(studentID)) {
				return i;
			}
		}
		return -1;
	}

	public void setStudent(int index) {
		Student updateStudent = scanForUserInput();
		Students.set(index, updateStudent);
	}

	// -------------------------------------------------------------
	public void deleteStudentInfo() {
		System.out.println("Enter the student ID you want to Delete: ");
		String deleteStudentID = input.nextLine();

		int index = findStudentIndex(deleteStudentID);

		if (index != -1) {
			deleteStudent(index);
		}
	}

	public void deleteStudent(int index) {
		Students.remove(index);
	}

	// -----------------------------------------------------------------
	public void sortStudent() {
		int n = Students.size();
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			String minStudentName = Students.get(i).getStudentName();
			for (int j = i + 1; j < n; j++) {
				if (Students.get(j).getStudentName().compareToIgnoreCase(minStudentName) < 0) {
					minStudentName = Students.get(j).getStudentName();
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Student temp = Students.get(i);
				Students.set(i, Students.get(minIndex));
				Students.set(minIndex, temp);
			}
		}
	}
	// Code su dung BubbleSort
	//		int n = Students.size();
//		for (int i = 0; i < n; i++) {
//			for (int j = 1; j < n; j++) {
//				if (Students.get(i).getStudentName().compareToIgnoreCase(Students.get(j).getStudentName()) > 0) {
//					Student temp = Students.get(i);
//					Students.set(i, Students.get(j));
//					Students.set(j, temp);
//				}
//			}
//		}


	// Code su dung comparator
//		System.out.println("id. To sort by studentID: ");
//		System.out.println("name. To sort by name: ");
//		System.out.println("mark. To sort by mark: ");
//		String userChoice;
//		do {
//			userChoice = input.nextLine();
//			switch (userChoice.toLowerCase()) {
//				case "id":
//					Students.sort(Comparator.comparing(Student::getStudentID));
//					break;
//				case "name":
//					Students.sort(Comparator.comparing(Student::getStudentName));
//					break;
//				case "mark":
//					Students.sort(Comparator.comparingDouble(Student::getMarksOfStudent));
//					break;
//				default:
//					System.out.println("Please enter the right keyword (id, name, mark)");
//			}
//		} while (userChoice.equals("id") || userChoice.equals("name") || userChoice.equals("mark"));

	// ------------------------------------------------------------
	public void searchForStudent() {
		System.out.println("Enter the thing you want to search (id, name, mark)");
		String userChoice = input.nextLine();

		switch (userChoice.toLowerCase()) {
			case "id":
				System.out.println("What is the (StudentID) you want to find ");
				String searchStudentID = input.nextLine();
				searchAndPrintStudent("id", searchStudentID);
				break;
			case "name":
				System.out.println("What is the (StudentID) you want to find ");
				String searchStudentName = input.nextLine();
				searchAndPrintStudent("name", searchStudentName);
				break;
			case "mark":
				System.out.println("What is the (StudentID) you want to find ");
				String searchStudentMark = input.nextLine();
				searchAndPrintStudent("mark", searchStudentMark);
				break;
			default:
				System.out.println("Student not found");
		}

	}

	public void searchAndPrintStudent(String theString, String searchStudent) {
		for (Student student : Students) {
			boolean studentFound = false;

			switch (theString) {
				case "id":
					if (student.getStudentID().equals(searchStudent)) {
						studentFound = true;
					}
					break;
				case "name":
					if (student.getStudentName().equals(searchStudent)) {
						studentFound = true;
					}
					break;
				case "mark":
					double mark = Double.parseDouble(searchStudent);
					if (student.getMarksOfStudent() == mark) {
						studentFound = true;
					}
					break;
			}
			if (studentFound) {
				System.out.println(student);
				return;
			}
		}
	}

	// ------------------------------------------------------
	public void showStudentInfo() {
		for (Student showStudent : Students) {
			System.out.println(showStudent);
		}
	}

	// ---------------------------------------------------
	// Small Method
	private static void studentNotFound() {
		System.out.println("Student not found.");
	}
}
