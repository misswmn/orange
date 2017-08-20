package com.orange.syntax;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class CarValidator {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Car car = new Car(null, "", 1);
        Person driver = new Person();
        driver.setAge(2);
        driver.setName("");
        car.setDriver(driver);

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        for (ConstraintViolation<Car> constraint : constraintViolations) {
            System.err.println(constraint.getMessage());
            System.out.println(constraint.getPropertyPath());
        }
    }
}
