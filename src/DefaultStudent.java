
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DefaultStudent {
    int indeks() default 1;
    String imie() default "Wojtek";
    int ocena() default 3;
//    String comment();
}
