package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

//    String username = request.getParameter("username"); //단일 파라미터 조회
//    Enumeration<String> parameterNames = request.getParameterNames(); //파라미터 이름들
//    모두 조회
//    Map<String, String[]> parameterMap = request.getParameterMap(); //파라미터를 Map으로
//    조회
//    String[] usernames = request.getParameterValues("username"); //복수 파라미터 조회
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

//        Enumeration<String> parameterNames = req.getParameterNames();
//        while(parameterNames.hasMoreElements()) {
//            String parameterName = parameterNames.nextElement();
//            System.out.println(parameterName + " = " + req.getParameter(parameterName));
//        }

        req.getParameterNames().asIterator().
                forEachRemaining(paramName ->
                        System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        System.out.println("req.getParameter(username) = " + username);

        String age = req.getParameter("age");
        System.out.println("req.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("req.getParameterValues(username)");
        String[] usernames = req.getParameterValues("username");
        for(String name : usernames) {
            System.out.println("username = " + name);
        }

        resp.getWriter().write("ok");

    }
}
