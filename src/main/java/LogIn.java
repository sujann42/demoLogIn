    import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
    import database.DatabaseUser;

    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.SQLException;

    @WebServlet("/add")
    public class LogIn extends HttpServlet {

    @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String uname= request.getParameter("username").toString().trim();
            String pass= request.getParameter("pass").toString().trim();

            PrintWriter printWriter= response.getWriter();

            DatabaseUser databaseUser= new DatabaseUser();

        try {
            if (databaseUser.check(uname,pass)){
                printWriter.println("asdasddasda");

                HttpSession session= request.getSession();
                session.setAttribute("username", uname);
                response.sendRedirect("welcome.jsp");

    //            RequestDispatcher dispatcher= request.getRequestDispatcher("uname");
    //            dispatcher.forward(request, response);

            }else{
                System.out.println("Here");
                printWriter.println("hey whats up");
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    }
