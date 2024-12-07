import jakarta.servlet.http.HttpServletRequest;

public class MathController1 {
    private MathModel1 model;

    public MathController1() {
        this.model = new MathModel1();
    }

    public void processRequest(HttpServletRequest request) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");

        if (number1 != null && number2 != null) {
            model.setFirstNumber(Integer.parseInt(number1));
            model.setSecondNumber(Integer.parseInt(number2));
            model.add();
        }
    }

    public MathModel1 getModel() {
        return model;
    }
}