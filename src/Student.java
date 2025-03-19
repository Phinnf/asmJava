

public class Student {
	private String studentID;
	private String studentName;
	private double marksOfStudent;


	public Student(String studentID, String studentName, double marksOfStudent) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.marksOfStudent = marksOfStudent;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getMarksOfStudent() {
		return marksOfStudent;
	}

	public void setMarksOfStudent(double marksOfStudent) {
		this.marksOfStudent = marksOfStudent;
	}

	public String getScore(double marksOfStudent) {
		if (marksOfStudent < 5) {
			return "Fail";
		} else if (marksOfStudent < 6.5) {
			return "Medium";
		} else if (marksOfStudent < 7.5) {
			return "Good";
		} else if (marksOfStudent < 9) {
			return "Very Good";
		} else return "Excellent";
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentID='" + getStudentID() + '\'' +
				", studentName='" + getStudentName() + '\'' +
				", marksOfStudent=" + getMarksOfStudent() +
				", studentRanking='" + getScore(marksOfStudent) + '\'' +
				'}';
	}
}
