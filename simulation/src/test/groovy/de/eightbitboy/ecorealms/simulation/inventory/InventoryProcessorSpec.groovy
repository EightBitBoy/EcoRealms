package de.eightbitboy.ecorealms.simulation.inventory

import de.eightbitboy.ecorealms.simulation.resource.Resource
import spock.lang.Specification
import spock.lang.Subject

class InventoryProcessorSpec extends Specification {

    @Subject
    private InventoryProcessor processor = new InventoryProcessor()
    private Inventory inventory = new Inventory()

    def "a new inventory is empty"() {
        when:
        Set<Resource> resources = processor.getResources(inventory)

        then:
        resources.isEmpty()
        resources.every { !resources.contains(it) }
    }

    def "add a resource"() {
        when:
        processor.add(inventory, Resource.Fish, 5)

        then:
        !processor.getResources(inventory).isEmpty()
        processor.getResources(inventory).size() == 1
        processor.getResources(inventory).contains(Resource.Fish)
        processor.get(inventory, Resource.Fish) == 5
    }

    def "cannot add a negative amount"() {
        when:
        processor.add(inventory, Resource.Fish, -45)

        then:
        thrown(RuntimeException)
    }

    def "get a resource"() {
        setup:
        processor.add(inventory, Resource.Fish, 3)

        when:
        int amount = processor.get(inventory, Resource.Fish)

        then:
        amount == 3
        processor.get(inventory, Resource.Fish) == 3
    }

    def "remove a resource"() {
        setup:
        processor.add(inventory, Resource.Fish, 67)

        when:
        int amount = processor.remove(inventory, Resource.Fish, 13)

        then:
        amount == 13
        processor.get(inventory, Resource.Fish) == 54
    }

    def "cannot remove a negative amount"() {
        setup:
        processor.add(inventory, Resource.Fish, 89)

        when:
        processor.remove(inventory, Resource.Fish, -3)

        then:
        thrown(RuntimeException)
    }

    def "remove a resource which is not available"() {
        when:
        int amount = processor.remove(inventory, Resource.Stone, 7)

        then:
        amount == 0
        !processor.getResources(inventory).contains(Resource.Stone)
    }

    def "remove more of a resource than available"() {
        setup:
        processor.add(inventory, Resource.Fish, 18)

        when:
        int amount = processor.remove(inventory, Resource.Fish, 44)

        then:
        amount == 18
        processor.get(inventory, Resource.Fish) == 0
        processor.getResources(inventory).isEmpty()
    }

    def "remove a resource completely"() {
        setup:
        processor.add(inventory, Resource.Fish, 87)

        when:
        processor.remove(inventory, Resource.Fish, 87)

        then:
        processor.get(inventory, Resource.Fish) == 0
        processor.getResources(inventory).isEmpty()
    }

    //TODO Test resource amount limits?
}
