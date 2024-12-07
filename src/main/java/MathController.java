import jakarta.servlet.http.HttpServletRequest;

public class MathController {
    private MathModel model;

    public MathController() {
        this.model = new MathModel();
    }

    public void processRequest(HttpServletRequest request) {
        int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
        int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));

        model.setFirstNumber(firstNumber);
        model.setSecondNumber(secondNumber);
        model.add();
    }

    public MathModel getModel() {
        return model;
    }
}