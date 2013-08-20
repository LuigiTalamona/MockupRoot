package org.talamona.mockup.tipicalCases.mockingNew;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/15/13
 * Time: 7:15 PM
 */

@PrepareForTest( Directory.class )
public class DirectoryTest  extends PowerMockTestCase {

    @Test
    public void interceptFileCreationToIsolateDirectoryTest() throws Exception {
        final String path = "directoryPath";
        File fileMock = PowerMockito.mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(fileMock);
        PowerMockito.when(fileMock.exists()).thenReturn(false);
        PowerMockito.when(fileMock.mkdirs()).thenReturn(true);
        Directory tested = new Directory();
        assertTrue(tested.createDirectoryStructure(path));
    }
}
