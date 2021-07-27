package myjunit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyTRTest {

        /**
         * Default empty exception.
         */
        static class None extends Throwable {
            private static final long serialVersionUID = 1L;

            private None() {
            }
        }

        /**
         * Optionally specify <code>expected</code>, a Throwable, to cause a test method to succeed if
         * and only if an exception of the specified class is thrown by the method. If the Throwable's
         * message or one of its properties should be verified, the
         * {@link org.junit.rules.ExpectedException ExpectedException} rule can be used instead.
         */
        Class<? extends Throwable> expected() default org.junit.Test.None.class;

        /**
         * Optionally specify <code>timeout</code> in milliseconds to cause a test method to fail if it
         * takes longer than that number of milliseconds.
         * <p>
         * <b>THREAD SAFETY WARNING:</b> Test methods with a timeout parameter are run in a thread other than the
         * thread which runs the fixture's @Before and @After methods. This may yield different behavior for
         * code that is not thread safe when compared to the same test method without a timeout parameter.
         * <b>Consider using the {@link org.junit.rules.Timeout} rule instead</b>, which ensures a test method is run on the
         * same thread as the fixture's @Before and @After methods.
         * </p>
         */
        long timeout() default 0L;


}
