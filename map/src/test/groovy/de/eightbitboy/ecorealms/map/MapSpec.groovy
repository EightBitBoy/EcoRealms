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
        TestMapEntity entity = new TestMapEntity(5, 5)
        map.put(entity)

        then:
        noExceptionThrown()
        map.getEntities().contains(entity)
    }

    def "entities are added at the correct position"(int x, int y, int index) {
        when:
        Map map = new Map(3, 5)
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
        0 | 4 || 4

        1 | 0 || 5
        1 | 1 || 6
        1 | 2 || 7
        1 | 3 || 8
        1 | 4 || 9

        2 | 0 || 10
        2 | 1 || 11
        2 | 2 || 12
        2 | 3 || 13
        2 | 4 || 14
    }


    def "put an entity at a position where another one already exists fails"() {
        setup:
        TestMapEntity entity1 = new TestMapEntity(1, 1)
        TestMapEntity entity2 = new TestMapEntity(1, 1)
        map.put(entity1)

        when:
        map.put(entity2)

        then:
        thrown(InvalidMapAccessException)
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

    def "get an entity a certain position"() {
        setup:
        TestMapEntity entity = new TestMapEntity(1, 1)
        map.put(entity)

        expect:
        map.get(new MapPoint(1, 1)) == entity
    }

    def "return null if an entity does not exist at a certain position"() {
        expect:
        map.get(new MapPoint(1, 1)) == null
    }

    def "remove an entity from the map"() {
        when:
        TestMapEntity entity = new TestMapEntity(1, 1)
        map.put(entity)

        expect:
        map.entities.contains(entity)

        when:
        map.remove(entity)

        then:
        !map.getEntities().contains(entity)
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
