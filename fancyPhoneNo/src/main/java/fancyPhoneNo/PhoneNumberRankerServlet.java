package fancyPhoneNo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PhoneNumberRankerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumbersInput = request.getParameter("phoneNumbers");
        String[] phoneNumbersArray = phoneNumbersInput.split("\n");
        List<String> phoneNumbers = Arrays.asList(phoneNumbersArray);
        
        List<String> rankedPhoneNumbers = PhoneNumberRanker.rankPhoneNumber(phoneNumbers);
        
        request.setAttribute("rankedPhoneNumbers", rankedPhoneNumbers);
        
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
