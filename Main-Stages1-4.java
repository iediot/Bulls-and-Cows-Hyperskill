package bullscows;

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
        String secretCode = generateSecretCode(number);
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
        String secretCode = generateSecretCode(number);
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
    private static String generateSecretCode(int number) {
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
        long secretCode = 0;
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
        stageFour();
    }
}
