package com.xt37.community.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PageAlert {
    public static void Alert(String msg, HttpServletResponse response) {
        OutputStreamWriter osw = null;
        try {
            response.setContentType(" charset=UTF-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            ServletOutputStream outs = response.getOutputStream();
            osw.write(msg);
            osw.flush();
            osw.close();
        } catch (IOException e) {
            System.out.println("alert方法异常"+e.getMessage());
            e.printStackTrace();
        }

    }
}
