package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import java.util.stream.Stream;

class GeoServiceImplTestParameterized {

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    public void test_GeoService_byIp_on_countrys(String key, Location ipLocation) {
        GeoService geoService = new GeoServiceImpl();
        Assertions.assertEquals(geoService.byIp(key), ipLocation);
    }
    public static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.66.7.9", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.8.344.1", new Location("New York", Country.USA, null, 0))

        );
    }
}