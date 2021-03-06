package de.eightbitboy.ecorealms.map

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

// TODO
// https://stackoverflow.com/questions/1827677/how-to-do-a-junit-assert-on-a-message-in-a-logger
// http://projects.lidalia.org.uk/slf4j-test/

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
        map.getEntities().contains(entity1)
        !map.getEntities().contains(entity2)
    }

    def "add an entity with an invalid (outside of map) position to the map"(int x, int y) {
        setup:
        TestMapEntity entity = new TestMapEntity(x, y)

        when:
        map.put(entity)

        then:
        !map.getEntities().contains(entity)

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
        map.get(new Position(1, 1)) == entity
    }

    def "return null if an entity does not exist at a certain position"() {
        expect:
        map.get(new Position(1, 1)) == null
    }

    def "remove an entity from the map"() {
        setup:
        TestMapEntity entity = new TestMapEntity(1, 1)
        map.put(entity)

        expect:
        map.entities.contains(entity)

        when:
        map.remove(entity)

        then:
        !map.getEntities().contains(entity)
    }

    def "a position can be free or occupied"() {
        setup:
        map.put(new TestMapEntity(3, 8))

        expect:
        map.isClear(new Position(1, 1))
        !map.isClear(new Position(3, 8))
    }
}

class TestMapEntity implements MapEntity {

    private Position position;

    TestMapEntity(int positionX, int positionY) {
        position = new Position(positionX, positionY)
    }

    @Override
    Position getPosition() {
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
