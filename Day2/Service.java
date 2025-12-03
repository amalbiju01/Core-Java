import java.util.List;
import java.util.Scanner;

public class Service {

    private final Scanner scan = new Scanner(System.in);
    private final QuestionBank questionBank = new QuestionBank();

    public void run() {
        int choice;

        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        read();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        displayAll();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Wrong choice");
                }
            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        } while (choice != 6);
    }

    // ---------- MENU ----------
    private void printMenu() {
        System.out.println("\n-*-*-*-Question Bank Menu-*-*-*-");
        System.out.println("1. Add Question");
        System.out.println("2. Read Question by Id");
        System.out.println("3. Update Question");
        System.out.println("4. Delete Question");
        System.out.println("5. Show All Questions");
        System.out.println("6. Exit");
    }


    private int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            String line = scan.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readLine(String msg) {
        System.out.print(msg);
        return scan.nextLine();
    }


    public void add() {
        System.out.println("Add a new Question");
        int id = readInt("Enter question number: ");
        String text = readLine("Enter question text: ");

        Question q = new Question(id, text);
        questionBank.create(q);

        System.out.println("Question added successfully");
    }

    public void read() {
        int id = readInt("Enter question number: ");
        Question q = questionBank.read(id);

        if (q == null) {
            System.out.println("No question found with number " + id);
        } else {
            System.out.println("Question found: " + q);
        }
    }

    public void update() {
        int id = readInt("Enter question number: ");

        Question old = questionBank.read(id);
        if (old == null) {
            System.out.println("No question found with number " + id);
            return;
        }

        System.out.println("Current: " + old);
        String newText = readLine("Enter new question text: ");
        Question q = new Question(id, newText);

        questionBank.update(q);
        System.out.println("Question updated successfully");
    }

    public void delete() {
        int id = readInt("Enter question number: ");
        questionBank.delete(id);
    }

    public void displayAll() {
        List<Question> list = questionBank.displayAll();

        if (list.isEmpty()) {
            System.out.println("No questions found");
        } else {
            System.out.println("Questions:");
            for (Question q : list) {
                System.out.println(q);
            }
        }
    }
}
