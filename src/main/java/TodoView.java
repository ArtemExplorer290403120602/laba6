import java.util.List;

public class TodoView {
    private TodoController controller;

    public TodoView(TodoController controller) {
        this.controller = controller;
    }

    public String displayTodos2() {
        List<TodoItem> todos = controller.getTodos();
        StringBuilder sb = new StringBuilder();

        for (TodoItem todo : todos) {
            sb.append(todo.getDescription() + " - " + (todo.isCompleted() ? "Completed" : "Incomplete") + "<br>");
        }
        return sb.toString();
    }
}
