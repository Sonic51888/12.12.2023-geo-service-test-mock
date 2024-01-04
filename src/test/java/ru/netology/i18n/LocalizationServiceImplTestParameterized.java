package ru.netology.i18n;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTestParameterized {
    LocalizationServiceImpl localizationServiceTest = new LocalizationServiceImpl();


    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"RUSSIA"})
    void testLocalRussiaa(Country country) {
        String actual = localizationServiceTest.locale(country);
        String expected = "Добро пожаловать";
        assertEquals(expected, actual);

    }
    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"GERMANY", "USA", "BRAZIL"})
    void testLocalWelcome(Country country) {
        String result = localizationServiceTest.locale(country);
        String expected = "Welcome";
        assertEquals(expected, result);
    }
}
