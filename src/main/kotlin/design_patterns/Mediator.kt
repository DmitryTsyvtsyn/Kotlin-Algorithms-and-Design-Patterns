package design_patterns

/**
 *
 * Mediator is a behavioral design pattern that reduces the coupling of many classes among themselves
 *
 * by moving these couplings into one mediator class
 *
 */

// SoftwareDevelopmentManager is a mediator for the customer, designer, programmer and tester
class SoftwareDevelopmentManager {

    private lateinit var customer: SoftwareDevelopmentMember
    private lateinit var designer: SoftwareDevelopmentMember
    private lateinit var programmer: SoftwareDevelopmentMember
    private lateinit var tester: SoftwareDevelopmentMember

    fun changeCustomer(member: SoftwareDevelopmentMember) { customer = member }
    fun changeDesigner(member: SoftwareDevelopmentMember) { designer = member }
    fun changeProgrammer(member: SoftwareDevelopmentMember) { programmer = member }
    fun changeTester(member: SoftwareDevelopmentMember) { tester = member }

    private val stages = mutableListOf<String>()
    val stagesAsString: String
        get() = stages.joinToString("\n")

    // members do not interact directly with each other because the mediator does it
    // which reduces the coupling between them
    fun nextStage(work: String, member: SoftwareDevelopmentMember) {
        val finishedStage = when (member) {

            is CustomerSoftwareDevelopmentMember -> designer.receiveWork(work)

            is DesignerSoftwareDevelopmentMember -> programmer.receiveWork(work)

            is ProgrammerSoftwareDevelopmentMember -> tester.receiveWork(work)

            is TesterSoftwareDevelopmentMember -> customer.receiveWork(work)

            else -> ""
        }

        stages.add(finishedStage)
    }

}

// SoftwareDevelopmentMember works with other members through the mediator
abstract class SoftwareDevelopmentMember(protected val mediator: SoftwareDevelopmentManager) {

    abstract fun receiveWork(work: String): String

    abstract fun finishWork()

}

class CustomerSoftwareDevelopmentMember(mediator: SoftwareDevelopmentManager) : SoftwareDevelopmentMember(mediator) {
    override fun receiveWork(work: String) = "Customer accepted the work: $work"

    override fun finishWork() {
        mediator.nextStage("design development", this)
    }
}

class DesignerSoftwareDevelopmentMember(mediator: SoftwareDevelopmentManager) : SoftwareDevelopmentMember(mediator) {
    override fun receiveWork(work: String) = "Designer accepted the work: $work"

    override fun finishWork() {
        mediator.nextStage("writing code", this)
    }
}

class ProgrammerSoftwareDevelopmentMember(mediator: SoftwareDevelopmentManager) : SoftwareDevelopmentMember(mediator) {
    override fun receiveWork(work: String) = "Programmer accepted the work: $work"

    override fun finishWork() {
        mediator.nextStage("application testing", this)
    }
}

class TesterSoftwareDevelopmentMember(mediator: SoftwareDevelopmentManager) : SoftwareDevelopmentMember(mediator) {
    override fun receiveWork(work: String) = "Tester accepted the work: $work"

    override fun finishWork() {
        mediator.nextStage("business valuation", this)
    }
}