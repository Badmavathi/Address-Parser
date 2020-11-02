package com.friday.challenge.main;

import java.util.Scanner;
import com.friday.challenge.parser.AddressParserFactory;
import com.friday.challenge.parser.AddressParserFactory.ParserType;

/** 
 * @author Badmavathi Balaji
 * Run this file to get address input
 * Press 'Enter' key to exit the program.
 */

public class App {

	public void run() {
		Scanner sc = new Scanner(System.in);
		String address = "";
		while ((address = sc.nextLine().trim()).length() > 0) {
			System.out.println("Inputed Address :: " + address);
			System.out.println(new AddressParserFactory().getAddressParser(ParserType.EUROPEAN_PARSER).parse(address));
		}
		sc.close();
	}

	public static void main(String[] args) {
		new App().run();
	}
}
