package Fortis_Sidera.spotform.service;

import Fortis_Sidera.spotform.dto.DocumentRequest;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    public String generateDocument(DocumentRequest request) {
        System.out.println("Данные получены:");
        System.out.println("ФИО: " + request.getFullName());
        System.out.println("Дата рождения: " + request.getDateOfBirth());
        System.out.println("Паспорт: " + request.getPassportNumber());

        return "https://hui.com";
    }

}
