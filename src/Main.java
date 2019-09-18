import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();

        String randomName = game.getRandomName();
        String randomNameWithoutWhiteSpaces = randomName.replaceAll("\\s", "");
        System.out.println(String.format("Guess the guy: %s", randomName));
        int wrongGuess = 0;
        String hiddenName = game.hideCharacters(randomName);
        List<Character> currentGuessAsChars = game.getCharacters(randomName);
        List<Character> charsGuessed = new ArrayList<>();
        int rightGuessedLettersCount = 0;

        boolean gameIsOn = true;
        while (gameIsOn == true) {
            String currentCharGuess = game.getUserGuess();
            final boolean alreadyGuessed = game.isCharAlreadyGuessed(charsGuessed, currentCharGuess);
            
            boolean charFound = false;
            for (int i = 0; i < currentGuessAsChars.size(); i++) {
                Character character = currentGuessAsChars.get(i);
                if (character == currentCharGuess.charAt(0)) {
                    //Reveal hidden char
                    hiddenName = hiddenName.substring(0, i) + currentCharGuess + hiddenName.substring(i + 1);
                    charFound = true;
                    if (alreadyGuessed == false) {
                        rightGuessedLettersCount++;
                    }
                }
            }

            if (charFound == false) {
                if (alreadyGuessed == false) {
                    wrongGuess++;
                }
            }
            charsGuessed.add(currentCharGuess.charAt(0));

            if (wrongGuess == 10) {
                System.out.println("Game over! You have guessed 10 times wrong.");
                gameIsOn = false;
            } else if (rightGuessedLettersCount == randomNameWithoutWhiteSpaces.length()) {
                System.out.println(String.format("You won! Right answer is: '%s'", randomName));
                gameIsOn = false;
            } else {
                System.out.println(String.format("You are guessing: %s.", hiddenName));
                System.out.println(String.format("You have %d wrong answers.", wrongGuess));
            }
        }
    }
}
