package com.jwd_admission.byokrut.customTags;

import com.jwd_admission.byokrut.entity.Request;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class UserRequestApproved extends SimpleTagSupport {
    private ArrayList<Request> arrayList;
    private int userId;
    StringWriter sw = new StringWriter();

    public void setUserId(int userId) {
        userId = userId;
    }

    public void setArrayList(ArrayList<Request> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if(Request.findApprovementInArray(arrayList,userId)){
            getJspBody().invoke(sw);
            getJspContext().getOut().println(sw.toString());
        }
    }
}
