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

		when:
		map.put(new TestMapEntity(-1, -1))

		then:
		thrown(IllegalStateException)
	}

    def "add an entity with an invalid position to the map"(){
        
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