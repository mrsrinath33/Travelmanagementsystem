package com.travel.servlet;
import com.travel.dao.BookingDAO;
import com.travel.model.Booking;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
public class BookingServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
HttpSession session = request.getSession();
User user = (User) session.getAttribute(&quot;user&quot;);
if (user == null) {
response.sendRedirect(&quot;login.jsp&quot;);
return;
}
int packageId = Integer.parseInt(request.getParameter(&quot;packageId&quot;));
String travelDate = request.getParameter(&quot;travelDate&quot;);
int numPeople = Integer.parseInt(request.getParameter(&quot;numPeople&quot;));

BookingDAO bookingDAO = new BookingDAO();
Booking booking = new Booking();
booking.setUserId(user.getUserId());
booking.setPackageId(packageId);
booking.setTravelDate(travelDate);
booking.setNumPeople(numPeople);
boolean success = bookingDAO.createBooking(booking);
if (success) {
response.sendRedirect(&quot;booking_success.jsp&quot;);
} else {
request.setAttribute(&quot;message&quot;, &quot;Booking failed!&quot;);
request.getRequestDispatcher(&quot;booking.jsp&quot;).forward(request, response);
}
}
}
