import java.util.List;

interface QuestionInterface {
    void create(Question question);
    Question read(int id);
    void update(Question question);
    void delete(int id);
    List<Question> displayAll();

}
