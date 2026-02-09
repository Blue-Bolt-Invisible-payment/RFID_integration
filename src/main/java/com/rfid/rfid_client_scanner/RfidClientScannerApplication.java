package com.rfid.rfid_client_scanner;

import com.caen.RFIDLibrary.CAENRFIDException;
import com.rfid.rfid_client_scanner.service.CaenRfidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RfidClientScannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfidClientScannerApplication.class, args);
	}

	@Autowired
	private CaenRfidService caenRfidService;

	@EventListener(ApplicationReadyEvent.class)
	public void startScan()  {
        try {
            caenRfidService.startInventory(); // Start on app startup
        } catch (CAENRFIDException e) {
            throw new RuntimeException(e);
        }
    }
}
