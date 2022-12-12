package com.etiya.ecommercedemo3;

import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.result.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestControllerAdvice
@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = {"com.etiya.ecommercedemo3.repository.abstracts"})
public class EcommerceDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemo3Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception)
	{

		//TODA:ErrorDataResult olarak hataları döndür.
		Map<String,String> errors=new HashMap<>();
		//ErrorDataResult<String> hata=new ErrorDataResult<String>();

		for(FieldError fieldError : exception.getBindingResult().getFieldErrors())
		{
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());

		}
		return new ErrorDataResult<>(errors,"Not valid exception") ;
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)

	public  ErrorDataResult<Object> handleBusinessException(BusinessException businessException)
	{
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(), "BUSINESS.EXCEPTION");
		return errorDataResult;

	}
}
