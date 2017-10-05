package de.eightbitboy.ecorealms.map

import spock.lang.Specification

class MapSpec extends Specification {

	def "the map has the correct size"() {
		when:
		Map map = new Map(10, 10)

		then:
		map.sizeX == 10
		map.sizeY == 10
	}

	def "add an entity to the map"() {

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