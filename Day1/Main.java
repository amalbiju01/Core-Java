import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        QuestionBank qb=null;
        while(qb==null)
        {
            try{
                System.out.println("Enter the question bank size from 1 to 5");
                int capacity=sc.nextInt();
                sc.nextLine();
                qb=new QuestionBank(capacity);

            }
            catch (InvalidQuestionBankException e)
            {
                System.out.println("Error"+e.getMessage());
            }
        }
        int choice;
        do{
            System.out.println("\n-*-*-*-Question Bank Menu-*-*-*-");
            System.out.println("1. Add Question");
            System.out.println("2. Read Question by Id");
            System.out.println("3. Update Question");
            System.out.println("4. Delete Question");
            System.out.println("5. Show All Questions");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
                {
                    case 1:
                        System.out.println("Enter Question ID");
                        int id=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Question");
                        String text=sc.nextLine();
                        sc.nextLine();
                        System.out.print("Enter Answer: ");
                        String answer = sc.nextLine();
                        qb.create(new Question(id,text,answer));
                        break;

                    case 2:
                        System.out.println("Enter Question ID to read");
                        int readId=sc.nextInt();
                        sc.nextLine();
                        Question q=qb.read(readId);
                        if(q!=null)
                            {
                            System.out.println("Found"+q);
                            }
                        break;

                    case 3:
                        System.out.println("Enter Question ID to update");
                        int updateId=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Question");
                        String newText=sc.nextLine();
                        System.out.print("Enter new Answer: ");
                        String newAnswer = sc.nextLine();
                        qb.update(updateId,newText,newAnswer);
                        break;

                    case 4:
                        System.out.println("Enter Question ID to delete");
                        int deleteId=sc.nextInt();
                        qb.delete(deleteId);
                        break;

                    case 5:
                        qb.listAll();
                        break;

                    case 6:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");

                }



        }
        while (choice != 6);
            sc.close();


    }
}