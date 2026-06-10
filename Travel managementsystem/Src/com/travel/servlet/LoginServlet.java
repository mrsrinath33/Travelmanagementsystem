package com.travel.servlet;
import com.travel.dao.UserDAO;
import com.travel.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String username = request.getParameter(&quot;username&quot;);
String password = request.getParameter(&quot;password&quot;);
UserDAO userDAO = new UserDAO();
User user = userDAO.loginUser(username, password);
if (user != null) {
// Create session
HttpSession session = request.getSession();
session.setAttribute(&quot;user&quot;, user);
session.setAttribute(&quot;role&quot;, user.getRole());

// Redirect based on role
if (user.getRole().equals(&quot;admin&quot;)) {
response.sendRedirect(&quot;admin_dashboard.jsp&quot;);
} else {
response.sendRedirect(&quot;dashboard.jsp&quot;);
}
} else {
request.setAttribute(&quot;message&quot;, &quot;Invalid username or password!&quot;);
request.getRequestDispatcher(&quot;login.jsp&quot;).forward(request, response);
}
}
}
