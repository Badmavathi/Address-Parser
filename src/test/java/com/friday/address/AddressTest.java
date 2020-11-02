package com.friday.address;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import com.friday.challenge.model.Address;
import com.friday.challenge.util.JSONOrderedObject;

public class AddressTest {

	@Test
	@DisplayName("Checks Address Equals method with same instance")
	public void testEqualsMethodWithSameInstance() {
		Address addr = new Address("Blaufeld", "25");
		assertTrue(addr.equals(addr));
	}

	@Test
	@DisplayName("Checks Address Equals method with null argument")
	public void testEqualsMethodWithNullArg() {
		Address addr = new Address("Blaufeld", "25");
		assertFalse(addr.equals(null));
	}

	@Test
	@DisplayName("Checks Address Equals method with instanceof ArrayList")
	public void testEqualsMethodWithArrayListArgument() {
		Address addr = new Address("Blaufeld", "25");
		assertFalse(addr.equals(new ArrayList<String>()));
	}

	@Test
	@DisplayName("Checks Address HashCode method if it returns same for same addresses")
	public void testHashCode() {
		Address addr1 = new Address("Blaufeld", "25");
		Address addr2 = new Address("Blaufeld", "25");
		assertTrue(addr1.hashCode() == addr2.hashCode());
	}

	@Test
	@DisplayName("Checks Address HashCode method for null street and house number")
	public void testHashCodeForNull() {
		Address addr1 = new Address(null, null);
		Address addr2 = new Address(null, null);
		assertTrue(addr1.hashCode() == addr2.hashCode());
	}

	@Test
	@DisplayName("Checks Address ToString method if it returns same for same addresses")
	public void testToString() {
		Address addr1 = new Address("Blaufeld", "25");
		Address addr2 = new Address("Blaufeld", "25");
		assertTrue(addr1.toString().equals(addr2.toString()));
	}

	@Test
	@DisplayName("Checks Address Equals method with different address")
	public void testEqualsMethodWithDifferentAddress() {
		Address addr1 = new Address("Blaufeld Str", "25");
		Address addr2 = new Address("Blaufeld", "2");
		assertFalse(addr1.equals(addr2));
	}

	@Test
	@DisplayName("Checks Address Equals method with different address")
	public void testEqualsMethodWithDifferentStreetName() {
		Address addr1 = new Address("Blaufeld", "250");
		Address addr2 = new Address("Blaufeld Str", "250");
		assertFalse(addr1.equals(addr2));
	}

	@Test
	@DisplayName("Checks Write to JSON String method")
	public void testWriteToJSON() {
		JSONOrderedObject jo = new JSONOrderedObject();
		jo.put("street", "FriedrichStr");
		jo.put("housenumber", "34");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			jo.writeJSONString(new PrintWriter(out));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
