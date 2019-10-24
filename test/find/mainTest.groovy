package finder

import org.junit.jupiter.api.Test

class mainTest {
    @Test
    void searchF() {
        String res = main.fileSearch("Seoul.txt", "test/testFiles", false);
        assertEquals("test/testFiles/Seoul.txt", res)
    }

    @Test
    void searchNonexistentF() {
        String res = main.fileSearch("Moscow.txt", "test/testFiles", false);
        assertEquals("404 File not found", res)
    }

    @Test
    void searchSubDirF() {
        String res = main.fileSearch("Washington.txt", "test/testFiles", true)
        assertEquals("test/testFiles/USA/Washington.txt",res)
    }
}
