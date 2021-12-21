package edu.educacionit.aspects;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Aspect
public class ApectoLogging {

    @Before("@annotation(edu.educacionit.annotations.Loggeable)")
    public void antesDeEjecutar(JoinPoint joinPoint) throws IOException {
        System.out.println("**********************************");
        System.out.println("Justo antes de invocar al metodo");
        System.out.println(joinPoint.getSignature().getName());


        StringBuilder strParams = new StringBuilder();

        for(Object o : joinPoint.getArgs()) {
            String strJson =  new Gson().toJson(o);
            strParams
                    .append(strJson)
                    .append(System.lineSeparator());
        }

        FileUtils.writeStringToFile(
                new File("/tickets/unico.txt"),
                strParams.toString(),
                "UTF-8",
                true
        );

        System.out.println("**********************************");

    }
}
