import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// Заменяем определение сервлета с использованием аннотации WebServlet
@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
    private TodoController controller;

    public void init() throws ServletException {
        controller = new TodoController();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        controller.loadSentTodos();
        controller.addRandomTodo();// Загружаем уже отправленные дела
        String randomTodo = controller.getUniqueRandomTodo();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Todo List</h1>");

        TodoView view = new TodoView(controller);
        String rez = view.displayTodos2();
        out.println("<br>" + rez);

        out.println("<br>Случайное дело: <input type='text' value='" + randomTodo + "' readonly>");

        out.println("<form action='TodoServlet' method='post'>");
        out.println("Новые Todo (через запятую): <input type='text' name='newTodo'>");
        out.println("<input type='submit' value='Добавить'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newTodos = request.getParameter("newTodo");
        String[] todosArray = newTodos.split(","); // Разделяем входные данные по запятой
        for (String todo : todosArray) {
            controller.addTodo(todo.trim()); // Добавляем каждую задачу по отдельности
        }
        response.sendRedirect("TodoServlet");
    }
}