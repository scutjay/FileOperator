package com.jaywu.operator;

import com.jaywu.enums.AudioFileType;
import com.jaywu.enums.DefinitionType;
import com.jaywu.enums.WebsiteURLType;
import com.jaywu.utils.StringUtilsException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        File file2 = new File("\\test2.mp4");
        file2.delete();
    }

    @Test
    public void should_return_normally_when_call_renameFile_given_false_false() throws Exception {
        // given
        File file = new File("\\" +
                "test" + "." + AudioFileType.MP4.getValue());
        System.out.println(file.getAbsolutePath());
        if (!file.exists())
            file.createNewFile();
        // when
        boolean rtn = FileNameOperator.renameFile(file, false, false);
        // then
        assertTrue(rtn);
        File file2 = new File("\\test.mp4");
        file2.delete();
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

    @Test
    public void should_return_normally_when_call_renameAll_given_nonexistent_path() throws StringUtilsException {
        // given
        String path = "\\wzj" + UUID.randomUUID();
        File rootDir = new File(path);
        // when
        FileNameOperator.renameAll(rootDir, false, false, false);
        // then
        rootDir.delete();
    }

    @Test
    public void should_return_normally_when_call_renameAll_given_file_path() throws StringUtilsException, IOException {
        // given
        String path = "\\wzj" + UUID.randomUUID();
        File rootDir = new File(path);
        rootDir.createNewFile();
        // when
        FileNameOperator.renameAll(rootDir, false, false, false);
        // then
        rootDir.delete();
    }

    @Test
    public void should_return_normally_when_call_renameAll_given_directory_path() throws StringUtilsException {
        File root = mock(File.class);
        File subDir = mock(File.class);
        File file = mock(File.class);
        when(root.exists()).thenReturn(true);
        when(root.isDirectory()).thenReturn(true);
        when(root.listFiles()).thenReturn(new File[]{subDir, file});
        when(root.getAbsolutePath()).thenReturn("\\wzj");
        when(subDir.isDirectory()).thenReturn(true);
        when(file.isDirectory()).thenReturn(false);
        when(file.isFile()).thenReturn(true);
        when(file.getParentFile()).thenReturn(root);
        when(file.getName()).thenReturn("test.txt");
        // when
        FileNameOperator.renameAll(root, false, false, false);
        // then
    }

    @Test
    public void should_return_normally_when_call_renameAll_given_directory_path_excludeAll() throws StringUtilsException {
        // given
        File root = mock(File.class);
        File subDir = mock(File.class);
        when(root.exists()).thenReturn(true);
        when(root.isDirectory()).thenReturn(true);
        when(root.listFiles()).thenReturn(new File[]{subDir});
        when(subDir.isDirectory()).thenReturn(true);
        // when
        FileNameOperator.renameAll(root, true, false, false);
        // then
    }

    @Test
    public void test() throws StringUtilsException {
        File file = new File("G:\\迅雷下载");
        FileNameOperator.renameAll(file, true, true, true);
    }
} 
