package Saucedemo;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameter {
	
String Url="https://www.saucedemo.com/inventory.html" ;
static WebDriver driver= new ChromeDriver();
static Random rand=new Random();

static String [] UserName = {"standard_user" ,"locked_out_user" , "problem_user", "performance_glitch_user" ,"error_user","visual_user"};
int indexUname=rand.nextInt(UserName.length);
String theUsername=UserName[indexUname];


static String Password="secret_sauce";
static String postal="999";
static String fname="Hala";
static String lname="Ahmad";
}





