package com.jwd_admission.byokrut.commandController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstCommand", value = "/FirstCommand")
public class FirstCommand extends HttpServlet {
    final static String COMMAND="command";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        final String commandName=req.getParameter(COMMAND);
        System.out.println(commandName);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "DDDDD" + "</h1>");
        out.println("</body></html>");
        if(commandName.equals("login")){
            System.out.println("fff");
        }
        Command command = Command.of(commandName);
        final CommandResponsr execute =command.execute(new CommandRequest() {
            @Override
            public Object getAttribute(String name){
                return req.getAttribute(name);
            }

            @Override
            public Object getRequestParameter(String name){
                return req.getParameter(name);
            }

            @Override
            public HttpSession createSession() {
                return req.getSession();
            }

            @Override
            public CommandResponsr execute(CommandRequest request) {
                return null;
           }
        });


            if (execute.isRedirect()) {
                System.out.println(execute.getDestination().getPath() +" red");
                resp.sendRedirect(execute.getDestination().getPath());
            }else {
                System.out.println(execute.getDestination().getPath() +" forwar");
                req.getRequestDispatcher(execute.getDestination().getPath()).forward(req,resp);
            }
    }
}
