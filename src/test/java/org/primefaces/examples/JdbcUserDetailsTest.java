package org.primefaces.examples;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class JdbcUserDetailsTest {

	@Before
	public void setUp() throws Exception {
		org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url",
				"jdbc:hsqldb:mem:moviecollection", "--noexit" });
	}

	@Test
	public void testFindAllGroups() {
		assertTrue("True", true);
	}

}
