package com.jaywu.exception;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * FileTypeNotFoundException Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1�� 13, 2020</pre>
 */
public class FileTypeNotFoundExceptionTest {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void testConstructor() {
        // given
        // when
        Exception exception = new FileTypeNotFoundException("test");
        // then

        assertNotNull(exception);
        assertEquals("test", exception.getMessage());
    }
}
