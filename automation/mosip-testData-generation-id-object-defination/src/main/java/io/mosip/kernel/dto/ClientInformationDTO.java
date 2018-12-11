package io.mosip.kernel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This is the dto class for fething objects from yaml file.
 * 
 * @author Arjun chandramohan
 *
 */
@Getter
@Setter
public class ClientInformationDTO {
	private String[] valid_Male_Name;
	private String[] valid_Female_Name;
	private String[] invalid_Name;
	
	private String[] valid_gender;
	private String[] invalid_gender;
	
	private String[] valid_mobileNumber;
	private String[] invalid_mobileNumber;
	
	
	private String[] valid_addressLine1;
	private String[] invalid_addressLine1;
	
	private String[] valid_addressLine2;
	private String[] invalid_addressLine2;
	
	private String[] valid_addressLine3;
	private String[] invalid_addressLine3;
	
	private String[] valid_region;
	private String[] invalid_region;
	
	private String[] valid_city;
	private String[] invalid_city;
	
	private String[] valid_province;
	private String[] invalid_province;
	
	
	private String[] valid_CNEOrPINNumber;
	private String[] invalid_CNEOrPINNumber;
	
	
	private String[] valid_parentOrGuardianRIDOrUIN;
	private String[] invalid_parentOrGuardianRIDOrUIN;
	
	private String[] valid_localAdministrativeAuthority;
	private String[] invalid_localAdministrativeAuthority;
	
	private String[] invalid_emailId;

}
