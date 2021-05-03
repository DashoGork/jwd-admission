package com.jwd_admission.byokrut.commandController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "home", value = "/home")
public class MainServlet extends HttpServlet {
    static final String COMMAND = "command";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String commandName = request.getParameter(COMMAND);
        Command command = Command.of(commandName);
        final CommandResponse execute = command.execute(new CommandRequest() {
            @Override
            public Object getAttribute(String name) {
                return request.getAttribute(name);
            }

            @Override
            public void setAttribute(String name,Object object) {
                 request.setAttribute(name,object);
            }

            @Override
            public Object getRequestParameter(String name) {
                return request.getParameter(name);
            }

            @Override
            public HttpSession createSession() {
                return request.getSession();
            }

            @Override
            public CommandResponse execute(CommandRequest request) {
                return null;
            }
        });

        if (execute.isRedirect()) {
            response.sendRedirect(execute.getDestination().getPath());
        } else {
            request.getRequestDispatcher(execute.getDestination().getPath()).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String commandName = req.getParameter(COMMAND);
        Command command = Command.of(commandName);
        final CommandResponse execute = command.execute(new CommandRequest() {
            @Override
            public void setAttribute(String name, Object object) {
                req.setAttribute(name,object);
            }

            @Override
            public Object getAttribute(String name) {
                return req.getAttribute(name);
            }

            @Override
            public Object getRequestParameter(String name) {
                return req.getParameter(name);
            }

            @Override
            public HttpSession createSession() {
                return req.getSession();
            }

            @Override
            public CommandResponse execute(CommandRequest request) {
                return null;
            }
        });


        if (execute.isRedirect()) {
            resp.sendRedirect(execute.getDestination().getPath());
        } else {
            req.getRequestDispatcher(execute.getDestination().getPath()).forward(req, resp);
        }
    }
}
