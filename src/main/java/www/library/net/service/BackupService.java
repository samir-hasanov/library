package www.library.net.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class BackupService {

    @Scheduled(fixedRate = 10000)
    public void backupDatabase() {
        String command = "D:\\Ciko\\backup_script.bat";

        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            log.info("PostgreSQL backup alındı!");
        } catch (IOException | InterruptedException e) {
            log.error("Backup alınmadı!", e);
        }
    }
}
