package lottery.beans;


import lottery.ejb.TestEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;

/**
 * Created by Remco on 14-11-2015.
 */
@ManagedBean(name = "playerBean")
@RequestScoped
public class PlayerBean {


    @EJB
    private TestEJB test;


    @NotNull
    private String firstName, lastName, email;
    private boolean signupConfirmed;

    public PlayerBean(){
        signupConfirmed = false;
    }

    public void signup(){
        //TODO: save player, generate ticket number, display ticket number
        test.test();
        setSignupConfirmed(true);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSignupConfirmed() {
        return signupConfirmed;
    }

    public void setSignupConfirmed(boolean signupConfirmed) {
        this.signupConfirmed = signupConfirmed;
    }
}
