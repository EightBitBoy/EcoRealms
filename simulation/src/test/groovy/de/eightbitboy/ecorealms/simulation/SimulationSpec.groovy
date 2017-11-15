package de.eightbitboy.ecorealms.simulation

import de.eightbitboy.ecorealms.simulation.test.TestSimulationMember
import spock.lang.Specification
import spock.lang.Subject

class SimulationSpec extends Specification {

	@Subject
	Simulation simulation = new Simulation();

	def "add a simulation member"() {
		setup:
		SimulationMember member = new TestSimulationMember()

		when:
		simulation.addMember(member)

		then:
		simulation.getMembers().contains(member)
		simulation.getMembers().size() == 1
	}

	def "remove a simulation member"() {
		setup:
		SimulationMember member = new TestSimulationMember()
		simulation.addMember(member)

		when:
		simulation.removeMember(member)

		then:
		!simulation.getMembers().contains(member)
		simulation.getMembers().size() == 0
	}

	def "simulation members are updated on every tick"() {

	}
}
