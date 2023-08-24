package co.com.ntt.api.validations.requestBody;


import co.com.ntt.model.exceptions.BindingException;
import co.com.ntt.model.response.GlobalResponse;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

@Log
@Component
@Aspect
public class BodyValidationAspect {

    @Around("@annotation(BodyValidations)")
    public Object handleValidations(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("ingresando al método ...");
        BindingResult bindingResult = this.getBindingResult(joinPoint);

        if(bindingResult.hasErrors()){
            return this.getBadRequest(bindingResult);
        }

        return joinPoint.proceed();
    }

    public BindingResult getBindingResult(ProceedingJoinPoint joinPoint) throws BindingException {
        try {
            return (BindingResult) Arrays.stream(joinPoint.getArgs())
                    .filter(BindingResult.class::isInstance )
                    .findFirst().orElseGet(() -> false);
        }catch (ClassCastException e){
            throw new BindingException();
        }



    }

    public ResponseEntity<GlobalResponse<Object>> getBadRequest (BindingResult result){


        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
                GlobalResponse.<Object>builder()
                        .msg(result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage))
                        .code(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }


}
