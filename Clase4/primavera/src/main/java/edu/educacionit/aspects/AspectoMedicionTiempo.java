package edu.educacionit.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Aspect
public class AspectoMedicionTiempo {

    @Around("@annotation(edu.educacionit.annotations.Medible)")
    public void encerrar(ProceedingJoinPoint joinPoint) throws Throwable {

        Supplier<Long> ts = () -> System.currentTimeMillis();

        try {
            long ms1 = ts.get();
            joinPoint.proceed();
            long ms2 = ts.get();
            long diff = ms2 - ms1;
            System.out.println("El tiempo de invocacion del metodo: ");
            System.out.println(joinPoint.getSignature().getName());
            System.out.println(diff + " milisegundos");

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
