package localhost.milestonenet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class users implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String age;
    private Map<String, Boolean> substances;
    private String password;
    public users() {
        this.substances = new HashMap<>();
        initalizeSubstances();
    }

    public users(String id, String firstName, String lastName, String email, String gender, String age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =  email;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.substances = new HashMap<>();
        initalizeSubstances();
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFirstName() {return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public void initalizeSubstances() {
        substances.put("Methamphetamine",false);
        substances.put("Ketamine",false);
        substances.put("Marijuana",false);
        substances.put("Cocaine",false);
        substances.put("Heroin",false);
        substances.put("Alcohol",false);
        substances.put("Psilocybin",false);
        substances.put("LSD",false);
    }
    public boolean getSubstancesStatus(String substance) {
        if (!substances.containsKey(substance)) {
            throw new IllegalArgumentException("Substance not recognized " + substance);
        }
        return substances.get(substance);
    }
    public void setSubstancesStatus(String substance, boolean status) {
        if (!substances.containsKey(substance)) {
            throw new IllegalArgumentException("Substance not recognized " + substance);
        }
        substances.put(substance, status);
    }
    public Map<String, Boolean> getAllSubstanceStatus() {
        return new HashMap<>(substances);
    }
}

