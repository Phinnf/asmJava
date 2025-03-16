import java.util.*;

public class StudentManagement {

	private final List<Student> Students = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	public void addStudent() {
		System.out.println("What is the studentID: ");
		String studentID = input.nextLine();

		System.out.println("What is the studentName: ");
		String studentName = input.nextLine();

		System.out.println("What are the mark of Student: ");
		double studentMark = input.nextDouble();
		input.nextLine();

		Student newStudents = new Student(studentID, studentName, studentMark);
		String studentRank = newStudents.getScore(studentMark);
		Student newStudentAfter = new Student(studentID, studentName, studentMark, studentRank);
		Students.add(newStudentAfter);
	}

	public void editStudent() {
		System.out.println("Enter the student ID you want to change: ");
		String findStudentID = input.nextLine();

		for (int i = 0; i < Students.size(); i++) {
			Student currentStudent = Students.get(i);
			if (currentStudent.getStudentID().equals(findStudentID)) {
				System.out.println("What is the studentID you want to change: ");
				String editStudentID = input.nextLine();


				System.out.println("What is the name you want to change: ");
				String editName = input.nextLine();


				System.out.println("What is the mark you want to change: ");
				double editMark = input.nextDouble();


				Student updateStudent = new Student(editStudentID, editName, editMark);
				Students.set(i, updateStudent);
			} else {
				System.out.println("ID not found");
			}
		}
	}

	public void showStudentInfo() {
		for (Student showStudent : Students) {
			System.out.println(showStudent);
		}
	}

	public void deleteStudentInfo() {
		System.out.println("Enter the student ID you want to Delete: ");
		String deleteStudentID = input.nextLine();

		for (int i = 0; i < Students.size(); i++) {
			Student currentStudent = Students.get(i);
			if (currentStudent.getStudentID().equals(deleteStudentID)) {
				Students.remove(currentStudent);
			} else {
				System.out.println("ID not found");
			}
		}
	}

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
			if (minIndex != i){
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


	public void searchForStudent() {
		System.out.println("(id) To search by studentID: ");
		System.out.println("(name) To search by name: ");
		System.out.println("(mark) To search by mark: ");
		String userChoice;
		do {
			userChoice = input.nextLine();
			for (Student searchStudent : Students) {
				switch (userChoice.toLowerCase()) {
					case "id":
						System.out.println("What is the (studentID) you want to find: ");
						String searchStudentID = input.nextLine();
						if (searchStudent.getStudentID().equals(searchStudentID)) {
							System.out.println(searchStudent);
							break;
						}
					case "name":
						System.out.println("What is the student (Name) you want to find: ");
						String searchStudentName = input.nextLine();
						if (searchStudent.getStudentName().equals(searchStudentName)) {
							System.out.println(searchStudent);
							break;
						}
					case "mark":
						System.out.println("What is the student (Mark) you want to find: ");
						double searchStudentMark = input.nextDouble();
						if (searchStudent.getMarksOfStudent() == (searchStudentMark)) {
							System.out.println(searchStudent);
							break;
						}
					default:
						System.out.println("Please enter the right keyword(id, name, mark)");
				}
			}
		} while (!userChoice.equals("id") && !userChoice.equals("name") && !userChoice.equals("mark"));
	}
}
