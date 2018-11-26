package com.baizhi.aop;

import com.baizhi.dao.LogDao;
import com.baizhi.entity.Log;
import com.baizhi.util.CreateID;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

public class LogerAround implements MethodInterceptor {
    @Autowired
    private LogDao logDao;
    //实现invoke
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        /*
            日志内容
            1.什么人
            2.在什么时间
            3.干了什么事
            4.是否成功
         */
        Log log = new Log();
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = sra.getRequest().getSession();
        //什么人
        String username = (String) session.getAttribute("username");
        //时间
        Date date = new Date();
        //什么事
        Method method = methodInvocation.getMethod();
        //通过反射 拿到类对象
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String value = annotation.value();
        //是否成功
        Boolean flag = false;

        Object proceed = null;

        try {
            proceed = methodInvocation.proceed();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.setResult(flag);
        log.setId(CreateID.getId());
        log.setName(username);
        log.setOptionTime(date);
        log.setMatter(value);
        //将日志内容存入数据库
        logDao.insert(log);
        System.out.println("管理员:"+username+" 操作时间:"+date+" 操作内容:"+method+" 结果:"+flag);
        return proceed;
    }
}
