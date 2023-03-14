import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExerciseTwelve extends BaseTest {
	
	@ParameterizedTest
	@CsvSource({
		"admin,wrong",
		"wrong,superduper",
		","
	})
	public void LoggingInWithIncorrectCredentials(String username, String password) {
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		login.loginWith(username, password);
		Assert.assertFalse("The welcome message is displayed", welcome.isWelcomeMessageDisplayed());
	}

}
