import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Gets randomly a name from the specified file.
     *
     * @return Randomly one name from specified file
     * @throws FileNotFoundException thrown if file not found
     */
    public static String getRandomName() throws FileNotFoundException {
        File file = new File("names.txt");
        Scanner fileScanner = new Scanner(file);
        String name;
        List<String> names = new ArrayList<>();
        Random random = new Random();

        while (fileScanner.hasNext()) {
            name = fileScanner.nextLine();
            names.add(name);
        }

        int randomInteger = random.nextInt(names.size());
        return names.get(randomInteger).toLowerCase();
    }

    /**
     * Getting user's guess.
     *
     * @return Users answer
     */
    public static String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type your gues as an character: ");
        return scanner.next();
    }

    /**
     * Replace characters with '_' of specified string.
     *
     * @param stringToHide String to be hidden
     * @return Hidden string
     */
    public static String hideCharacters(final String stringToHide) {
        return stringToHide.replaceAll("[^ ]", "_");
    }

    /**
     * Get characters from specified string.
     *
     * @param randomName Name to use
     * @return name's characters
     */
    public static List<Character> getCharacters(final String randomName) {
        List<Character> letters = new ArrayList<>();
        char letter;
        for (int i = 0; i < randomName.length(); i++) {
            letter = randomName.charAt(i);
            letters.add(letter);
        }
        System.out.println(letters);
        return letters;
    }

    /**
     * Checks is character already guessed.
     *
     * @param charsGuessed Already guessed characters in other rounds
     * @param currentGuess Currently guessed character
     * @return is character guessed (true/false)
     */
    public static boolean isCharAlreadyGuessed(final List<Character> charsGuessed, final String currentGuess) {
        if (charsGuessed != null) {
            for (int j = 0; j < charsGuessed.size(); j++) {
                if (currentGuess.charAt(0) == charsGuessed.get(j)) {
                    System.out.println("You have already guessed this letter. Please try again:");
                    return true;
                }
                continue;
            }
        }
        return false;
    }
}
