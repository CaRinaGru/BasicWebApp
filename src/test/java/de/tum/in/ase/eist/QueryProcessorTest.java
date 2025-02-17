package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void testKnowsMyName() {
		String actual = queryProcessor.process("name");
		if (!actual.contains("CaRina")) {
			fail("The QueryProcessor does not know my name!");
		}
	}

	@Test
	void test1() {
		String actual = queryProcessor.process("what is 16 plus 13");
		if (!actual.contains("29")) {
			fail("Not correct!");
		}
	}

	@Test
	void test2() {
		String actual = queryProcessor.process("which of the following numbers is the largest: 16, 45, 74, 659");
		if (!actual.contains("659")) {
			fail("Not correct!");
		}
	}


}
