package dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME) // Allows runtimes to have specialized behavior interoperating with Dagger.
@Target(METHOD)
@Documented
public @interface HelloWorld {
}
