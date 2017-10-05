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
        map.getEntities().length == 100
    }

    def "add an entity to the map"() {
        when:
        map.put(new TestMapEntity(5, 5))

        then:
        noExceptionThrown()
    }

    def "entities are added at the correct position"(int x, int y, int index) {
        when:
        Map map = new Map(4, 4)
        TestMapEntity entity = new TestMapEntity(x, y)
        map.put(entity)

        then:
        map.entities[index] == entity

        where:
        x | y || index
        0 | 0 || 0
        0 | 1 || 1
        0 | 2 || 2
        0 | 3 || 3
        1 | 0 || 4
        1 | 1 || 5
        3 | 3 || 15
    }

    def "remove an entity from the map"() {

    }

    def "remove an entity from the map at a certain position"() {

    }

    def "put an entity at a position where another one already exists fails"() {

    }

    def "add an entity with an invalid (outside of map) position to the map"(int x, int y) {
        when:
        map.put(new TestMapEntity(x, y))

        then:
        thrown(InvalidMapAccessException)

        where:
        x   | y
        +0  | -1
        -1  | +0
        -1  | -1
        -10 | -10
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

    @Override
    String toString() {
        return "TestMapEntity at (${position.x},${position.y})"
    }
}
