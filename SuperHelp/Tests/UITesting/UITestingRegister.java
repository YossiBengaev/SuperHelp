package UITesting;

import Controller.RegisterController;
import DB.ClientRepository;
import DB.Utilities;
import Utilites.SingletonTestResult;
import Utilites.TestBase;
import View.Login;
import View.Register;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.sql.Connection;
import java.sql.SQLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UITestingRegister extends TestBase {
    private Register _theView = new Register();
    private ClientRepository _theModel;
    {
        try {
            _theModel = new ClientRepository(_db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private RegisterController _theController = new RegisterController(_theView, _theModel);
    public static SingletonTestResult testResult = SingletonTestResult.getInstance();

    @Test
    public void test2_invalidRegister() {
        _theView.clickRegister();
        Assert.assertTrue(_theView.emailErrorValid());
        Assert.assertTrue(_theView.passwordErrorValid());
        Assert.assertTrue(_theView.firstNameErrorValid());
        Assert.assertTrue(_theView.lastNameErrorValid());
        Assert.assertTrue(_theView.addressErrorValid());
        Assert.assertTrue(_theView.phoneNumberErrorValid());
        Assert.assertTrue(_theView.getNameScreen().equals("Register"));
        testResult.setTestResult(true);
    }

    @Test
    public void test1_validRegister() {
        _theView.setEmailField("zohar@gmail.com");
        _theView.setPasswordField("Zz123456!");
        _theView.setFirstNameField("Zohar");
        _theView.setLastNameField("Hajaj");
        _theView.setAddressField("Akko");
        _theView.setPhoneNumber("0502223311");
        Login loginScreen = _theView.clickRegister();
        testResult.setTestResult(true);
    }
}
