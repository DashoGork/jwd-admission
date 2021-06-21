package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;

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
        String commandName = request.getParameter(COMMAND);
        if (commandName.indexOf("?") > 0) {
            commandName = commandName.substring(0, commandName.lastIndexOf("?"));
        }

        Command command = Command.of(commandName);
        final CommandResponse execute = command.execute(new CommandRequest() {
            @Override
            public String getParameter(String parameter) {
                return request.getParameter(parameter);
            }

            @Override
            public void setAttribute(String name, Object object) {
                request.setAttribute(name, object);
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
            command.execute((CommandRequest) new ShowPersonalAccountCommand());
            response.sendRedirect(execute.getDestination().getPath());
        } else {
            request.getRequestDispatcher(execute.getDestination().getPath()).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(COMMAND);
        if (commandName.indexOf("?") > 0) {
            commandName = commandName.substring(0, commandName.lastIndexOf("?"));
        }
        Command command = Command.of(commandName);
        final CommandResponse execute = command.execute(new CommandRequest() {
            @Override
            public String getParameter(String parameter) {
                return req.getParameter(parameter);
            }

            @Override
            public void setAttribute(String name, Object object) {
                req.setAttribute(name, object);
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
            resp.sendRedirect(commandName);
        } else {
            req.getRequestDispatcher(execute.getDestination().getPath()).forward(req, resp);
        }
    }
}
