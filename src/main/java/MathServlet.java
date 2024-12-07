import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MathServlet2")
public class MathServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Математическое задание</h1>");
        out.println("<form action='MathServlet2' method='post'>");
        out.println("Введите первое число: <input type='text' name='firstNumber'><br>");
        out.println("Введите второе число: <input type='text' name='secondNumber'><br>");
        out.println("<input type='submit' value='Сложить'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MathController controller = new MathController();
        controller.processRequest(request);

        MathView view = new MathView(controller.getModel());

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        view.displayResult(out);
    }
}