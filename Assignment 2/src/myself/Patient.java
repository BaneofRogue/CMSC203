/*
 * Class: CMSC203
 * Instructor: Ashique Tanveer
 * Description: 
 * Due Date: 3/07/25
 * Platform/compiler: Eclipse IDE for Java Developers - 2024-12
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   
* any source. I have not given my code to any student.
 * Print your Name here: William Keller
*/

package myself;

public class Patient {
	private String firstName, 
	middleName, 
	lastName,
	streetAddress, 
	city,
	state,
	zipCode,
	phoneNumber,
	emergencyContactName,
	emergencyContactPhone;
	
	public Patient(){
		//no arg construct
	}

	//name constructor
	public Patient(String first_name, String middle_name, String last_name) {
		firstName = first_name;
		middleName = middle_name;
		lastName = last_name;
	}
	
	//full details constructor
	public Patient(String first_name, String middle_name, String last_name, String street_address, String city_name, String state_name, String zip_code, String phone_number, String emergency_contact_name, String emergency_contact_phone) {
		firstName = first_name;
		middleName = middle_name;
		lastName = last_name;
		streetAddress = street_address;
		city = city_name;
		state = state_name;
		zipCode = zip_code;
		phoneNumber = phone_number;
		emergencyContactName = emergency_contact_name;
		emergencyContactPhone = emergency_contact_phone;
	}
	
	//mutators;
	//first name
	public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String first_name) {
        firstName = first_name;
    }
    
    //middle name
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middle_name) {
        middleName = middle_name;
    }
    
    //last name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String last_name) {
        lastName = last_name;
    }
    
    //address
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String street_address) {
        streetAddress = street_address;
    }
    
    //city
    public String getCity() {
        return city;
    }
    public void setCity(String city_name) {
        city = city;
    }
    
    //state
    public String getState() {
        return state;
    }
    public void setState(String state_name) {
        state = state_name;
    }
    
    //zip
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zip_code) {
        zipCode = zip_code;
    }
    
    //phone
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phone_number) {
        phoneNumber = phone_number;
    }
    
    //emergence contact name
    public String getEmergencyContactName() {
        return emergencyContactName;
    }
    public void setEmergencyContactName(String emergency_contact_name) {
        emergencyContactName = emergency_contact_name;
    }
    
    //emergence phone number
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }
    public void setEmergencyContactPhone(String emergency_contact_phone) {
        emergencyContactPhone = emergency_contact_phone;
    }
    
    //concat first, middle, last name separated by space: method "buildFullName".
    
    public String buildFullName() {
    	return firstName + " " + middleName + " " + lastName;
    }
    
    // concat street address, city, state, zipcode separated by space;
    public String buildAddress() {
    	return streetAddress + " " + city + " " + state + " " + zipCode;
    }
    
    // emergency contact string builder, just like the previous two.
    public String buildEmergencyContact() {
		return emergencyContactName + " " + emergencyContactPhone;
	}
    
    // formatted data of patient
    public String toString() {
		return "Patient Information:\n" +
			   "    Name: " + buildFullName() + "\n" +
			   "    Address: " + buildAddress() + "\n" +
			   "    Phone: " + phoneNumber + "\n" +
			   "    EmergencyContact: " + buildEmergencyContact();
	}
    
}
