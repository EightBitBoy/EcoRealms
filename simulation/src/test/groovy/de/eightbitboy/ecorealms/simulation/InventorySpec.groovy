package de.eightbitboy.ecorealms.simulation

import spock.lang.Specification

class InventorySpec extends Specification {

    def "a new inventory is empty"() {
        setup:
        Inventory inventory = new Inventory()

        when:
        Set<Resource> resources = inventory.getResources()

        then:
        resources.isEmpty()
        resources.every { !resources.contains(it) }
    }

    def "add a resource"() {
        setup:
        def inventory = new Inventory()

        when:
        inventory.add(Resource.Fish, 1)

        then:
        inventory.getResources().size() == 1
        inventory.getResources().contains(Resource.Fish)
    }

    def "get a resource"() {
        setup:
        Inventory inventory = new Inventory()
        inventory.add(Resource.Fish, 1)

        when:
        int amount = inventory.get(Resource.Fish)

        then:
        amount == 1
    }

    def "remove a resource"() {

    }

    def "remove more of a resource that available"() {

    }

    def "remove all resources"() {
        setup:
        def inventory = new Inventory()
        inventory.add(Resource.Fish, 1)
    }

    //TODO resource limit?
}
