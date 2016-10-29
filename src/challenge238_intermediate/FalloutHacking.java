package challenge238_intermediate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


public class FalloutHacking {
	
	enum GameDifficulty {VERY_EASY, EASY, AVERAGE, HARD, VERY_HARD;}
	private Map Words;
	private String answer;
	private List<String> candidates;
	private int wordLength;
	private int numberOfWords;
	private int guessesRemaining;
	public FalloutHacking() {
		
		Words = new Hashtable();
		try {
			this.readWordsToMap();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reset(GameDifficulty gd) {
		answer = null;
		candidates = null;
		guessesRemaining = 4;
		this.setGameDifficulty(gd);
	}
	private void setGameDifficulty(GameDifficulty gd){
		Random rdm = new Random();
		switch(gd){
		case VERY_EASY: wordLength = rdm.nextInt(2) + 4;
						numberOfWords = rdm.nextInt(2) + 5;
						break;
		case EASY: 		wordLength =  rdm.nextInt(2) + 6;
						numberOfWords = rdm.nextInt(2) + 7;
						break;
		case AVERAGE:	wordLength =  rdm.nextInt(3) + 8;
						numberOfWords = rdm.nextInt(2) + 9;
						break;
		case HARD:		wordLength =  rdm.nextInt(3) + 11;
						numberOfWords = rdm.nextInt(2) + 11;
						break;
		case VERY_HARD:	wordLength =  rdm.nextInt(2) + 14;
						numberOfWords = rdm.nextInt(3) + 13;
						break;
		}
		this.setCandidates();
	}
	private void setCandidates(){
		Random selector = new Random();
		List<String> wordList = (List<String>)Words.get(wordLength);
		int randBound = wordList.size();
		candidates = new ArrayList<String>();
		for(int i = 0; i < numberOfWords; i++){
			candidates.add(wordList.get(selector.nextInt(randBound)));
		}
		randBound = candidates.size();
		answer = candidates.get(selector.nextInt(randBound));
	}
	public void getCandidates(){
		for(String s: candidates){
			System.out.println(s);
		}
	}
	public int tryAnswer(String s){
		if(s.equals(answer)){
			return answer.length();
		}else{
			char[] input = s.toCharArray();
			char[] ans = answer.toCharArray();
			int correctPositions = 0;
			for(int i = 0; i < input.length; i++){
				if(input[i] == ans[i]){
					correctPositions++;
				}
			}
			guessesRemaining--;
			return correctPositions;
		}
	}
	public int getNumberOfRemainingGuesses(){
		return guessesRemaining;
	}
	private void readWordsToMap() throws FileNotFoundException{
		File wordSource = new File("enable1.txt");
		Scanner input = new Scanner(wordSource);
		
		
		while(input.hasNext()){
			String listVal = input.next();
			int listKey = listVal.length();
			
			if(Words.containsKey(listKey)){
				List<String> tempList = (List<String>)Words.get(listKey);
				tempList.add(listVal);
			}else{
				List<String> tempList = new ArrayList<String>();
				tempList.add(listVal);
				Words.put(listKey, tempList);
			}
		}
		input.close();
	}

	public static void main(String[] args) {
		FalloutHacking fh = new FalloutHacking();
		boolean playing = true;
		String guess;
		int positions;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Difficulty (1 - 5): ");
		int difficulty = keyboard.nextInt();
		switch(difficulty){
		case 1: fh.reset(GameDifficulty.VERY_EASY); break;
		case 2: fh.reset(GameDifficulty.EASY); break;
		case 3: fh.reset(GameDifficulty.AVERAGE); break;
		case 4: fh.reset(GameDifficulty.HARD); break;
		case 5: fh.reset(GameDifficulty.VERY_HARD); break;
		}

		fh.getCandidates();
		while(playing){
			
			System.out.print("\nEnter guess: ");
			guess = keyboard.next();
			positions = fh.tryAnswer(guess);
			if(positions == guess.length()){
				System.out.println("Correct!");
				playing = false;
			}else{
				System.out.println(positions + "/" + guess.length() + " correct");
				System.out.println("Guesses remaining: " + fh.guessesRemaining);
			}
			if(fh.guessesRemaining < 1){
				playing = false;
			}
		}
		

	}

}
