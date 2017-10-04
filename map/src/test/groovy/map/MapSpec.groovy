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
}
