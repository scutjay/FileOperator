package com.jaywu.objects;

import com.jaywu.enums.AudioFileType;
import com.jaywu.exception.FileTypeNotFoundException;
import com.jaywu.objects.MyFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

/**
 * MyFile Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1�� 12, 2020</pre>
 */
public class MyFileTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void should_return_normally_when_call_constructor() {
        // given
        // when
        new MyFile("");
        // then
    }

    @Test
    public void should_throw_exception_when_call_getFileType_given_no_dot_string_as_file_path() throws Exception {
        // given
        MyFile file = new MyFile("test");
        thrown.expect(FileTypeNotFoundException.class);
        thrown.expectMessage("No file type found");
        // when
        file.getFileType();
        // then
    }

    @Test
    public void should_throw_exception_when_call_getFileType_given_last_dot_string_as_file_path() throws Exception {
        // given
        MyFile file = new MyFile("test.");
        thrown.expect(FileTypeNotFoundException.class);
        thrown.expectMessage("No file type found");
        // when
        file.getFileType();
        // then
    }

    @Test
    public void should_return_rmvb_when_call_getFileType_given_rmvb_file() throws Exception {
        // given
        MyFile file = new MyFile("test.rmvb");
        // when
        String rtn = file.getFileType();
        // then
        assertEquals(AudioFileType.RMVB.getValue(), rtn);
    }
} 
