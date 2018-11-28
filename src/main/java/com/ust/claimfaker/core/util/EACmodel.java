package com.ust.claimfaker.core.util;

public class EACmodel {

	String RecipientNumber;
	int RecipientNumber_len = 9;

	String ValidationDigit;
	int ValidationDigit_len = 1;

	String CountryCode;
	int CountryCode_len = 2;

	String CurrnetPlanCode;
	int CurrnetPlanCode_len = 2;

	String OtherInsuranceIndicator;
	int OtherInsuranceIndicator_len = 1;

	String PregnancyIndicator;
	int PregnancyIndicator_len = 1;

	String DeliveryDate;
	int DeliveryDate_len = 8;

	String SpecMedNeeds1;
	int SpecMedNeeds1_len = 6;

	String SpecialNeedsNotes;
	int SpecialNeedsNotes_len = 200;

	String MedicareNumber;
	int MedicareNumber_len = 10;

	String OtherInsCov1;
	int OtherInsCov1_len = 3;

	String OtherInsPolicy1;
	int OtherInsPolicy1_len = 20;

	String OtherInsCov2;
	int OtherInsCov2_len = 3;

	String OtherInsPolicy2;
	int OtherInsPolicy2_len = 20;

	String PlanProviderNum;
	int PlanProviderNum_len = 15;

	//New 9/11/2018 add one byte
	
	String PlanProviderType;
	int PlanProviderType_len = 2;

	String PCPLastNameOrGroup;
	int PCPLastNameOrGroup_len = 30;

	String PCPFirstName;
	int PCPFirstName_len = 30;

	String PCPMiddleInitial;
	int PCPMiddleInitial_len = 1;

	String PCPNotes;
	int PCPNotes_len = 200;

	String CaseTelNum;
	int CaseTelNum_len = 10;

	String CaseAltTelNum;
	int CaseAltTelNum_len = 10;

	String CaseAddressLine1;
	int CaseAddressLine1_len = 27;

	String CaseAddressLine2;
	int CaseAddressLine2_len = 26;

	String CaseCity;
	int CaseCity_len = 16;

	String CaseState;
	int CaseState_len = 2;

	String CaseZipMain;
	int CaseZipMain_len = 5;

	String CaseZipExt;
	int CaseZipExt_len = 4;

