package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.dao.impl.FacultyDaoImpl;
import com.jwd_admission.byokrut.entity.Faculty;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class ShowMainPageCommand implements Command {
    private FacultyDaoImpl facultyDao = new FacultyDaoImpl();

    @Override
    public CommandResponse execute(CommandRequest request) {
        List<Faculty> faculties = facultyDao.findAll();


        final HttpSession session = request.createSession();
        session.setAttribute("allFaculties", faculties);
        List<User> userList = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passed.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            userList.addAll((List<User>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            //logger!
        }

        if (!userList.isEmpty()) {
            session.setAttribute("listOfPassed", userList);
        }
        return () -> MAIN_PAGE;
    }


}
