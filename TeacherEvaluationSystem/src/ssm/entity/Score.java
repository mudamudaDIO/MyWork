package ssm.entity;

import java.text.DecimalFormat;

public class Score {
	public static int getScore(String answer) {
		switch(answer) {
			case "A":
				return 10;
			case "B":
				return 8;
			case "C":
				return 6;
			case "D":
				return 3;
		}
		return 0;
	}
	
	public static int countScore(String answer1,String answer2,String answer3,String answer4,String answer5,String answer6
			,String answer7,String answer8,String answer9,String answer10) {
		int score=(getScore(answer10)+getScore(answer9)+getScore(answer8)+getScore(answer7)+getScore(answer6)+getScore(answer5)
					+getScore(answer4)+getScore(answer3)+getScore(answer2)+getScore(answer1));
		
		return score;
	}
}
