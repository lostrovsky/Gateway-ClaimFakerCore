package com.ust.claimfaker.core.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.ust.claimfaker.core.Faker;
import com.ust.claimfaker.core.util.EACmodel;

public class makeFakeEAC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cityPool = null;

		try {
			cityPool = getRandomAddressPool.cityZip(1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] CITY = cityPool[0].split("\\|");

		EACmodel thisEAC = new EACmodel();

		try {
			InputStream in = new FileInputStream("EACfak1.txt");
			Reader r = new InputStreamReader(in, "US-ASCII");

			String holder = "";
			int intch = 0;
			char[] cholder = null;

			int i = 0;

			int lines = 0;

			while (r.ready()) {
				++lines;

				Faker faker = new Faker();

				try {
					cityPool = getRandomAddressPool.cityZip(1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CITY = cityPool[0].split("\\|");

				while (i < thisEAC.getRecipientNumber_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				if (!r.ready()) {
					// System.out.println(" top row " + lines);
					break;
				}

				if (holder == "TRAILER R") {

					for (int x = 0; x < 50; ++x) {
						intch = r.read();
						char ch = (char) intch;
						holder += ch;
					}
					System.out.println(holder);

				}

				thisEAC.setRecipientNumber(holder);
				thisEAC.setRecipientNumber(Integer.toString(faker.number().numberBetween(111111111, 444444444)));

				//// System.out.println(":" + holder + ":");
				holder = "";
				i = 0;
				intch = 0;

				while (i < thisEAC.getValidationDigit_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setValidationDigit(holder);
				holder = "";
				i = 0;
				intch = 0;

				while (i < thisEAC.getCountryCode_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCountryCode(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getCurrnetPlanCode_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCurrnetPlanCode(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getOtherInsuranceIndicator_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setOtherInsuranceIndicator(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getPregnancyIndicator_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPregnancyIndicator(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getDeliveryDate_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setDeliveryDate(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getSpecMedNeeds1_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setSpecMedNeeds1(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getSpecialNeedsNotes_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setSpecialNeedsNotes(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getMedicareNumber_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setMedicareNumber(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getOtherInsCov1_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setOtherInsCov1(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getOtherInsPolicy1_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setOtherInsPolicy1(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getOtherInsCov2_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setOtherInsCov2(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getOtherInsPolicy2_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setOtherInsPolicy2(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getPlanProviderNum_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPlanProviderNum(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getPlanProviderType_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPlanProviderType(holder);
				//System.out.println("HOLDER: " + holder );
				holder = "";
				i = 0;
				
				//New char 9/11/2018
										

				while (i < thisEAC.getPCPLastNameOrGroup_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPCPLastNameOrGroup(holder);

				holder = faker.name().lastName().toUpperCase();
				String padded = String.format("%-30s", holder); // .replace(' ', ' ');
				thisEAC.setPCPLastNameOrGroup(padded);
				holder = "";
				i = 0;

				while (i < thisEAC.getPCPFirstName_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPCPFirstName(holder);
				holder = faker.name().firstName().toUpperCase();
				padded = String.format("%-30s", holder); // .replace(' ', ' ');
				thisEAC.setPCPFirstName(padded);
				holder = "";
				i = 0;

				while (i < thisEAC.getPCPMiddleInitial_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPCPMiddleInitial(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getPCPNotes_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setPCPNotes(holder);
				holder = "";
				i = 0;

				while (i < thisEAC.getCaseTelNum_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseTelNum(holder);

				String homePhone = faker.phoneNumber().cellPhone().replaceAll("\\.", "").replaceAll("-", "")
						.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
				if (homePhone.startsWith("1") || homePhone.startsWith("0"))
					homePhone = homePhone.substring(1, 10);
				if (homePhone.length() < 10)
					for (int j = homePhone.length(); j < 10; ++j)
						homePhone += "0";
				// System.out.println("{" + homePhone + "}");
				thisEAC.setCaseTelNum(homePhone);

				holder = "";
				i = 0;

				while (i < thisEAC.getCaseAltTelNum_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseAltTelNum(holder);

				String altPhone = faker.phoneNumber().cellPhone().replaceAll("\\.", "").replaceAll("-", "")
						.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
				if (altPhone.startsWith("1") || altPhone.startsWith("0"))
					altPhone = altPhone.substring(1, 10);
				if (altPhone.length() < 10)
					for (int j = altPhone.length(); j < 10; ++j)
						altPhone += "0";
				// System.out.println("{" + altPhone + "}");
				thisEAC.setCaseAltTelNum(altPhone);

				holder = "";
				i = 0;

				while (i < thisEAC.getCaseAddressLine1_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseAddressLine1(holder);
				thisEAC.setCaseAddressLine1(faker.address().streetAddress().toUpperCase());

				holder = faker.address().streetAddress().toUpperCase();

				padded = String.format("%-27s", holder); // .replace(' ', ' ');
				thisEAC.setCaseAddressLine1(padded);

				// System.out.println("{" + thisEAC.getCaseAddressLine1() + "}");

				// String CAddr1 = faker.address().streetAddress();

				holder = "";
				i = 0;

				while (i < thisEAC.getCaseAddressLine2_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseAddressLine2(holder);
				if (holder.length() > 0)
					thisEAC.setCaseAddressLine2(faker.address().secondaryAddress().toUpperCase());

				holder = faker.address().secondaryAddress().toUpperCase();

				padded = String.format("%-26s", holder); // .replace(' ', ' ');
				thisEAC.setCaseAddressLine2(padded);

				holder = "";
				i = 0;

				while (i < thisEAC.getCaseCity_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseCity(holder);
				thisEAC.setCaseCity(faker.address().cityName().toUpperCase()); // SQL Philly local

				holder = CITY[0].toUpperCase();
				padded = String.format("%-16s", holder); // .replace(' ', ' ');

				// System.out.println("{" + padded + "} " + padded.length());
				thisEAC.setCaseCity(padded.toUpperCase());

				// String.format(CITY[1].length(),holder);

				holder = "";
				i = 0;

				while (i < thisEAC.getCaseState_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseState(holder);
				thisEAC.setCaseState(faker.address().stateAbbr().toUpperCase());

				thisEAC.setCaseState(CITY[1].toUpperCase());
				holder = "";
				i = 0;

				while (i < thisEAC.getCaseZipMain_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseZipMain(holder);
				thisEAC.setCaseZipMain(faker.address().zipCode());
				thisEAC.setCaseZipMain(CITY[3].toUpperCase());

				holder = "";
				i = 0;

				while (i < thisEAC.getCaseZipExt_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setCaseZipExt(holder);
				thisEAC.setCaseZipExt(Integer.toString(faker.number().numberBetween(1111, 7777)));
				holder = "";
				i = 0;

				while (i < thisEAC.getLanguageCode_len() && (intch = r.read()) != -1) {
					char ch = (char) intch;
					holder += ch;
					++i;
				}
				thisEAC.setLanguageCode(holder);
				holder = "";
				i = 0;

				intch = r.read(); // single CR ala Mac or TSO

				String row = thisEAC.getRecipientNumber() + thisEAC.getValidationDigit() + thisEAC.getCountryCode()
						+ thisEAC.getCurrnetPlanCode() + thisEAC.getOtherInsuranceIndicator()
						+ thisEAC.getPregnancyIndicator() + thisEAC.getDeliveryDate() + thisEAC.getSpecMedNeeds1()
						+ thisEAC.getSpecialNeedsNotes() + thisEAC.getMedicareNumber() + thisEAC.getOtherInsCov1()
						+ thisEAC.getOtherInsPolicy1() + thisEAC.getOtherInsCov2() + thisEAC.getOtherInsPolicy2()
						+ thisEAC.getPlanProviderNum() + thisEAC.getPlanProviderType() + thisEAC.getPCPLastNameOrGroup()
						+ thisEAC.getPCPFirstName() + thisEAC.getPCPMiddleInitial() + thisEAC.getPCPNotes()
						+ thisEAC.getCaseAltTelNum() + thisEAC.getCaseAltTelNum() + thisEAC.getCaseAddressLine1()
						+ thisEAC.getCaseAddressLine2() + thisEAC.getCaseCity() + thisEAC.getCaseState()
						+ thisEAC.getCaseZipMain() + thisEAC.getCaseZipExt() + thisEAC.getLanguageCode();
				// + (char) intch;

				System.out.print(row + "\r");

				if (!r.ready()) {

					System.out.println(" row " + lines);
					break;
				}

			} // end of whiletrue

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int countASCIILetters(File f) throws IOException {
		Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(f), "US-ASCII"));
		try {
			int count = 0;
			int intch;
			while ((intch = r.read()) != -1) {
				int ch = (char) intch;
				if (Character.isLetter(ch)) {
					count++;
				}
			}
			return count;
		} finally {
			r.close();
		}
	}

	public void fakes() {

		Faker faker = new Faker();

		faker.number().numberBetween(111111111, 444444444);

		String name = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String middleName = faker.name().firstName();
		String middleInitial = middleName.substring(0, 1).toUpperCase();
		String ssN = faker.idNumber().ssnValid();

		String streetAddress = faker.address().streetAddress();
		String streetAddress2 = faker.address().secondaryAddress();
		String City = faker.address().cityName();
		String State = faker.address().stateAbbr();

		String zipCode = faker.address().zipCode();
		String homePhone = faker.phoneNumber().phoneNumber();
		String cellPhone = faker.phoneNumber().cellPhone();

		String emailAddress = faker.internet().emailAddress();

		/*
		 * System.out.println(firstName + " " + middleInitial + " " + lastName + "(" +
		 * middleName + ")" + "," + ssN + "\n" + streetAddress + ",\n" + streetAddress2
		 * + ",\n" + City + ", " + State + "\n" + zipCode + "\n"
		 * 
		 * + homePhone + ",\n" + cellPhone + ",\n"
		 * 
		 * + emailAddress);
		 * 
		 */

	}
}
