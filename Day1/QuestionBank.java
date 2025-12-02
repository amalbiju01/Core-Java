class QuestionBank implements QuestionInterface {
    private Question[] questions;
    public int size=0;
     public QuestionBank( int capacity) throws InvalidQuestionBankException {
         if(capacity<=0 || capacity>5){
             throw new InvalidQuestionBankException("Question Bank capacity must be between 1 and 5. Given"+capacity);
         }
         questions = new Question[capacity];
     }

    @Override
    public void create(Question question) {

        for (int i = 0; i < size; i++) {
            if (questions[i].getId() == question.getId()) {
                System.out.println("A question with ID " + question.getId() + " already exists!");
                return;
            }
        }
         if (size == questions.length)
         {
             System.out.println("Question Bank is full");
             return;
         }
         else {
             questions[size++] = question;
             System.out.println("Question Added Successfully"+question);
         }

    }

    public Question read(int id)
    {
        for (int i = 0; i < size; i++) {
            if (questions[i].getId() == id)
            {
                return questions[i];
            }
        }
        System.out.println("Question Not found"+id);
        return null;
    }
    public void update(int id, String newtext, String newanswer) {
         Question q=read(id);
         if(q!=null){
             q.setText(newtext);
             q.setAnswer(newanswer);
             System.out.println("Question Updated Successfully"+q);
         }

    }

    public void delete(int id)
    {
        int index=-1;
        for (int i = 0; i < size; i++) {
            if (questions[i].getId() == id)
            {
                index=  i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Question Not found"+id);
            return;
        }
    }

    @Override
    public void listAll() {
         if (size == 0)
         {
             System.out.println("Question Bank is empty");
         }
        for (int i = 0; i < size; i++) {
            System.out.println(questions[i]);
        }
    }
}
