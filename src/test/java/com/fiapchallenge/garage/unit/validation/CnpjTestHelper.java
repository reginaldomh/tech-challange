package com.fiapchallenge.garage.unit.validation;

import com.fiapchallenge.garage.application.validation.CpfCnpjValidator;

public class CnpjTestHelper {
    public static void main(String[] args) {
        CpfCnpjValidator validator = new CpfCnpjValidator();
        
        String[] cnpjs = {"11222333000181", "12345678000195", "98765432000100"};
        
        for (String cnpj : cnpjs) {
            System.out.println(cnpj + " is valid: " + validator.isValid(cnpj, null));
        }
        
        // Test some known valid CNPJs
        String[] knownValid = {"11222333000181", "11444777000161"};
        for (String cnpj : knownValid) {
            System.out.println(cnpj + " is valid: " + validator.isValid(cnpj, null));
        }
    }
}