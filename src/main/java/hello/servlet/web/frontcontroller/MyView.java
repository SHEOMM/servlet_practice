package hello.servlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {
    private final String viewPath; // 논리 이름

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
    public String getViewPath() {
        return viewPath;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        model.forEach(request::setAttribute);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
