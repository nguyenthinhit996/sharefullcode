/**
 * 
 */
package featuresameple.annotations;

/**
 * @author Peter
 *
 */
public @interface authorclass {
	String author();

	String date();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	// Note use of array
	String[] reviewers();
}
