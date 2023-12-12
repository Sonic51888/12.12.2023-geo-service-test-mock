package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class GeoServiceImplTestOne {

    @Test
    public void test_GeoService_byIp_on_countrys() {
        GeoService geoService = new GeoServiceImpl();

        Map ipLocation = new HashMap<String, Location>();
        ipLocation.put("127.0.0.1", new Location(null, null, null, 0));
        ipLocation.put("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        ipLocation.put("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32));
        ipLocation.put("172.66.7.9", new Location("Moscow", Country.RUSSIA, null, 0));
        ipLocation.put("96.8.344.1", new Location("New York", Country.USA, null, 0));
        Set<String> setKeyIpLocation = ipLocation.keySet();

        setKeyIpLocation.stream().forEach(x -> {
            Assertions.assertEquals(geoService.byIp(x), ipLocation.get(x));
        });
    }

}