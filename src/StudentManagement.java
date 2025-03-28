import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class StudentManagement {
	public static final AtomicInteger counter = new AtomicInteger();
	private final List<Student> students = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	// ------------------------------------------------------
	public void addStudent() {
		Student newStudent = new Student(increaseStudentID(), scanForUserInputName(), scanForUserInputMark());
		students.add(newStudent);
	}

	public String increaseStudentID() {
		return "#" + counter.incrementAndGet();
	}

	public String scanForUserInputName() {
		System.out.println("What is the studentName: ");
		return input.nextLine();
	}

	public double scanForUserInputMark() {
		do {
			try {
				System.out.println("What are the marks of Student: ");
				double studentMark = input.nextDouble();
				input.nextLine();
				while (studentMark < 0 || studentMark > 10) {
					System.out.println("Please enter a valid number between 0 and 10.");
					studentMark = input.nextDouble();
					input.nextLine();
				}
				return studentMark;
			} catch (InputMismatchException exception) {
				System.out.println("Please enter a valid number." + exception);
			}
		} while (true);
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
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentID().equals(studentID)) {
				return i;
			}
		}
		return -1;
	}

	public void setStudent(int index) {
		Student existingStudent = students.get(index);
		existingStudent.setStudentName(scanForUserInputName());
		existingStudent.setMarksOfStudent(scanForUserInputMark());
	}

	public String scanForUserID() {
		System.out.println("What is the Student new ID ");
		return input.nextLine();
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
		students.remove(index);
	}

	// -----------------------------------------------------------------
	public void sortStudent() {
		int n = students.size();
		for (int i = 0; i < n; i++) {
			int maxIndex = i;
			double minStudentName = students.get(i).getMarksOfStudent();
			for (int j = i + 1; j < n; j++) {
				if (minStudentName < students.get(j).getMarksOfStudent()) {
					minStudentName = students.get(j).getMarksOfStudent();
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				Student temp = students.get(i);
				students.set(i, students.get(maxIndex));
				students.set(maxIndex, temp);
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

	public void searchAndPrintStudent(String theString /*String in Switch*/, String searchStudent) {
		for (Student student : students) {
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
		for (Student showStudent : students) {
			System.out.println(showStudent);
		}
	}

	// ---------------------------------------------------
	// Small Method
	private static void studentNotFound() {
		System.out.println("Student not found.");
	}
}
