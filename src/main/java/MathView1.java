import java.io.PrintWriter;

public class MathView1 {
    private MathModel1 model;

    public MathView1(MathModel1 model) {
        this.model = model;
    }

    public void displayResult(PrintWriter out) {
        out.println("<html><body>");
        out.println("<h1>Результат сложения</h1>");
        out.println("<p>" + model.getFirstNumber() + " + " + model.getSecondNumber() + " = " + model.getResult() + "</p>");
        out.println("<a href='index.jsp'>Вернуться на главную</a>");
        out.println("</body></html>");
    }
}