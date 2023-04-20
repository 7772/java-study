package com.example.tobyhelloboot;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class TobyHelloBootApplication {

    public static void main(String[] args) {
        var factory = new TomcatServletWebServerFactory();
        WebServer server = factory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();

            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

                    if (request.getRequestURI().equals("/hello") && request.getMethod().equals(
                            HttpMethod.GET.name())) {
                        String name = request.getParameter("name");
                        String result = helloController.hello(name);

                        response.setStatus(HttpStatus.OK.value());
                        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        response.getWriter().println(result);
                    } else if (request.getRequestURI().equals("/user")) {
                        //
                    } else {
                        response.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });
        server.start();
    }

}
