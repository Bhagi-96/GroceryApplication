package constants;

public class Constant {
public static final String CONFIGFILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config.property";
	public static final String TESTDATA = "D:\\New folder\\Grocery.xlsx";
	
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	public static final String INVALIDUSERNAMEANDVALIDPASSWORDERROR = "User is able to login with invalid username";
	public static final String VALIDUSERNAMEANDINVALIDPASSWORD = "User is able to login with invalid password"; 
	public static final String INVALIDCREDENTIALS = "User is able to login with invalid username"; 
	
	public static final String LOGGEDOUTERROR = "User is unable to logged out"; 
	
	public static final String ADDNEWUSERERROR = "User is unable to enter admin users page";
	public static final String SEARCHADMINUSERERROR = "User is unable to enter admin users page";
	public static final String RESETERROR = "User is unable to enter admin users page";
	
	public static final String ADDNEWNEWSERROR = "User is unable to enter manage news page";
	public static final String SEARCHNEWSERROR = "User is unable to enter manage news page";
	public static final String MANAGENEWSPAGERESETERROR = 	"User is unable to enter manage news page";
	
}
