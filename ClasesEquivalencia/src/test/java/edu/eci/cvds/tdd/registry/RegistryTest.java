package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;


public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validateDeadPerson() {

        Person person = new Person("Juanchito", 10029439, 18, Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    
    @Test
    public void validateUnderagePerson() {

        Person person = new Person("Juancho", 37223325, 16, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test
    public void validateInvalidAge() {

        Person person = new Person("Miguel", 398024743, -16, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void validateDuplicated() {

        Person person = new Person("Miguel", 487430349, 25, Gender.MALE, true);
        Person person1 = new Person("Miguel", 487430349, 25, Gender.MALE, true);

        registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person1);

        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
    

    // TODO Complete with more test cases
}