package featuresameple.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Task.class)
public @interface UserAction {
	String name() default "N/A";
	String day() default "N/A";
}
