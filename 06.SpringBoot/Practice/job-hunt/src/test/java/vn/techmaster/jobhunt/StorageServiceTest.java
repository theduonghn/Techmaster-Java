package vn.techmaster.jobhunt;

import org.junit.jupiter.api.Test;

import vn.techmaster.jobhunt.service.StorageService;
import static org.assertj.core.api.Assertions.*;

class StorageServiceTest {
    @Test
    void test_getFileExtension() {
        StorageService storageService = new StorageService();
        String extension = storageService.getFileExtension("logo_cmc.jpg");
        assertThat(extension).isEqualTo("jpg");
        extension = storageService.getFileExtension("pic1.png");
        assertThat(extension).isEqualTo("png");
    }
}
