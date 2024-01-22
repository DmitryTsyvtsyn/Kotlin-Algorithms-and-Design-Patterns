package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class MediatorTest {

    @Test
    fun test() {
        val manager = SoftwareDevelopmentManager()

        val customer = CustomerSoftwareDevelopmentMember(manager)
        manager.changeCustomer(customer)
        val designer = DesignerSoftwareDevelopmentMember(manager)
        manager.changeDesigner(designer)
        val programmer = ProgrammerSoftwareDevelopmentMember(manager)
        manager.changeProgrammer(programmer)
        val tester = TesterSoftwareDevelopmentMember(manager)
        manager.changeTester(tester)

        customer.finishWork()
        designer.finishWork()
        programmer.finishWork()
        tester.finishWork()

        assertEquals("""
            Designer accepted the work: design development
            Programmer accepted the work: writing code
            Tester accepted the work: application testing
            Customer accepted the work: business valuation
        """.trimIndent(), manager.stagesAsString)
    }

}