import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
* Autor:Joel Caza
* Materia:Lenguajes de Programacion 2
* Fecha:22/05/2024
* Version:0.0.1
* Descripcion:Get con Header
* */

// Anotación para indicar la URL a la que responde el servlet
@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    // Método para manejar las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener el flujo de salida para escribir la respuesta
        PrintWriter out = resp.getWriter();

        // Obtener el método de la solicitud (GET en este caso)
        String metodo = req.getMethod();

        // Escribir la estructura básica de la página HTML
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");

        // Escribir el título del servlet y el método utilizado
        out.println("<h1>Servlet Get</h1>");
        out.println("<h1>El método que se utiliza es: " + metodo + "</h1>");

        // Obtener la URI de la solicitud y escribirla en la página
        String uri = req.getRequestURI();
        out.println("<br><h1>" + uri + "</h1>");

        // Obtener los cabeceros de la solicitud y escribirlos en la página
        Enumeration cabeceros = req.getHeaderNames();
        while (cabeceros.hasMoreElements()) {
            String name = (String) cabeceros.nextElement();
            out.println("<b>" + name + "</b>"); // Nombre del cabecero
            out.println(req.getHeader(name)); // Valor del cabecero
            out.println("<br>");
        }

        // Cerrar la estructura de la página HTML
        out.println("</body>");
        out.println("</html>");

        // Cerrar el flujo de salida
        out.close();
    }
}
