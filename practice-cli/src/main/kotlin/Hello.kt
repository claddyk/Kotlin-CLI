import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument

class MyCommand : CliktCommand() {
    private val myArg by argument()

    override fun run() {
        println("My argument is: $myArg")
    }
}
