import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MathServlet3")
public class MathServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MathController1 controller = new MathController1();
        controller.processRequest(request);
        MathModel1 model = controller.getModel();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (model.getFirstNumber() != 0 || model.getSecondNumber() != 0) {
            MathView1 view = new MathView1(model);
            view.displayResult(out);
        } else {

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Отображение формы для ввода чисел
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form method='GET' action='MathServlet3'>");
        out.println("Число 1: <input type='text' name='number1'><br>");
        out.println("Число 2: <input type='text' name='number2'><br>");
        out.println("<input type='submit' value='Сложить'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}