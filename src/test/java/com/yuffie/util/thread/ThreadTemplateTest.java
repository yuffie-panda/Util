package com.yuffie.util.thread;


import org.junit.Before;
import org.junit.Test;

import com.yuffie.util.test.TestBase;

/**
 * 
 * @author Yuffie
 *
 */
public class ThreadTemplateTest extends TestBase{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		
	}

	@Test
	public void test() {
		ThreadTemplate threadTemplate = new ThreadTemplate("hello");
		threadTemplate.start();
	}

}
