package Model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Volunteering {
    private int _volunteerId;
    private String _firstName;
    private String _lastName;
    private int _age;
    private String _gender;
    private String _phoneNumber;
    private String _address;
    private String _problem;
    private Timestamp _time;

    public Volunteering(String firstName, String lastName, int age, String gender, String address,
                        String phoneNumber, String problem) {
        _volunteerId = setVolunteerId();
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGender(gender);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setProblem(problem);
        _time = setTime();
    }

    // Cons for testing
    public Volunteering(int volunteerId, String firstName, int age, String gender, String lastName, String phoneNumber,
                        String address, String problem) {
        _volunteerId = volunteerId;
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setProblem(problem);
        _time = setTime();
    }

    public int setVolunteerId() {
        Random random = new Random();
        return random.nextInt(10000000);
    }

    public Timestamp setTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentTime  = calendar.getTime();
        long time = currentTime.getTime();
        return new Timestamp(time);
    }

    public int getVolunteerId() {
        return _volunteerId;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getProblem() {
        return _problem;
    }

    public void setProblem(String problem) {
        _problem = problem;
    }

    public Timestamp getTime() {
        return _time;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int _age) {
        this._age = _age;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String _gender) {
        this._gender = _gender;
    }

    @Override
    public String toString() {
        return  "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age='" + getAge() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", problem='" + getProblem();
    }
}