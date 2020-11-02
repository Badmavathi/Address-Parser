package com.friday.challenge.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.friday.challenge.model.Address;
import com.friday.challenge.util.ParserUtil;
/***
 * 
 * @author Badmavathi Balaji
 * Logic to parse address into street and house number in JSON format
 */

public class EuropeanAddressParser implements AddressParser {

	private final String COMMA = ",";
	private final String SPACE = " ";
	private final List<String> numberAliasList = Arrays.asList("No", "Num", "Number");
	private ParserUtil parserUtil = null;

	public EuropeanAddressParser() {
		this.parserUtil = new ParserUtil();
	}

	@Override
	public Address parse(String addressInput) {

		Address parsedAddress;
		String houseNoPrefix = null;
		List<String> addrList;

		if(addressInput == null) {
			throw new IllegalArgumentException("Please enter an input Address. Eg : Friedrichstrasse 10");
		}
		
		addressInput = addressInput.replaceAll(COMMA, SPACE);
		addrList = new ArrayList<String>(Arrays.asList(addressInput.split(SPACE)));
		houseNoPrefix = getNumberAlias(addrList);
		addrList.remove(houseNoPrefix);

		if (addrList.size() < 2) {
			throw new IllegalArgumentException("Please enter a valid Address. Eg : Friedrichstrasse 10");
		} else if (this.parserUtil.beginsWithNum(addrList.get(0))) {
			parsedAddress = parseAddressesStartingWithHouseNumber(houseNoPrefix, addrList);
		} else {
			parsedAddress = parseAddressesEndingWithHouseNumber(houseNoPrefix, addrList);
		}
		return parsedAddress;
	}

	private String getNumberAlias(List<String> addr) {
		String alias = null;
		Iterator<String> aliasIterator = numberAliasList.iterator();
		while (aliasIterator.hasNext()) {
			String currentAlias = aliasIterator.next();
			int index = addr.indexOf(currentAlias);
			if (index > -1) {
				alias = currentAlias;
				break;
			}
		}
		return alias;
	}

	private Address parseAddressesStartingWithHouseNumber(String houseNoPrefix, List<String> addrList) {
		String street = "";
		String houseNo = "";

		if (addrList.size() == 2) {
			houseNo = addrList.get(0);
			street = addrList.get(1);
		} else {
			houseNo = addrList.get(0);
			if (addrList.get(1).length() == 1)
				houseNo = houseNo + SPACE + addrList.get(1);
			else
				street = addrList.get(1);
			for (int i = 2; i < addrList.size(); i++) {
				street = street + SPACE + addrList.get(i);
			}
		}
		if (houseNoPrefix != null) {
			houseNo = houseNoPrefix + SPACE + houseNo;
		}
		return new Address(street, houseNo);
	}

	private Address parseAddressesEndingWithHouseNumber(String houseNoPrefix, List<String> addrList) {
		String street = "";
		String houseNo = "";
		int indexOfNum = this.parserUtil.getLastIndexOfNumber(addrList);

		if (indexOfNum < 0)
			throw new IllegalArgumentException("Please enter valid House number");

		if (addrList.size() == 2) {
			street = addrList.get(0);
			houseNo = addrList.get(1);
		} else {
			List<String> strList = addrList.subList(0, indexOfNum);
			for (String s : strList) {
				street = street + SPACE + s;
			}
			List<String> numList = addrList.subList(indexOfNum, addrList.size());
			for (String n : numList) {
				houseNo = houseNo != "" ? houseNo + SPACE + n : n;
			}
		}
		if (houseNoPrefix != null) {
			houseNo = houseNoPrefix + SPACE + houseNo;
		}
		return new Address(street, houseNo);
	}
}
