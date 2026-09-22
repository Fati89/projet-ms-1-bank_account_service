package org.sid.bank_account_service.mappers;

import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


@Component
public class BankAccountMapper {
    public static BankAccount fromDTO(BankAccountRequestDTO dto) {
        return BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(dto.getBalance())
                .type(dto.getType())
                .currency(dto.getCurrency())
                .build();
    }

    public static BankAccount fromDTO(BankAccountRequestDTO dto, String id) {
        return BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(dto.getBalance())
                .type(dto.getType())
                .currency(dto.getCurrency())
                .build();
    }

    public static BankAccountResponseDTO fromEntity(BankAccount bankAccount) {
        return BankAccountResponseDTO.builder()
                .id(bankAccount.getId())
                .type(bankAccount.getType())
                .createdAt(bankAccount.getCreatedAt())
                .currency(bankAccount.getCurrency())
                .balance(bankAccount.getBalance())
                .build();
    }
}
