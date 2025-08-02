package bullscows;

import java.sql.SQLOutput;

public class Main {
    private static void stageOne() {
        /// --- First stage of the project ---
        /// Pretty simple stage, all I had to do
        /// was to print a possible game of
        /// "Bulls and cows".
        System.out.println("The secret code is prepared: ****.");
        System.out.println("Turn 1. Answer:");
        System.out.println("1234");
        System.out.println("Grade: 1 bull.");
        System.out.println("Turn 2. Answer:");
        System.out.println("2134");
        System.out.println("Grade: 1 cow.");
        System.out.println("Turn 3. Answer:");
        System.out.println("1342");
        System.out.println("Grade: 1 bull.");
        System.out.println("Turn 4. Answer:");
        System.out.println("1567");
        System.out.println("Grade: 2 bulls and 1 cow.");
        System.out.println("Turn 5. Answer:");
        System.out.println("1576");
        System.out.println("Grade: 3 bulls.");
        System.out.println("Turn 6. Answer:");
        System.out.println("1579");
        System.out.println("Grade: 4 bulls.");
        System.out.println("Congrats! The secret code is 1579");
    }
    private static void stageTwo() {
        /// --- Second stage of the project ---
        /// This stage wants to introduce one singular
        /// round of the game, with a preset code. This
        /// stage is also simple, since it has no
        /// restrictions whatsoever. If another type of
        /// variable is introduced, no exceptions are
        /// thrown, but the compiler will throw an error
        /// and the program will cease to work. This will
        /// be fixed as soon as it is asked of me.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String code = "9305", input = scanner.nextLine();
        int cows = 0, bulls = 0;
        if (code.charAt(0) == input.charAt(0))
            bulls++;
        else if (code.contains(String.valueOf(input.charAt(0))))
            cows++;
        if (code.charAt(1) == input.charAt(1))
            bulls++;
        else if (code.contains(String.valueOf(input.charAt(1))))
            cows++;
        if (code.charAt(2) == input.charAt(2))
            bulls++;
        else if (code.contains(String.valueOf(input.charAt(2))))
            cows++;
        if (code.charAt(3) == input.charAt(3))
            bulls++;
        else if (code.contains(String.valueOf(input.charAt(3))))
            cows++;
        System.out.print("Grade: ");
        if (bulls > 0 && cows > 0)
            System.out.print(bulls + " bull(s) and " + cows + " cow(s).");
        else if (bulls > 0)
            System.out.print(bulls + " bull(s).");
        else if (cows > 0)
            System.out.print(cows + " cow(s).");
        else
            System.out.print("None.");
        System.out.println(" The secret code is " + code + ".");
    }
    private static int stageThree() {
        /// --- Third stage of the project ---
        /// This stage made me implement a way of
        /// generating a code of a specified length.
        /// I am proud of the way I managed to
        /// implement the generation, and the rest
        /// of the task only consisted of printing
        /// strings and getting input.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int number = scanner.nextInt();
        String secretCode = generateSecretCode(number, false);
        if (secretCode.equals(" "))
            return 1;
        System.out.println("The random secret number is " + secretCode + ".");
        return 1;
    }
    private static int stageFour() {
        /// --- Fourth stage of the project ---
        /// This stage had me make an entire game
        /// loop and use previous bits and snippets
        /// of it to make it work. I refactored the
        /// code in some ways and made repeating
        /// parts of it entire new methods that I
        /// reused both where the part was originally
        /// from and where I needed to use it next.
        /// The project has finally started to
        /// resemble a working game. I am sure that
        /// bugs may still occur, but that will be
        /// fixed as I progress through the stages.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int number = scanner.nextInt();
        System.out.println("Okay, let's start a game!");
        scanner.nextLine();
        String secretCode = generateSecretCode(number, false);
        if (secretCode.equals(" "))
            return 1;
        int digitsGuessed = 0, turn = 1;
        while (digitsGuessed != secretCode.length()) {
            System.out.println("Turn " + turn + ":");
            turn++;
            String input = scanner.nextLine();
            digitsGuessed = gameLoop(secretCode, input);
        }
        System.out.println("Congratulations! You guessed the correct code.");
        return 1;
    }
    private static int stageSix() {
        /// --- Sixth stage of the project ---
        /// This stage wanted me to implement
        /// a harder version of it, with harder
        /// to guess secret codes, containing
        /// letters too. Not too hard to
        /// implement, since I have all the
        /// previous stages and can reuse them.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int number = scanner.nextInt();
        System.out.println("Okay, let's start a game!");
        scanner.nextLine();
        String secretCode = generateSecretCode(number, true);
        if (secretCode.equals(" "))
            return 1;
        int digitsGuessed = 0, turn = 1;
        while (digitsGuessed != secretCode.length()) {
            System.out.println("Turn " + turn + ":");
            turn++;
            String input = scanner.nextLine();
            digitsGuessed = gameLoop(secretCode, input);
        }
        System.out.println("Congratulations! You guessed the correct code.");
        return 1;
    }
    /// --- Stage 7 of the project ---
    /// All this stage had me do is implement
    /// a few new errors and exceptions.
    /// Pretty simple stage, done reusing
    /// most of stage 6's code.
    /// Finally done with this project.
    private static int stageSeven() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        String nextLine = scanner.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(nextLine);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + nextLine + "\" isn't a valid number.");
            return 0;
        }
        System.out.println("Okay, let's start a game!");
        String secretCode = generateSecretCode(number, true);
        if (secretCode.equals(" "))
            return 1;
        int digitsGuessed = 0, turn = 1;
        while (digitsGuessed != secretCode.length()) {
            System.out.println("Turn " + turn + ":");
            turn++;
            String input = scanner.nextLine();
            digitsGuessed = gameLoop(secretCode, input);
        }
        System.out.println("Congratulations! You guessed the correct code.");
        return 1;
    }
    private static String generateSecretCode(int number, boolean containsLetters) {
        long secretCode = 999999999999999999L; /// this value should not be reached at any point
        if (!containsLetters) {
            if (number > 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because " +
                        "there aren't enough unique digits.");
                return " ";
            } else if (number < 1) {
                System.out.println("Error: can't generate a secret number with fewer than 1 digits.");
                return " ";
            }
            int[] zeroThroughNine = new int[10];
            for (int i = 0; i <= 9; i++)
                zeroThroughNine[i] = 0;
            secretCode = 0;
            /// --- Fifth version of the code ---
            /// All this stage asked of me was to
            /// use the java.util.Random class.
            /// The previous version of this
            /// snippet is found below, commented
            /// out. Even though that part of the
            /// code worked just as fine, I still
            /// decided to change it to include
            /// the random class.
            java.util.Random random = new java.util.Random();
            for (int i = 1; i <= number; i++) {
                int rng = random.nextInt(9);
                if (rng == 0 && secretCode == 0) {
                    i--;
                    continue;
                }
                if (zeroThroughNine[rng] == 0) {
                    secretCode = secretCode * 10 + rng;
                    zeroThroughNine[rng] = 1;
                } else {
                    i--;
                }
            }
            /// --- End of the fifth version ---
            /*
            for (int i = 1; i <= number; i++) {
                int nano = (int)System.nanoTime() % 1000 / 100;
                if (nano < 0)
                    nano *= -1;
                if (nano == 0 && secretCode == 0) {
                    i--;
                    continue;
                }
                if (zeroThroughNine[nano] == 0) {
                    secretCode = secretCode * 10 + nano;
                    zeroThroughNine[nano] = 1;
                } else {
                    i--;
                }
            }
            */
        } else {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            if (number > 36) {
                System.out.println("Error: can't generate a secret number with a " +
                        "length of 36 because there aren't enough unique digits and letters.");
                return " ";
            } else if (number < 1) {
                System.out.println("Error: can't generate a secret number with fewer than 1 digits" +
                        "or letters.");
                return " ";
            }
            System.out.println("Input the number of possible symbols in the code:");
            int possibleSym = scanner.nextInt();
            if (number > possibleSym) {
                System.out.println("Error: it's not possible to generate a code with a length of"
                        + number + " with " + possibleSym + " unique symbols.");
                return " ";
            } else if (possibleSym > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36" +
                        " (0-9, a-z).");
                return " ";
            }
            System.out.print("The secret is prepared: ");
            for (int i = 0; i < number; i++)
                System.out.print("*");
            if (possibleSym <= 10)
                System.out.println(" (0-" + (possibleSym - 1) + ").");
            else if (possibleSym == 11)
                System.out.println(" (0-9, a)");
            else
                System.out.println(" (0-9, a-" + (char)('a' + possibleSym - 11) + ").");
            int[] zeroToLast = new int[number + 1];
            for (int i = 0; i <= number; i++)
                zeroToLast[i] = 0;
            String secretCodeLetters = "";
            java.util.Random random = new java.util.Random();
            for (int i = 1; i <= number; i++) {
                int rng = random.nextInt(number);
                if (rng == 0 && secretCode == 0) {
                    i--;
                    continue;
                }
                if (zeroToLast[rng] == 0) {
                    if(rng < 10)
                        secretCodeLetters += String.valueOf(rng);
                    else
                        secretCodeLetters += String.valueOf((char)('a' + rng - 10));
                    zeroToLast[rng] = 1;
                } else {
                    i--;
                }
            }
            return secretCodeLetters;
        }
        return String.valueOf(secretCode);
    }
    private static int gameLoop(String code, String input) {
        int cows = 0, bulls = 0;
        for (int i = 0; i < code.length(); i++)
            if (code.charAt(i) == input.charAt(i))
                bulls++;
            else if (code.contains(String.valueOf(input.charAt(i))))
                cows++;
        System.out.print("Grade: ");
        if (bulls > 0 && cows > 0)
            System.out.println(bulls + " bull(s) and " + cows + " cow(s).");
        else if (bulls > 0)
            System.out.println(bulls + " bull(s).");
        else if (cows > 0)
            System.out.println(cows + " cow(s).");
        else
            System.out.println("None.");
        return bulls;
    }
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Select the stage you want to see the functionality for:");
        int stage = scanner.nextInt();
        switch (stage) {
            case 1 -> stageOne();
            case 2 -> stageTwo();
            case 3 -> stageThree();
            case 4 -> stageFour();
            case 5 -> System.out.println("This stage is only a refactoring of the code," +
                    "while the functionality of it remains the same as the last stage's. Try" +
                    " stage 4 or look through the code to see the difference.");
            case 6 -> stageSix();
            case 7 -> stageSeven();
            default -> System.out.println("Invalid stage...");
        }
    }
}