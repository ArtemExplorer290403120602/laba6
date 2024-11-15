import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class TodoController {
    private List<TodoItem> todos;
    private static final String SENT_TODOS_FILE = "sent_todos.txt";

    public TodoController() {
        this.todos = new ArrayList<>();
    }

    public List<TodoItem> getTodos() {
        return todos;
    }

    public void addTodo(String description) {
        TodoItem newTodo = new TodoItem(description);
        todos.add(newTodo);
    }

    public String getRandomTodo() {
        if (todos.isEmpty()) return "Нет дел в списке";
        Random random = new Random();
        return todos.get(random.nextInt(todos.size())).getDescription();
    }

    public void loadSentTodos() {
        try {
            if (Files.exists(Paths.get(SENT_TODOS_FILE))) {
                try (BufferedReader reader = new BufferedReader(new FileReader(SENT_TODOS_FILE))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sentTodos.add(line.trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSentTodo(String todo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SENT_TODOS_FILE, true))) {
            writer.write(todo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // хранение уже отправленных дел
    private Set<String> sentTodos = new HashSet<>();

    public String getUniqueRandomTodo() {
        List<TodoItem> availableTodos = todos.stream()
                .filter(todo -> !sentTodos.contains(todo.getDescription()))
                .collect(Collectors.toList());

        if (availableTodos.isEmpty()) return "Нет доступных дел";

        String randomTodo = availableTodos.get(new Random().nextInt(availableTodos.size())).getDescription();
        sentTodos.add(randomTodo);
        saveSentTodo(randomTodo);
        return randomTodo;
    }

    public void addRandomTodo() {
        // Пример случайных задач
        String[] possibleTodos = {"Сделать спортзал", "Выгулять собаку", "Переделать проект", "Сделать домашку", "Пойти за продуктами"};
        Random random = new Random();
        String randomTodo = possibleTodos[random.nextInt(possibleTodos.length)];
        addTodo(randomTodo);
    }
}
