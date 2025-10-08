package com.fiapchallenge.garage.unit.validation;

import com.fiapchallenge.garage.application.validation.CpfCnpjValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CpfCnpjValidatorUnitTest {

    private CpfCnpjValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CpfCnpjValidator();
    }

    @Test
    void shouldReturnFalseForNullValue() {
        assertFalse(validator.isValid(null, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "\t", "\n"})
    void shouldReturnFalseForEmptyOrBlankValues(String value) {
        assertFalse(validator.isValid(value, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12345", "123456789", "12345678901234567890"})
    void shouldReturnFalseForInvalidLength(String value) {
        assertFalse(validator.isValid(value, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11144477735", "12345678909", "98765432100"})
    void shouldReturnTrueForValidCpf(String cpf) {
        assertTrue(validator.isValid(cpf, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"111.444.777-35", "123.456.789-09", "987.654.321-00"})
    void shouldReturnTrueForValidFormattedCpf(String cpf) {
        assertTrue(validator.isValid(cpf, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"00000000000", "11111111111", "22222222222", "99999999999"})
    void shouldReturnFalseForCpfWithAllSameDigits(String cpf) {
        assertFalse(validator.isValid(cpf, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678901", "11144477736", "98765432101"})
    void shouldReturnFalseForInvalidCpf(String cpf) {
        assertFalse(validator.isValid(cpf, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11222333000181", "12345678000195", "11444777000161"})
    void shouldReturnTrueForValidCnpj(String cnpj) {
        assertTrue(validator.isValid(cnpj, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11.222.333/0001-81", "12.345.678/0001-95", "11.444.777/0001-61"})
    void shouldReturnTrueForValidFormattedCnpj(String cnpj) {
        assertTrue(validator.isValid(cnpj, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"00000000000000", "11111111111111", "22222222222222", "99999999999999"})
    void shouldReturnFalseForCnpjWithAllSameDigits(String cnpj) {
        assertFalse(validator.isValid(cnpj, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678000100", "11222333000180", "98765432000101"})
    void shouldReturnFalseForInvalidCnpj(String cnpj) {
        assertFalse(validator.isValid(cnpj, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12a45", "111.444.777-3a", "11.222.333/000a-81"})
    void shouldReturnFalseForNonNumericCharacters(String value) {
        assertFalse(validator.isValid(value, null));
    }
}
