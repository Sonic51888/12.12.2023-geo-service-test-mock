package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

class LocalizationServiceImplTestParameterized {

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    void test_locale(String welcome, Country country) {
        LocalizationService localizationService = new LocalizationServiceImpl();
    }

    public static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of("Добро пожаловать", Country.RUSSIA),
                Arguments.of("Welcome", Country.USA),
                Arguments.of("Welcome", Country.GERMANY),
                Arguments.of("Welcome", Country.BRAZIL)
        );
    }

}