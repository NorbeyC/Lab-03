package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
	ArrayList<Integer> ids = new ArrayList<Integer>();
	
    public RegisterResult registerVoter(Person p) {
    	if(p.isAlive()==false) {
    		return RegisterResult.DEAD;
    	}
    	if(p.getAge()<18 && p.getAge()>0 && p.isAlive()==true) {
    		return RegisterResult.UNDERAGE;
    	}
    	if((p.getAge()>125 || p.getAge()<=0) && p.isAlive()==true) {
    		return RegisterResult.INVALID_AGE;
    	}
    	if(ids.contains(p.getId()) && p.isAlive()==true){
    		return RegisterResult.DUPLICATED;
    	}
    	else{
    		ids.add(p.getId());
    		return RegisterResult.VALID;
    	}
    	
        // TODO Validate person and return real result.
        
    }
}