	String LanguageCode;
	int LanguageCode_len = 2;
	/**
	 * @return the recipientNumber
	 */
	public String getRecipientNumber() {
		return RecipientNumber;
	}
	/**
	 * @param recipientNumber the recipientNumber to set
	 */
	public void setRecipientNumber(String recipientNumber) {
		RecipientNumber = recipientNumber;
	}
	/**
	 * @return the recipientNumber_len
	 */
	public int getRecipientNumber_len() {
		return RecipientNumber_len;
	}
	/**
	 * @param recipientNumber_len the recipientNumber_len to set
	 */
	public void setRecipientNumber_len(int recipientNumber_len) {
		RecipientNumber_len = recipientNumber_len;
	}
	/**
	 * @return the validationDigit
	 */
	public String getValidationDigit() {
		return ValidationDigit;
	}
	/**
	 * @param validationDigit the validationDigit to set
	 */
	public void setValidationDigit(String validationDigit) {
		ValidationDigit = validationDigit;
	}
	/**
	 * @return the validationDigit_len
	 */
	public int getValidationDigit_len() {
		return ValidationDigit_len;
	}
	/**
	 * @param validationDigit_len the validationDigit_len to set
	 */
	public void setValidationDigit_len(int validationDigit_len) {
		ValidationDigit_len = validationDigit_len;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return CountryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	/**
	 * @return the countryCode_len
	 */
	public int getCountryCode_len() {
		return CountryCode_len;
	}
	/**
	 * @param countryCode_len the countryCode_len to set
	 */
	public void setCountryCode_len(int countryCode_len) {
		CountryCode_len = countryCode_len;
	}
	/**
	 * @return the currnetPlanCode
	 */
	public String getCurrnetPlanCode() {
		return CurrnetPlanCode;
	}
	/**
	 * @param currnetPlanCode the currnetPlanCode to set
	 */
	public void setCurrnetPlanCode(String currnetPlanCode) {
		CurrnetPlanCode = currnetPlanCode;
	}
	/**
	 * @return the currnetPlanCode_len
	 */
	public int getCurrnetPlanCode_len() {
		return CurrnetPlanCode_len;
	}
	/**
	 * @param currnetPlanCode_len the currnetPlanCode_len to set
	 */
	public void setCurrnetPlanCode_len(int currnetPlanCode_len) {
		CurrnetPlanCode_len = currnetPlanCode_len;
	}
	/**
	 * @return the otherInsuranceIndicator
	 */
	public String getOtherInsuranceIndicator() {
		return OtherInsuranceIndicator;
	}
	/**
	 * @param otherInsuranceIndicator the otherInsuranceIndicator to set
	 */
	public void setOtherInsuranceIndicator(String otherInsuranceIndicator) {
		OtherInsuranceIndicator = otherInsuranceIndicator;
	}
	/**
	 * @return the otherInsuranceIndicator_len
	 */
	public int getOtherInsuranceIndicator_len() {
		return OtherInsuranceIndicator_len;
	}
	/**
	 * @param otherInsuranceIndicator_len the otherInsuranceIndicator_len to set
	 */
	public void setOtherInsuranceIndicator_len(int otherInsuranceIndicator_len) {
		OtherInsuranceIndicator_len = otherInsuranceIndicator_len;
	}
	/**
	 * @return the pregnancyIndicator
	 */
	public String getPregnancyIndicator() {
		return PregnancyIndicator;
	}
	/**
	 * @param pregnancyIndicator the pregnancyIndicator to set
	 */
	public void setPregnancyIndicator(String pregnancyIndicator) {
		PregnancyIndicator = pregnancyIndicator;
	}
	/**
	 * @return the pregnancyIndicator_len
	 */
	public int getPregnancyIndicator_len() {
		return PregnancyIndicator_len;
	}
	/**
	 * @param pregnancyIndicator_len the pregnancyIndicator_len to set
	 */
	public void setPregnancyIndicator_len(int pregnancyIndicator_len) {
		PregnancyIndicator_len = pregnancyIndicator_len;
	}
	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return DeliveryDate;
	}
	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	/**
	 * @return the deliveryDate_len
	 */
	public int getDeliveryDate_len() {
		return DeliveryDate_len;
	}
	/**
	 * @param deliveryDate_len the deliveryDate_len to set
	 */
	public void setDeliveryDate_len(int deliveryDate_len) {
		DeliveryDate_len = deliveryDate_len;
	}
	/**
	 * @return the specMedNeeds1
	 */
	public String getSpecMedNeeds1() {
		return SpecMedNeeds1;
	}
	/**
	 * @param specMedNeeds1 the specMedNeeds1 to set
	 */
	public void setSpecMedNeeds1(String specMedNeeds1) {
		SpecMedNeeds1 = specMedNeeds1;
	}
	/**
	 * @return the specMedNeeds1_len
	 */
	public int getSpecMedNeeds1_len() {
		return SpecMedNeeds1_len;
	}
	/**
	 * @param specMedNeeds1_len the specMedNeeds1_len to set
	 */
	public void setSpecMedNeeds1_len(int specMedNeeds1_len) {
		SpecMedNeeds1_len = specMedNeeds1_len;
	}
	/**
	 * @return the specialNeedsNotes
	 */
	public String getSpecialNeedsNotes() {
		return SpecialNeedsNotes;
	}
	/**
	 * @param specialNeedsNotes the specialNeedsNotes to set
	 */
	public void setSpecialNeedsNotes(String specialNeedsNotes) {
		SpecialNeedsNotes = specialNeedsNotes;
	}
	/**
	 * @return the specialNeedsNotes_len
	 */
	public int getSpecialNeedsNotes_len() {
		return SpecialNeedsNotes_len;
	}
	/**
	 * @param specialNeedsNotes_len the specialNeedsNotes_len to set
	 */
	public void setSpecialNeedsNotes_len(int specialNeedsNotes_len) {
		SpecialNeedsNotes_len = specialNeedsNotes_len;
	}
	/**
	 * @return the medicareNumber
	 */
	public String getMedicareNumber() {
		return MedicareNumber;
	}
	/**
	 * @param medicareNumber the medicareNumber to set
	 */
	public void setMedicareNumber(String medicareNumber) {
		MedicareNumber = medicareNumber;
	}
	/**
	 * @return the medicareNumber_len
	 */
	public int getMedicareNumber_len() {
		return MedicareNumber_len;
	}
	/**
	 * @param medicareNumber_len the medicareNumber_len to set
	 */
	public void setMedicareNumber_len(int medicareNumber_len) {
		MedicareNumber_len = medicareNumber_len;
	}
	/**
	 * @return the otherInsCov1
	 */
	public String getOtherInsCov1() {
		return OtherInsCov1;
	}
	/**
	 * @param otherInsCov1 the otherInsCov1 to set
	 */
	public void setOtherInsCov1(String otherInsCov1) {
		OtherInsCov1 = otherInsCov1;
	}
	/**
	 * @return the otherInsCov1_len
	 */
	public int getOtherInsCov1_len() {
		return OtherInsCov1_len;
	}
	/**
	 * @param otherInsCov1_len the otherInsCov1_len to set
	 */
	public void setOtherInsCov1_len(int otherInsCov1_len) {
		OtherInsCov1_len = otherInsCov1_len;
	}
	/**
	 * @return the otherInsPolicy1
	 */
	public String getOtherInsPolicy1() {
		return OtherInsPolicy1;
	}
	/**
	 * @param otherInsPolicy1 the otherInsPolicy1 to set
	 */
	public void setOtherInsPolicy1(String otherInsPolicy1) {
		OtherInsPolicy1 = otherInsPolicy1;
	}
	/**
	 * @return the otherInsPolicy1_len
	 */
	public int getOtherInsPolicy1_len() {
		return OtherInsPolicy1_len;
	}
	/**
	 * @param otherInsPolicy1_len the otherInsPolicy1_len to set
	 */
	public void setOtherInsPolicy1_len(int otherInsPolicy1_len) {
		OtherInsPolicy1_len = otherInsPolicy1_len;
	}
	/**
	 * @return the otherInsCov2
	 */
	public String getOtherInsCov2() {
		return OtherInsCov2;
	}
	/**
	 * @param otherInsCov2 the otherInsCov2 to set
	 */
	public void setOtherInsCov2(String otherInsCov2) {
		OtherInsCov2 = otherInsCov2;
	}
	/**
	 * @return the otherInsCov2_len
	 */
	public int getOtherInsCov2_len() {
		return OtherInsCov2_len;
	}
	/**
	 * @param otherInsCov2_len the otherInsCov2_len to set
	 */
	public void setOtherInsCov2_len(int otherInsCov2_len) {
		OtherInsCov2_len = otherInsCov2_len;
	}
	/**
	 * @return the otherInsPolicy2
	 */
	public String getOtherInsPolicy2() {
		return OtherInsPolicy2;
	}
	/**
	 * @param otherInsPolicy2 the otherInsPolicy2 to set
	 */
	public void setOtherInsPolicy2(String otherInsPolicy2) {
		OtherInsPolicy2 = otherInsPolicy2;
	}
	/**
	 * @return the otherInsPolicy2_len
	 */
	public int getOtherInsPolicy2_len() {
		return OtherInsPolicy2_len;
	}
	/**
	 * @param otherInsPolicy2_len the otherInsPolicy2_len to set
	 */
	public void setOtherInsPolicy2_len(int otherInsPolicy2_len) {
		OtherInsPolicy2_len = otherInsPolicy2_len;
	}
	/**
	 * @return the planProviderNum
	 */
	public String getPlanProviderNum() {
		return PlanProviderNum;
	}
	/**
	 * @param planProviderNum the planProviderNum to set
	 */
	public void setPlanProviderNum(String planProviderNum) {
		PlanProviderNum = planProviderNum;
	}
	/**
	 * @return the planProviderNum_len
	 */
	public int getPlanProviderNum_len() {
		return PlanProviderNum_len;
	}
	/**
	 * @param planProviderNum_len the planProviderNum_len to set
	 */
	public void setPlanProviderNum_len(int planProviderNum_len) {
		PlanProviderNum_len = planProviderNum_len;
	}
	/**
	 * @return the planProviderType
	 */
	public String getPlanProviderType() {
		return PlanProviderType;
	}
	/**
	 * @param planProviderType the planProviderType to set
	 */
	public void setPlanProviderType(String planProviderType) {
		PlanProviderType = planProviderType;
	}
	/**
	 * @return the planProviderType_len
	 */
	public int getPlanProviderType_len() {
		return PlanProviderType_len;
	}
	/**
	 * @param planProviderType_len the planProviderType_len to set
	 */
	public void setPlanProviderType_len(int planProviderType_len) {
		PlanProviderType_len = planProviderType_len;
	}
	/**
	 * @return the pCPLastNameOrGroup
	 */
	public String getPCPLastNameOrGroup() {
		return PCPLastNameOrGroup;
	}
	/**
	 * @param pCPLastNameOrGroup the pCPLastNameOrGroup to set
	 */
	public void setPCPLastNameOrGroup(String pCPLastNameOrGroup) {
		PCPLastNameOrGroup = pCPLastNameOrGroup;
	}
	/**
	 * @return the pCPLastNameOrGroup_len
	 */
	public int getPCPLastNameOrGroup_len() {
		return PCPLastNameOrGroup_len;
	}
	/**
	 * @param pCPLastNameOrGroup_len the pCPLastNameOrGroup_len to set
	 */
	public void setPCPLastNameOrGroup_len(int pCPLastNameOrGroup_len) {
		PCPLastNameOrGroup_len = pCPLastNameOrGroup_len;
	}
	/**
	 * @return the pCPFirstName
	 */
	public String getPCPFirstName() {
		return PCPFirstName;
	}
	/**
	 * @param pCPFirstName the pCPFirstName to set
	 */
	public void setPCPFirstName(String pCPFirstName) {
		PCPFirstName = pCPFirstName;
	}
	/**
	 * @return the pCPFirstName_len
	 */
	public int getPCPFirstName_len() {
		return PCPFirstName_len;
	}
	/**
	 * @param pCPFirstName_len the pCPFirstName_len to set
	 */
	public void setPCPFirstName_len(int pCPFirstName_len) {
		PCPFirstName_len = pCPFirstName_len;
	}
	/**
	 * @return the middleInitial
	 */
	public String getPCPMiddleInitial() {
		return PCPMiddleInitial;
	}
	/**
	 * @param middleInitial the middleInitial to set
	 */
	public void setPCPMiddleInitial(String middleInitial) {
		PCPMiddleInitial = middleInitial;
	}
	/**
	 * @return the middleInitial_len
	 */
	public int getPCPMiddleInitial_len() {
		return PCPMiddleInitial_len;
	}
	/**
	 * @param middleInitial_len the middleInitial_len to set
	 */
	public void setPCPMiddleInitial_len(int middleInitial_len) {
		PCPMiddleInitial_len = middleInitial_len;
	}
	/**
	 * @return the pCPNotes
	 */
	public String getPCPNotes() {
		return PCPNotes;
	}
	/**
	 * @param pCPNotes the pCPNotes to set
	 */
	public void setPCPNotes(String pCPNotes) {
		PCPNotes = pCPNotes;
	}
	/**
	 * @return the pCPNotes_len
	 */
	public int getPCPNotes_len() {
		return PCPNotes_len;
	}
	/**
	 * @param pCPNotes_len the pCPNotes_len to set
	 */
	public void setPCPNotes_len(int pCPNotes_len) {
		PCPNotes_len = pCPNotes_len;
	}
	/**
	 * @return the caseTelNum
	 */
	public String getCaseTelNum() {
		return CaseTelNum;
	}
	/**
	 * @param caseTelNum the caseTelNum to set
	 */
	public void setCaseTelNum(String caseTelNum) {
		CaseTelNum = caseTelNum;
	}
	/**
	 * @return the caseTelNum_len
	 */
	public int getCaseTelNum_len() {
		return CaseTelNum_len;
	}
	/**
	 * @param caseTelNum_len the caseTelNum_len to set
	 */
	public void setCaseTelNum_len(int caseTelNum_len) {
		CaseTelNum_len = caseTelNum_len;
	}
	/**
	 * @return the caseAltTelNum
	 */
	public String getCaseAltTelNum() {
		return CaseAltTelNum;
	}
	/**
	 * @param caseAltTelNum the caseAltTelNum to set
	 */
	public void setCaseAltTelNum(String caseAltTelNum) {
		CaseAltTelNum = caseAltTelNum;
	}
	/**
	 * @return the caseAltTelNum_len
	 */
	public int getCaseAltTelNum_len() {
		return CaseAltTelNum_len;
	}
	/**
	 * @param caseAltTelNum_len the caseAltTelNum_len to set
	 */
	public void setCaseAltTelNum_len(int caseAltTelNum_len) {
		CaseAltTelNum_len = caseAltTelNum_len;
	}
	/**
	 * @return the caseAddressLine1
	 */
	public String getCaseAddressLine1() {
		return CaseAddressLine1;
	}
	/**
	 * @param caseAddressLine1 the caseAddressLine1 to set
	 */
	public void setCaseAddressLine1(String caseAddressLine1) {
		CaseAddressLine1 = caseAddressLine1;
	}
	/**
	 * @return the caseAddressLine1_len
	 */
	public int getCaseAddressLine1_len() {
		return CaseAddressLine1_len;
	}
	/**
	 * @param caseAddressLine1_len the caseAddressLine1_len to set
	 */
	public void setCaseAddressLine1_len(int caseAddressLine1_len) {
		CaseAddressLine1_len = caseAddressLine1_len;
	}
	/**
	 * @return the caseAddressLine2
	 */
	public String getCaseAddressLine2() {
		return CaseAddressLine2;
	}
	/**
	 * @param caseAddressLine2 the caseAddressLine2 to set
	 */
	public void setCaseAddressLine2(String caseAddressLine2) {
		CaseAddressLine2 = caseAddressLine2;
	}
	/**
	 * @return the caseAddressLine2_len
	 */
	public int getCaseAddressLine2_len() {
		return CaseAddressLine2_len;
	}
	/**
	 * @param caseAddressLine2_len the caseAddressLine2_len to set
	 */
	public void setCaseAddressLine2_len(int caseAddressLine2_len) {
		CaseAddressLine2_len = caseAddressLine2_len;
	}
	/**
	 * @return the caseCity
	 */
	public String getCaseCity() {
		return CaseCity;
	}
	/**
	 * @param caseCity the caseCity to set
	 */
	public void setCaseCity(String caseCity) {
		CaseCity = caseCity;
	}
	/**
	 * @return the caseCity_len
	 */
	public int getCaseCity_len() {
		return CaseCity_len;
	}
	/**
	 * @param caseCity_len the caseCity_len to set
	 */
	public void setCaseCity_len(int caseCity_len) {
		CaseCity_len = caseCity_len;
	}
	/**
	 * @return the caseState
	 */
	public String getCaseState() {
		return CaseState;
	}
	/**
	 * @param caseState the caseState to set
	 */
	public void setCaseState(String caseState) {
		CaseState = caseState;
	}
	/**
	 * @return the caseState_len
	 */
	public int getCaseState_len() {
		return CaseState_len;
	}
	/**
	 * @param caseState_len the caseState_len to set
	 */
	public void setCaseState_len(int caseState_len) {
		CaseState_len = caseState_len;
	}
	/**
	 * @return the caseZipMain
	 */
	public String getCaseZipMain() {
		return CaseZipMain;
	}
	/**
	 * @param caseZipMain the caseZipMain to set
	 */
	public void setCaseZipMain(String caseZipMain) {
		CaseZipMain = caseZipMain;
	}
	/**
	 * @return the caseZipMain_len
	 */
	public int getCaseZipMain_len() {
		return CaseZipMain_len;
	}
	/**
	 * @param caseZipMain_len the caseZipMain_len to set
	 */
	public void setCaseZipMain_len(int caseZipMain_len) {
		CaseZipMain_len = caseZipMain_len;
	}
	/**
	 * @return the caseZipExt
	 */
	public String getCaseZipExt() {
		return CaseZipExt;
	}
	/**
	 * @param caseZipExt the caseZipExt to set
	 */
	public void setCaseZipExt(String caseZipExt) {
		CaseZipExt = caseZipExt;
	}
	/**
	 * @return the caseZipExt_len
	 */
	public int getCaseZipExt_len() {
		return CaseZipExt_len;
	}
	/**
	 * @param caseZipExt_len the caseZipExt_len to set
	 */
	public void setCaseZipExt_len(int caseZipExt_len) {
		CaseZipExt_len = caseZipExt_len;
	}
	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return LanguageCode;
	}
	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		LanguageCode = languageCode;
	}
	/**
	 * @return the languageCode_len
	 */
	public int getLanguageCode_len() {
		return LanguageCode_len;
	}
	/**
	 * @param languageCode_len the languageCode_len to set
	 */
	public void setLanguageCode_len(int languageCode_len) {
		LanguageCode_len = languageCode_len;
	}
	

}
