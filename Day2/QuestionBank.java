import java.util.ArrayList;
import java.util.List;

class QuestionBank implements QuestionInterface {
    public final List<Question> questions = new ArrayList<>();


    @Override
    public void create(Question question) {
        if(question == null)
        {
            throw new InvalidQuestionBankException("Question cannot be null");
        }

        for(Question q : questions)
        {
            if (q.getId() == question.getId())
            {
                throw new InvalidQuestionBankException(
                        "Question with id"+question.getId()+"already exist"
                );
            }
        }
         questions.add(question);

    }

    public Question read(int id) {
        for (Question q : questions) {
            if (q.getId() == id) {
                return q;
            }
        }
        return null; // not found
    }



    public void update(Question updated) {
         for(int i=0;i<questions.size(); i++)
         {
             if(questions.get(i).getId() == updated.getId())
             {
                 questions.set(i,updated);
                 return;
             }
         }
         throw new InvalidQuestionBankException("Question not found"+updated.getId());

    }

    public void delete(int id)
    {
        for (int i=0;i<questions.size();i++)
        {
            if(questions.get(i).getId()==id)
            {
                questions.remove(i);
                System.out.println("Question deleted"+id);
                return;
            }
        }
        System.out.println("Question Not found"+id);

    }



    public List<Question> displayAll()
    {
        return new ArrayList<>(questions);
    }



}
