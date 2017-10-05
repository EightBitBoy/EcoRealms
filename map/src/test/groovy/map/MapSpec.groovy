package de.eightbitboy.ecorealms.map

import spock.lang.Specification
import spock.lang.Subject

class MapSpec extends Specification {

    @Subject
    private Map map = new Map(10, 10)

    def "the map has the correct size"() {
        expect:
        map.sizeX == 10
        map.sizeY == 10
    }

    def "add an entity to the map"() {
        when:
        map.put(new TestMapEntity(0, 0))

        then:
        noExceptionThrown()
    }

    def "add an entity with an invalid position to the map"() {
        when:
        map.put(new TestMapEntity(x, y))

        then:
        thrown(IllegalStateException)

        where:
        x   | y
        -1  | -1
        -10 | -10
        0   | -1
        -1  | 0
    }
}

class TestMapEntity implements MapEntity {

    private MapPoint position;

    TestMapEntity(int positionX, int positionY) {
        position = new MapPoint(positionX, positionY)
    }

    @Override
    MapPoint getPosition() {
        return position
    }

    @Override
    int getSizeX() {
        return 1
    }

    @Override
    int getSizeY() {
        return 1
    }
}