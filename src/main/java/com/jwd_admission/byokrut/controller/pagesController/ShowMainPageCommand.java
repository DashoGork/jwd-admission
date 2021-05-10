package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.dao.impl.FacultyDaoImpl;
import com.jwd_admission.byokrut.entity.Faculty;

import java.util.List;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class ShowMainPageCommand implements Command {
    FacultyDaoImpl facultyDao = new FacultyDaoImpl();

    @Override
    public CommandResponse execute(CommandRequest request) {
        List<Faculty> faculties = facultyDao.findAll();
        request.setAttribute("allFaculties", faculties);
        return () -> MAIN_PAGE;
    }


}
