interface QuestionInterface {
    void create(Question question);
    Question read(int id);
    void update(int id, String text, String answer);
    void delete(int id);
    void listAll();

}
