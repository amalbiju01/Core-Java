public class Question {
    private int id;
    private String text;
    private String answer;

    public Question(int id, String text , String answer) {
        this.id=id;
        this.text=text;
        this.answer=answer;
    }

    public int getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }


    public void setText(String text)
    {
        this.text = text;
    }

    public String getAnswer()
    {
        return answer;
    }



    public void setAnswer(String answer) { this.answer = answer; }

    public String toString()
    {
        return "Question{id=" + id + ", text='" + text + "', answer='" + answer + "'}";
    }

}
