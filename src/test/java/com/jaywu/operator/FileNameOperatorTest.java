package com.jaywu.operator;

import com.jaywu.enums.AudioFileType;
import com.jaywu.enums.DefinitionType;
import com.jaywu.enums.WebsiteURLType;
import com.jaywu.utils.StringUtilsException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;

import static org.junit.Assert.*;

/**
 * FileOperator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1�� 13, 2020</pre>
 */
public class FileNameOperatorTest {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void should_return_normally_when_call_filterURL() throws StringUtilsException {
        // given
        String expected = "test.mp4";
        String fileName = WebsiteURLType.MovieHeavenURL.getValue() + WebsiteURLType.SunshineMovieURL.getValue() + expected;
        // when
        String rtn = FileNameOperator.filterURL(fileName);
        // then
        assertEquals(expected, rtn);
    }

    @Test
    public void should_return_normally_when_call_filterDefinition() throws StringUtilsException {
        // given
        String expected = "test.mp4";
        String fileName = DefinitionType.BD.getValue() + DefinitionType.HD2.getValue() + expected;
        // when
        String rtn = FileNameOperator.filterDefinition(fileName);
        // then
        assertEquals(expected, rtn);
    }

    @Test
    public void should_return_normally_when_call_isAudioFile_given_mp4() {
        // given
        String fileName = "test.mp4";
        // when
        boolean rtn = FileNameOperator.isAudioFile(fileName);
        // then
        assertTrue(rtn);
    }

    @Test
    public void should_return_true_when_call_isAudioFile_given_mP4() {
        // given
        String fileName = "test.mP4";
        // when
        boolean rtn = FileNameOperator.isAudioFile(fileName);
        // then
        assertTrue(rtn);
    }

    @Test
    public void should_return_false_when_call_isAudioFile_given_txt() {
        // given
        String fileName = "test.txt";
        // when
        boolean rtn = FileNameOperator.isAudioFile(fileName);
        // then
        assertFalse(rtn);
    }

    @Test
    public void should_return_normally_when_call_renameFile() throws Exception {
        // given
        File file = new File("\\" + WebsiteURLType.MovieHeavenURL.getValue() +
                "test" + "." + DefinitionType.HD2 + "." + AudioFileType.MP4.getValue());
        System.out.println(file.getAbsolutePath());
        if (!file.exists())
            file.createNewFile();
        // when
        boolean rtn = FileNameOperator.renameFile(file, true, true);
        // then
        assertTrue(rtn);
        if (rtn) {
            File file2 = new File("\\test2.mp4");
            file2.delete();
        }
    }

    @Test
    public void should_return_normally_when_call_renameFile_given_false_false() throws Exception {
        // given
        File file = new File("\\" +
                "test" + "." +  AudioFileType.MP4.getValue());
        System.out.println(file.getAbsolutePath());
        if (!file.exists())
            file.createNewFile();
        // when
        boolean rtn = FileNameOperator.renameFile(file, false, false);
        // then
        assertTrue(rtn);
        if (rtn) {
            File file2 = new File("\\test.mp4");
            file2.delete();
        }
    }

    @Test
    public void should_return_normally_when_call_removeExtraDot() {
        // given
        String fileName = ".test..mp4";
        // when
        String rtn = FileNameOperator.removeExtraDot(fileName);
        // then
        assertEquals("test.mp4", rtn);
    }
} 
