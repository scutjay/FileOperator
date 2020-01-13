package com.jaywu.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * NameFilter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1�� 12, 2020</pre>
 */
public class StringUtilsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void should_return_true_when_call_isEmpty_given_null() {
        // given
        // when
        // then
        assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    public void should_return_true_when_call_isEmpty_given_empty_string() {
        // given
        // when
        // then
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void should_return_false_when_call_isEmpty_given_str() {
        // given
        // when
        // then
        assertFalse(StringUtils.isEmpty("str"));
    }

    @Test
    public void should_throw_exception_when_call_removeTargetString_given_no_origin_string() throws StringUtilsException {
        // given
        thrown.expect(StringUtilsException.class);
        thrown.expectMessage("No input string found");
        // when
        StringUtils.removeTargetString(null, "");
        // then
    }

    @Test
    public void should_return_normally_when_call_removeTargetString() throws StringUtilsException {
        // given
        // when
        String rtn = StringUtils.removeTargetString("ABCTestABC", "ABC");
        // then
        assertEquals("Test",rtn);
    }

    @Test
    public void should_return_origin_when_call_removeTargetString_given_no_target_string() throws StringUtilsException {
        // given
        String origin = "ABCTestABC";
        // when
        String rtn = StringUtils.removeTargetString(origin,null);
        // then
        assertEquals(origin, rtn);
    }
}