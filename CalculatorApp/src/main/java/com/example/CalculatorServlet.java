package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Read input parameters
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            String operation = request.getParameter("operation");
            double result = 0;

            // Perform calculation
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    if (num2 == 0) {
                        out.println("<h3 style='color:red;'>Error: Cannot divide by zero!</h3>");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    out.println("<h3 style='color:red;'>Invalid operation!</h3>");
                    return;
            }

            // Display result
            out.println("<h2>Result: " + result + "</h2>");
        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red;'>Error: Invalid input!</h3>");
        }
    }
}
