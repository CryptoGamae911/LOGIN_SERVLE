import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (UserDataBase.loginUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.getWriter().println("Login successful. Welcome " + username + "!");
        } else {
            response.getWriter().println("Invalid username or password.");
        }
    }
}
