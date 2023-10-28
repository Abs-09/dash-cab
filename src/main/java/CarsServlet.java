import com.mycompany.dash.cab.dao.CarDao;
import com.mycompany.dash.cab.model.Car;
import com.mycompany.dash.cab.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        CarDao dao = new CarDao();
        List<Car> cars = dao.getCar(); // Fetch all cars

        // Set the car data as an attribute in the request
        request.setAttribute("cars", cars);

        // Determine which JSP page to forward the request to based on user type
        String jspPage = "cars/masterindex.jsp"; // Default for user type 1

        if (user.getType() == 3 || user.getType() == 2) {
            jspPage = "cars/myindex.jsp"; // For user type 3 or 2
        }

        // Forward the request to the appropriate JSP page
        RequestDispatcher rd = request.getRequestDispatcher(jspPage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests if needed
    }
}
