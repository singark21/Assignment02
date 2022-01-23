package assign02;

import java.util.ArrayList;

public class CS2420Student extends UofUStudent {

	private EmailAddress email;
	private ArrayList<Double> assignmentScores = new ArrayList<>(), examScores = new ArrayList<>(), labScores = new ArrayList<>(), quizScores = new ArrayList<>();
	public CS2420Student(String firstName, String lastName, int uNID, EmailAddress contactInfo) {
		super(firstName, lastName, uNID);
		this.email = contactInfo;

	}

	public ArrayList<Double> getExamScores(){
		return examScores;
	}
	public ArrayList<Double> getLabScores(){
		return labScores;
	}
	public ArrayList<Double> getQuizScores(){
		return quizScores;
	}
	public ArrayList<Double> getAssignmentScores(){
		return assignmentScores;
	}
	public EmailAddress getContactInfo() {
		return email;
	}

	public void addScore(double score, String category) {

		if (score >= 0 && score <= 100) {

			switch (category) {
			case "lab":
				labScores.add(score);
				break;
			case "quiz":
				quizScores.add(score);
				break;
			case "assignment":
				assignmentScores.add(score);
				break;
			case "exam":
				examScores.add(score);
				break;

			}
		}
	}

	public double computeFinalScore() {
		if(examScores.size() == 0 || quizScores.size() == 0 || assignmentScores.size() == 0 || labScores.size() == 0)
			return 0.0;
	    double finalScore = 0;
		double quizAverage = 0;
		double examAverage = 0;
		double assignmentAverage = 0;
		double labAverage = 0;
		for(int i  = 0; i < quizScores.size(); i++) {
			quizAverage += quizScores.get(i);
		}
		quizAverage = quizAverage/quizScores.size();
		quizAverage *= 0.1;
		
		for(int i  = 0; i < examScores.size(); i++) {
			examAverage += examScores.get(i);
		}
		examAverage = examAverage/examScores.size();
		if(examAverage > 65)
		examAverage *= 0.4;
		else
		return examAverage;
	
	for(int i  = 0; i < labScores.size(); i++) {
		labAverage += labScores.get(i);
	}
	labAverage = labAverage/labScores.size();
	labAverage *= 0.1;
	for(int i  = 0; i < assignmentScores.size(); i++) {
		assignmentAverage += assignmentScores.get(i);
	}
	assignmentAverage = assignmentAverage/assignmentScores.size();
	assignmentAverage *= 0.4;
	finalScore += assignmentAverage + quizAverage + labAverage + examAverage;
	return finalScore;
	}
	public String computeFinalGrade() {
		
		double finalScore = computeFinalScore();
		if(finalScore <= 0)
			return "N/A";
		if(finalScore >= 93)
			return "A";
		if(finalScore >= 90)
			return "A-";
		if(finalScore >= 87)
			return "B+";
		if(finalScore >= 83) 
			return "B";
		if(finalScore >= 80)
			return "B-";
		if(finalScore >= 77)
			return "C+";
		if(finalScore >= 73)
			return "C";
		if(finalScore >= 70)
			return "C-";
		if(finalScore >= 67)
			return "D+";
		if(finalScore >= 63) 
			return "D";
		if(finalScore >= 60)
			return "D-";
		return "E";
	}

}
