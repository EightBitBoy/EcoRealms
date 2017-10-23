package de.eightbitboy.ecorealms.simulation

import spock.lang.Specification
import spock.lang.Subject

class InventorySpec extends Specification {

    @Subject
    private Inventory inventory = new Inventory()

    def "a new inventory is empty"() {
        when:
        Set<Resource> resources = inventory.getResources()

        then:
        resources.isEmpty()
        resources.every { !resources.contains(it) }
    }

    def "add a resource"() {
        when:
        inventory.add(Resource.Fish, 5)

        then:
        !inventory.getResources().isEmpty()
        inventory.getResources().size() == 1
        inventory.getResources().contains(Resource.Fish)
        inventory.get(Resource.Fish) == 5
    }

    def "get a resource"() {
        setup:
        inventory.add(Resource.Fish, 3)

        when:
        int amount = inventory.get(Resource.Fish)

        then:
        amount == 3
        inventory.get(Resource.Fish) == 3
    }

    def "remove a resource"() {
        setup:
        inventory.add(Resource.Fish, 67)

        when:
        int amount = inventory.remove(Resource.Fish, 13)

        then:
        amount == 13
        inventory.get(Resource.Fish) == 54
    }

    def "remove a resource which is not available"() {
        when:
        int amount = inventory.remove(Resource.Stone, 7)

        then:
        amount == 0
    }

    def "remove more of a resource that available"() {
        setup:
        inventory.add(Resource.Fish, 18)

        when:
        int amount = inventory.remove(Resource.Fish, 44)

        then:
        amount == 18
        inventory.get(Resource.Fish) == 0
        inventory.getResources().isEmpty()
    }

    def "remove a resource completely"() {
        setup:
        inventory.add(Resource.Fish, 87)

        when:
        inventory.remove(Resource.Fish, 87)

        then:
        inventory.get(Resource.Fish) == 0
        inventory.getResources().isEmpty()
    }

    //TODO Test resource limits?
}
