package Refl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ReflTest reflTest = new ReflTest();
        reflTest.setInsuranceAmount(BigDecimal.valueOf(100.5499999d));
        reflTest.setInsurancePremium(BigDecimal.valueOf(20.9999999d));

        Field[] fields = reflTest.getClass().getDeclaredFields();

        //            System.out.println(field.isAnnotationPresent(Scale.class));
        for (Field field : fields)
            if (field.isAnnotationPresent(Scale.class)) {
                try {
                    try {
                        System.out.println(field.getName() + " = " +
                        reflTest.getClass().getMethod("get"+field.getName(),Integer.class).invoke(reflTest,field.getAnnotation(Scale.class).size()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }


    }
}
