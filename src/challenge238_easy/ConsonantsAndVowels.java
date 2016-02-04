	package challenge238_easy;
	
	import java.util.Random;
	
	public class ConsonantsAndVowels{
		
		private final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
		private final String VOWELS = "aeiou";
		private final int CRANGE = 21;
		private final int VRANGE = 5;
		private Random index;
		private String generatedWord;
		
		public ConsonantsAndVowels() {
			index = new Random();
		}
		public ConsonantsAndVowels(String input){
			this();
			generatedWord = this.newWord(input);
		}
		public String getNewWord(){
			return generatedWord;
		}
		public void generateNewWord(String input){
			generatedWord = this.newWord(input);
		}
		private String newWord(String input) throws IllegalArgumentException{
			char[] newWord = new char[input.length()];
			for(int i = 0; i < input.length(); i++){
				
				switch(input.charAt(i)){
					case 'c': newWord[i] = CONSONANTS.charAt(index.nextInt(CRANGE));
					break;
					case 'C': newWord[i] = Character.toUpperCase(CONSONANTS.charAt(index.nextInt(CRANGE)));
					break;
					case 'v': newWord[i] = VOWELS.charAt(index.nextInt(VRANGE));
					break;
					case 'V': newWord[i] = Character.toUpperCase(VOWELS.charAt(index.nextInt(VRANGE)));
					break;
					default: throw new IllegalArgumentException("Invalid input.");
				}
			}
			
			return String.copyValueOf(newWord);
		}
		public static void main(String[] args) {
			String input1 = "cvcvcc";
			String input2 = "CcvV";
			String input3 = "cvcvcvcvcvcvcvcvcvcv";
			
			ConsonantsAndVowels cav = new ConsonantsAndVowels(input1);
			System.out.print("Input: " + input1 + "\t");
			System.out.println("Output: " + cav.getNewWord());		
			
			cav.generateNewWord(input2);
			System.out.print("Input: " + input2 + "\t");
			System.out.println("Output: " + cav.getNewWord());		
			
			cav.generateNewWord(input3);
			System.out.print("Input: " + input3 + "\t");
			System.out.println("Output: " + cav.getNewWord());		
	
		}
	
	}
