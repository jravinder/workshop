package demoapp

class Attendee {

    static constraints = {
    }                

	String firstName
	String lastName
	
	static hasMany = [ workshops: Workshop ]  
	
	String toString(){
		firstName + " " + lastName
	}
}
